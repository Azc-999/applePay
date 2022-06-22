package com.CMe388.dao;

import com.CMe388.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    List<Orders> findOrderWithProductByUserId(Integer UserId);
    Integer addOrder(Orders orders);
    Integer addOrderItem(Orders orders);
}
