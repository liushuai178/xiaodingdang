package com.xdd.dao;

import com.xld.pojo.Goods;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDao {
    Goods findById();
}
