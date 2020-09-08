package com.xdd.service;

import com.xld.pojo.Goods;

import java.util.List;

public interface SeckillService {
    List<Goods> findAll(String time);
    Goods findById(Integer id);
}
