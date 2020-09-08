package com.xdd.dao;

import com.xld.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    List<Goods> findAll(String time);
    Goods findById(Integer id);
}
