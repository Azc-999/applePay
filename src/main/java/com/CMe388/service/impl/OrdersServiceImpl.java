package com.CMe388.service.impl;

import com.CMe388.dao.OrdersMapper;
import com.CMe388.pojo.Orders;
import com.CMe388.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    private OrdersMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrdersMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<Orders> findOrderWithProductByUserId(Integer UserId) {
        return orderMapper.findOrderWithProductByUserId(UserId);
    }

    public Integer addOrder(Orders order) {
        Integer result = orderMapper.addOrder(order);
        if (result >= 0) {
            if (orderMapper.addOrderItem(order) >= 0) {
                return result;
            }
        }
        return 0;
    }
}
