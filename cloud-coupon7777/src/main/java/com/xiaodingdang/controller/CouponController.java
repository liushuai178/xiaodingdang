package com.xiaodingdang.controller;

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
        List<Coupon> userId1 = couponServicce.findByUserId(userId);
        //redisTemplate.opsForList().leftPush("user:"+userId,userId1.get(0));
        //redisTemplate.opsForList().leftPop("user:"+userId);
        System.out.println(userId1.size());
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
