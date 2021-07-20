package com.nzuwera.api.service;

import com.nzuwera.api.domain.Order;
import com.nzuwera.api.domain.OrderRequest;
import com.nzuwera.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAllOrders() {
        return repository.findAll();
    }

    public void logOrder(OrderRequest request) {
        repository.save(
                Order.builder()
                        .discount(request.getDiscount())
                        .orderId(request.getOrderId())
                        .totalPrice(request.getTotalPrice())
                        .paymentType(request.getPaymentType())
                        .build()
        );
    }
}
