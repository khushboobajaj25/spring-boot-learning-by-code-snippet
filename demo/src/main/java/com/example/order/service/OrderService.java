package com.example.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order.dto.OrderRequest;
import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    public Order createOrder(OrderRequest orderRequest) {
       Order order = new Order();
        order.setCustomerEmail(orderRequest.getCustomerEmail());
       
       orderRepository.save(order);
       return order;
    }
}
