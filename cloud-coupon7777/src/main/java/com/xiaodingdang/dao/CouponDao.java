package com.xiaodingdang.dao;

import com.xld.pojo.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface CouponDao {
    public List<Coupon> findAll();
    public List<Coupon> findByUserId( Integer userId);
    public Integer addCoupon(Coupon coupon);
    public Integer updateCoupon(Coupon coupon);
    public Integer deleteCoupon(Integer couponId);
}
