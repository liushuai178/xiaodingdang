package com.xdd.service.impl;

import com.xdd.dao.GoodsDao;
import com.xdd.service.SeckillService;
import com.xld.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Goods findById() {
        return goodsDao.findById();
    }
}
