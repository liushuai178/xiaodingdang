package com.xdd.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import com.xdd.service.SeckillService;
import com.xld.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private RedisTemplate redisTemplate;

    //创建布隆过滤器
    BloomFilter bloomFilter = BloomFilter.create(
            Funnels.stringFunnel(Charset.defaultCharset()),10000,0.03);



    //查询当天的全部秒杀商品，只显示当天
    @GetMapping("seckill/findAll")
    public List<Goods> findAll() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);
        System.out.println(time);

        //先从redis缓存中查询
        String result = (String) redisTemplate.opsForValue().get("goodsList"+time);
        List<Goods> goodsList = JSON.parseArray(result, Goods.class);

        //如果查询不到，就去数据库查找,并将数据写入redis
        if (goodsList == null){
            goodsList = seckillService.findAll(time);
            redisTemplate.opsForValue().set("goodsList"+time, JSON.toJSON(goodsList).toString(),10, TimeUnit.SECONDS);
        }
        return goodsList;

    }


    @GetMapping("seckill/findById/{id}")
    public Goods findById(@PathVariable Integer id){
        String key = "goods#"+id;
        //判断布隆过滤器中是否存在，如果布隆过滤器中不存在，则redis中肯定不存在
        //如果过滤器中存在，则redis中可能存在(过滤器有误判的可能)
        Goods goods = null;

            boolean contain = bloomFilter.mightContain(key);

            if (contain) {//如果过滤器中存在
                //从redis中取出数据
                System.out.println("从redis中取数据");
                goods = (Goods) redisTemplate.opsForValue().get(key);
                //再次判断是否是误判,从redis中取出来数据并不为空，则不是过滤器误判
                if (goods != null) {
                    return goods;//不是误判直接返回
                } else {//是误判的话就再次添加进redis中
                    System.out.println("发生误判");
                    goods = seckillService.findById(id);
                    if (goods != null) {
                        redisTemplate.opsForValue().set(key, goods, 60, TimeUnit.SECONDS);
                    } else {//如果数据库中已经没有这个值则redis存储一个null
                        redisTemplate.opsForValue().set(key, null, 10, TimeUnit.SECONDS);
                    }
                }

            } else {//如果不存在，则去数据库中查找
                System.out.println("过滤器中不存在，查找数据库");
                goods = seckillService.findById(id);
                //然后将数据存入布隆过滤器中，以方便下次直接查找
                bloomFilter.put(key);
                //然后再存入redis中
                redisTemplate.opsForValue().set(key, goods, 10, TimeUnit.SECONDS);
            }
        return goods;
    }

}
