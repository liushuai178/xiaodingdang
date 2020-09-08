package com.xdd.controller;

import com.xdd.service.CollectService;
import com.xld.pojo.Collect;
import com.xld.pojo.Goods;
import com.xld.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
    //收藏商品
    @PostMapping("addGoods")
    public int addGoods(Collect collect){
        collect.setCollectGoods(1);
        int i = collectService.addGoods(collect);
        return i;
    }
    //查看所有收藏商品
    @GetMapping("findAllGoods")
    public List<Goods> findAllGoods(Integer userId){
       return collectService.findAllGoods(userId);
    }
    //取消收藏商品
    @PutMapping("updateGoods")
    public int updateGoods(Collect collect){
        return collectService.updateGoods(collect);
    }

    //收藏店铺
    @RequestMapping("addStore")
    public int addStore(Collect collect){
        collect.setCollectStore(1);
        return collectService.addStore(collect);
    }
    //查看所有收藏的店铺
    @RequestMapping("findAllStore")
    public List<Store> findAllStore(Integer userId){
        return collectService.findAllStore(userId);
    }
    //删除收藏的店铺
    @RequestMapping("updateStore")
    public int updateStore(Collect collect){
        return collectService.updateStore(collect);
    }
    //添加浏览历史
    //判断下这个商品，用户id是不是在表中已有，有的话直接再后边修改goodsRecord为1
    //如果没有的话，添加商品id与用户id在表中，同时goodsRecord默认为1
    @RequestMapping("findAllRecord")
    public List<Goods> findAllRecord(Integer userId){
        return collectService.findAllRecord(userId);
    }
    //添加历史记录
    @RequestMapping("addRecord")
    public int addRecord(Collect collect){
        Collect collect1 = findById(collect);
        int i = 0;
        if (collect1==null){
            int i1 = addRecord1(collect);
            i = i1;
        } else {
            int i1 = updateRecord(collect);
            i1 = i;
        }
        return i;
    }
    //根据用户id和商品id查询collect表
    @RequestMapping("findById")
    public Collect findById(Collect collect){
        Collect collect1 = collectService.findById(collect);
        System.out.println(collect1);
        return collect1;
    }
    //增加新的用户id和商品id 并把浏览记录状态改为1
    public int addRecord1(Collect collect){
        collect.setGoodsRecord(1);

        return collectService.addGoods(collect);
    }
    //把原有的用户id加商品id的浏览记录改为1
    @RequestMapping("updateRecord")
    public int updateRecord(Collect collect){
       return collectService.updateRecord(collect);
    }
     //删除浏览记录
    @RequestMapping("deleteRecord")
    public int deleteRecord(Collect collect){
        return collectService.deleteRecord(collect);
    }
}
