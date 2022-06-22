package com.CMe388.controller;

import com.CMe388.pojo.Orders;
import com.CMe388.pojo.Product;
import com.CMe388.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {
    private OrdersService orderService;

    @Autowired
    public void setOrderService(OrdersService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/selectOrder")
    public String selectOrder(Integer userId, Model model) {
        List<Orders> orderList = orderService.findOrderWithProductByUserId(userId);
        model.addAttribute("orderList", orderList);
        return "/admin/main";
    }

    @RequestMapping("/addOrder")
    @ResponseBody
    public Integer addOrder(Integer[] productIds, Integer userId) {
        List<Product> productList = new ArrayList<>();
        for (Integer productId : productIds) {
            Product p = new Product();
            p.setId(productId);
            productList.add(p);
        }
        Orders order = new Orders();
        order.setProducts(productList);
        order.setUserId(userId);
        if (order.getUserId() != null) {
            return orderService.addOrder(order);
        }
        return 0;
    }
}
