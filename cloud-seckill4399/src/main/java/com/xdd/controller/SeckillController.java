package com.xdd.controller;

import com.xdd.service.SeckillService;
import com.xld.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @GetMapping("seckill/findById")
    public Goods findById() {
        return seckillService.findById();
    }

}
