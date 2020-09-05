package com.xdd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xdd.service.impl.OrderServiceImpl;
import com.xld.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lcs
 * @since 2020-09-05
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("findAll")
    public List<Order> find(/*@RequestParam("order_id")Integer order_id*/){
//        System.out.println("find: "+order_id);
//        QueryWrapper<Order> wrapper = new QueryWrapper<>();

        List<Order> list = orderService.list(null);
        System.out.println(list);
        return  list;
    }

}
