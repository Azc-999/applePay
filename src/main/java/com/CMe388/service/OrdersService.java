package com.CMe388.service;

import com.CMe388.pojo.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findOrderWithProductByUserId(Integer UserId);

    Integer addOrder(Orders orders);
}
