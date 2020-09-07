package com.xiaodingdang.service.impl;

import com.xiaodingdang.dao.CouponDao;
import com.xiaodingdang.service.CouponServicce;
import com.xld.pojo.Coupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

@Service
public class CouonServiceImpl implements CouponServicce {
    @Resource
    private CouponDao couponDao;

    @Override
    public List<Coupon> findAll() {
        return couponDao.findAll();
    }

    @Override
    public List<Coupon> findByUserId(Integer userId) {
        return couponDao.findByUserId(userId);
    }

    @Override
    public Integer addCoupon(Coupon coupon) {
        return couponDao.addCoupon(coupon);
    }

    @Override
    public Integer updateCoupon(Coupon coupon) {
        return couponDao.updateCoupon(coupon);
    }

    @Override
    public Integer deleteCoupon(Integer couponId) {
        return couponDao.deleteCoupon(couponId);
    }
}
