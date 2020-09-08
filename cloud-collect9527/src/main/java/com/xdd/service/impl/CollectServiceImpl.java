package com.xdd.service.impl;

import com.xdd.dao.CollectMapper;
import com.xdd.service.CollectService;

import com.xld.pojo.Collect;
import com.xld.pojo.Goods;
import com.xld.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int addGoods(Collect collect) { return collectMapper.addGoods(collect);
    }

    @Override
    public List<Goods> findAllGoods(Integer userId) {
        return collectMapper.findAllGoods(userId);
    }

    @Override
    public int updateGoods(Collect collect) {
        return collectMapper.updateGoods(collect);
    }

    @Override
    public int addStore(Collect collect) {
        return collectMapper.addStore(collect);
    }

    @Override
    public List<Store> findAllStore(Integer userId) {
        return collectMapper.findAllStore(userId);
    }

    @Override
    public int updateStore(Collect collect) {
        return collectMapper.updateStore(collect);
    }

    @Override
    public List<Goods> findAllRecord(Integer userId) {
        return collectMapper.findAllRecord(userId);
    }

    @Override
    public Collect findById(Collect collect) {
        return collectMapper.findById(collect);
    }

    @Override
    public int updateRecord(Collect collect) {
        return collectMapper.updateRecord(collect);
    }

    @Override
    public int deleteRecord(Collect collect) {
        return collectMapper.deleteRecord(collect);
    }
}
