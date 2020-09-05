package com.xdd.service.impl;

import com.xdd.dao.OrderMapper;
import com.xdd.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xld.pojo.Order;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcs
 * @since 2020-09-05
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
