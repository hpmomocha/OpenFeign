package com.hpe.kevin.controller;

import com.hpe.kevin.Order;
import com.hpe.kevin.Result;
import com.hpe.kevin.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderClientController {
    @Resource
    private OrderService orderService;

    @GetMapping(value = "/consumer/feign/order/get/{id}")
    public Result<Order> getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.getOrderById(id);
        return new Result<>(order);
    }
}
