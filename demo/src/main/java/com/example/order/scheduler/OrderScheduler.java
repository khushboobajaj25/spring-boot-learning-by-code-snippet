package com.example.order.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;

@Service   
public class OrderScheduler {
    @Autowired
    private OrderRepository orderRepository;

    // @Scheduled(fixedRate = 5000) // call this function after every 5 seconds
    // @Scheduled(fixedDelay = 5000) // wait for 5 seconds after the previous execution
    // @Scheduled(initialDelay = 10000) // wait for 10 seconds before the first execution
    @Scheduled(cron = "0/5 * * * * *") 
    // cron expression: second minute hour day-of-month month day-of-week
    public void processPendingOrders() {
        System.out.println("Processing pending orders");
        List<Order> orders = orderRepository.findByStatus("PENDING");
        for (Order order : orders) {
            order.setStatus("COMPLETED");
            System.out.println("Order processed:"+ order.getCustomerEmail());
            orderRepository.save(order);
        }

        System.out.println("Processed pending orders for:"+ orders.size());
    }

    
}
