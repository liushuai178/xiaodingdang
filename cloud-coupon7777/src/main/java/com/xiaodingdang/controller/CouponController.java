package com.xiaodingdang.controller;

import com.alibaba.fastjson.JSON;
import com.xiaodingdang.service.CouponServicce;
import com.xld.pojo.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coupon")
public class CouponController {
    @Autowired
    private CouponServicce couponServicce;
    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/findAll")
    public List<Coupon> findAll(){

     return couponServicce.findAll();
   }

    @GetMapping("/findByUserId/{userId}")
    public List<Coupon> findByUserId(@PathVariable("userId")Integer userId){
        System.out.println("userId:"+userId);
        String s =(String) redisTemplate.opsForValue().get("coupon:"+userId);
        List<Coupon> coupons = JSON.parseArray(s, Coupon.class);
        if (null!=coupons){
            System.out.println("从redis中查到数据");
            return coupons;
        }
        List<Coupon> userId1 = couponServicce.findByUserId(userId);
        redisTemplate.opsForValue().set("coupon:"+userId, JSON.toJSONString(userId1));
        System.out.println("从数据库中查到数据");
        return userId1;
    }

    @PostMapping("/addCoupon")
    public String addCoupon(Coupon coupon){
        System.out.println("coupon"+coupon);
        Integer count = couponServicce.addCoupon(coupon);
        if(count>0){
            return " add success";
        }
        return "add false";
    }

    @PutMapping("/updateCoupon")
    public String updateCoupon(Coupon coupon){
        System.out.println("coupon"+coupon);
        Integer count = couponServicce.updateCoupon(coupon);
        if(count>0){
            return " update success";
        }
        return "update false";
    }
    @DeleteMapping("/deleteCoupon/{couponId}")
    public String deleteCoupon(@PathVariable("couponId") Integer couponId){
        System.out.println(couponId);
        Integer count = couponServicce.deleteCoupon(couponId);
        if(count>0){
            return " delete success";
        }
        return "delete false";
    }
}
