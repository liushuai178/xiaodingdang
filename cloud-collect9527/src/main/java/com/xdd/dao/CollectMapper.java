package com.xdd.dao;


import com.xld.pojo.Collect;
import com.xld.pojo.Goods;
import com.xld.pojo.Store;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CollectMapper {

    int addGoods(Collect collect);

    List<Goods> findAllGoods(Integer userId);

    int updateGoods(Collect collect);

    int addStore(Collect collect);

    List<Store> findAllStore(Integer userId);

    int updateStore(Collect collect);

    List<Goods> findAllRecord(Integer userId);

    Collect findById(Collect collect);

    int updateRecord(Collect collect);

    int deleteRecord(Collect collect);
}
