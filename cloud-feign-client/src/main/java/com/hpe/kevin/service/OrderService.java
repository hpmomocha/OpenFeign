package com.hpe.kevin.service;

import com.hpe.kevin.Order;
import com.hpe.kevin.config.OrderServiceConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// http://localhost:9000/consumer/feign/order/get/1
@FeignClient(
        value = "cloud-feign-server",
        contextId = "order",
        // OrderServiceConfiguration 指定日志输出级别
        configuration = OrderServiceConfiguration.class)
public interface OrderService {
    @GetMapping(value = "/order/get/{id}")
    Order getOrderById(@PathVariable("id") Long id);
}
