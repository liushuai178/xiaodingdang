package com.xiaodingdang.service;

import com.xld.pojo.Coupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CouponServicce {
    public List<Coupon> findAll();
    public List<Coupon> findByUserId(Integer userId);
    public Integer addCoupon(Coupon coupon);
    public Integer updateCoupon(Coupon coupon);
    public Integer deleteCoupon(Integer couponId);
}
