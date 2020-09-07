package com.xdd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xdd.service.impl.OrderServiceImpl;
import com.xld.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

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

    /**
     * 创建订单
     * @param order
     * @return
     */
    @PostMapping("createOrder")
    public Map createOrder(Order order){
        System.out.println(order);
        HashMap<Object, Object> map = new HashMap<>();
        order.setCreateTime(new Date());
        boolean save = orderService.save(order);
        map.put("status",save);
        return map;
    }

    /**
     * 近一月
     * @return
     */
    @GetMapping("timeOnemonth")
    public Map timeOnemonth(){
        HashMap<Object, Object> map = new HashMap<>();
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DATE_FORMAT(create_time,'%Y')",LocalDate.now().getYear());
        queryWrapper.eq("DATE_FORMAT(create_time,'%m')",LocalDate.now().minusMonths(1).getMonth());
        List<Order> orders = orderService.list(queryWrapper);
        map.put("data",orders);
        return map;
    }

    /**
     * 三月
     * @return
     */
    @GetMapping("time3month")
    public Map time3month(){
        HashMap<Object, Object> map = new HashMap<>();
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DATE_FORMAT(create_time,'%Y')",LocalDateTime.now().getYear());
        queryWrapper.between("DATE_FORMAT(create_time,'%m')", LocalDate.now().minusMonths(3).getMonth(),LocalDate.now().getMonth());
        List<Order> orders = orderService.list(queryWrapper);
        map.put("data",orders);
        return map;
    }

    /**
     * 今年
     * @return
     */
    @GetMapping("thisYear")
    public Map thisYear(){
        HashMap<Object, Object> map = new HashMap<>();
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DATE_FORMAT(create_time,'%Y')",LocalDate.now().getYear());
        List<Order> orders = orderService.list(queryWrapper);
        map.put("data",orders);
        return map;
    }

    /**
     * 前一年的订单
     * @return
     */
    @GetMapping("LastYear")
    public Map timeLastYear(){
        HashMap<Object, Object> map = new HashMap<>();
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DATE_FORMAT(create_time,'%Y')",LocalDate.now().minusYears(1).getYear());
        List<Order> orders = orderService.list(queryWrapper);
        map.put("data",orders);
        return map;
    }

    /**
     * 更早时间的订单
     * @return
     */
    @GetMapping("earlier")
    public Map timeEarlier(){
        HashMap<Object, Object> map = new HashMap<>();
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("DATE_FORMAT(create_time,'%Y')", LocalDate.now().minusYears(1).getYear());
        List<Order> orders = orderService.list(queryWrapper);
        map.put("data",orders);
        return map;
    }
    /**
     * 全部订单
     * @return
     */
    @GetMapping("findAll")
    public List<Order> find(/*@RequestParam("order_id")Integer order_id*/){
//        System.out.println("find: "+order_id);
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("dissapper_status",0);
        List<Order> list = orderService.list(null);
        System.out.println(list);
        return  list;
    }

    /**
     * 查询全部状态
     * @return
     */
    @GetMapping("findAllStatus")
    public Map findAllStatus(){
//        System.out.println("find: "+order_id);
        HashMap<Object, Object> map = new HashMap<>();
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper .and(queryWrapper -> {
            queryWrapper.isNull("pay_status").or().eq("pay_status", "1");
            queryWrapper.isNull("goods_status").or().eq("goods_status", "1");
            queryWrapper.isNull("evaluate_status").or().eq("evaluate_status", "1");
            queryWrapper.isNull("refund_status").or().eq("refund_status", "1");
        }
        );
        wrapper.eq("dissapper_status",0);
        List<Order> list = orderService.list(wrapper);
        System.out.println(list);
        return  map;
    }

    /**
     * 退款订单
     * @return
     */
    @GetMapping("findRefund")
    public Map findRefund(){
//        System.out.println("find: "+order_id);
        HashMap<Object, Object> map = new HashMap<>();
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.isNull("refund_status").or().eq("refund_status", "1");
        wrapper.eq("dissapper_status",0);
        List<Order> list = orderService.list(wrapper);
        System.out.println(list);
        return  map;
    }


    /**
     * 待付款
     * @param order_id
     * @return
     */
    @GetMapping("findUnPay")
    public List<Order> findUnPay(@RequestParam(value = "order_id",required = false,defaultValue = "")Integer order_id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pay_status", 0);
        queryWrapper.eq("dissapper_status",0);
        List<Order> orderList = orderService.list(queryWrapper);
        return orderList;
    }

    /**
     * 待收货
     * @param order_id
     * @return
     */
    @GetMapping("findUnGetGoods")
    public List<Order> findUnGetGoods(@RequestParam(value = "order_id",required = false,defaultValue = "")Integer order_id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pay_status", 1);
        queryWrapper.eq("goods_status", 0);
        queryWrapper.eq("regoods_status", 0);
        queryWrapper.eq("dissapper_status",0);
        List<Order> orderList = orderService.list(queryWrapper);
        return orderList;
    }

    /**
     * 待确认收货
     * @param order_id
     * @return
     */
    @GetMapping("findRegoods")
    public List<Order> findRegoods(@RequestParam(value = "order_id",required = false,defaultValue = "")Integer order_id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pay_status", 1);
        queryWrapper.eq("goods_status", 1);
        queryWrapper.eq("regoods_status", 0);
        queryWrapper.eq("dissapper_status",0);
        List<Order> orderList = orderService.list(queryWrapper);
        return orderList;
    }

    /**
     * 交易成功
     * @param order_id
     * @return
     */
    @GetMapping("trdeSuccess")
    public List<Order> trdeSuccess(@RequestParam(value = "order_id",required = false,defaultValue = "")Integer order_id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pay_status", 1);
        queryWrapper.eq("goods_status", 1);
        queryWrapper.eq("regoods_status", 1);
        queryWrapper.eq("dissapper_status",0);
        List<Order> orderList = orderService.list(queryWrapper);
        return orderList;
    }

    /**
     * 待评论
     * @param order_id
     * @return
     */
    @GetMapping("findUnEvaluate")
    public List<Order> findUnEvaluate(@RequestParam(value = "order_id",required = false,defaultValue = "")Integer order_id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pay_status", 1);
        queryWrapper.eq("goods_status", 1);
        queryWrapper.eq("evaluate_status", 0);
        queryWrapper.eq("dissapper_status",0);
        List<Order> orderList = orderService.list(queryWrapper);
        return orderList;
    }

    /**
     * 已付款
     * @param order_id
     * @return
     */
    @PutMapping("pay")
    public Map pay(@RequestParam(value = "order_id",required = true)Integer order_id){
        System.out.println("pay: "+order_id);
        HashMap<Object, Object> map = new HashMap<>();
        Order order = new Order();
        order.setOrderId(order_id);
        order.setPayStatus(1);
        boolean updateById = orderService.updateById(order);
        map.put("status",updateById);
        return map;
    }

    /**
     * 结束待收货
     * @param order_id
     * @return
     */
    @PutMapping("gotgoodstatus")
    public Map gotgoods(@RequestParam(value = "order_id",required = true)Integer order_id){
        System.out.println("pay: "+order_id);
        HashMap<Object, Object> map = new HashMap<>();
        Order order = new Order();
        order.setOrderId(order_id);
        order.setGoodsStatus(1);
        boolean updateById = orderService.updateById(order);
        map.put("status",updateById);
        return map;
    }

    /**
     * 确认收货
     * @param order_id
     * @return
     */
    @PutMapping("reGotgoods")
    public Map reGotgoods(@RequestParam(value = "order_id",required = true)Integer order_id){
        System.out.println("pay: "+order_id);
        HashMap<Object, Object> map = new HashMap<>();
        Order order = new Order();
        order.setOrderId(order_id);
        order.setRegoodsStatus(1);
        boolean updateById = orderService.updateById(order);
        map.put("status",updateById);
        return map;
    }

    /**
     * 完成评价
     * @param order_id
     * @return
     */
    @PutMapping("gotEvaluate")
    public Map gotEvaluate(@RequestParam(value = "order_id",required = true)Integer order_id){
        System.out.println("pay: "+order_id);
        HashMap<Object, Object> map = new HashMap<>();
        Order order = new Order();
        order.setOrderId(order_id);
        order.setEvaluateStatus(1);
        boolean updateById = orderService.updateById(order);
        map.put("status",updateById);
        return map;
    }

    /**
     * 销毁订单
     * @param order_id
     * @return
     */
    @DeleteMapping("deleteOrder/{order_id}")
    public Map deleteOrder(@PathVariable("order_id")Integer order_id){
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(new Date());
        Order order = new Order();
        order.setOrderId(order_id);
        order.setDissapperStatus(1);
        order.setOrderEndtime(new Date());
        boolean updateById = orderService.updateById(order);
        map.put("status",updateById);
        return map;
    }

}
