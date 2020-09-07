package com.xdd.controller;

import com.alibaba.fastjson.JSON;
import com.xdd.service.SeckillService;
import com.xld.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("seckill/findAll")
    public List<Goods> findAll() {

        String result = (String) redisTemplate.opsForValue().get("goodsList");
        List<Goods> goodsList = JSON.parseArray(result, Goods.class);


        if (goodsList == null){
            System.out.println("在redis中未查找到数据");
            goodsList = seckillService.findAll();
            System.out.println("将数据从数据库中查找到然后存入redis");
            redisTemplate.opsForValue().set("goodsList", JSON.toJSON(goodsList).toString(),10, TimeUnit.SECONDS);
        }else {

            for (Goods goods: goodsList) {
                System.out.println(goods.toString());
            }

            redisTemplate.delete("goodsList");
            System.out.println("从redis中查找到数据");
        }
        return goodsList;
    }

    @GetMapping("seckill/findById/{id}")
    public Goods findById(@PathVariable Integer id){
        Goods goods = seckillService.findById(id);
        return goods;
    }

}
