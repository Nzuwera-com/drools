package com.nzuwera.api.controller;

import com.nzuwera.api.domain.Order;
import com.nzuwera.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return service.findAllOrders();
    }
}
