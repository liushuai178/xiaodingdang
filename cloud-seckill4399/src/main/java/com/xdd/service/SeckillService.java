package com.xdd.service;

import com.xld.pojo.Goods;

import java.util.List;

public interface SeckillService {
    List<Goods> findAll();
    Goods findById(Integer id);
}
