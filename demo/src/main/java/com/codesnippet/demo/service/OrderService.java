package com.codesnippet.demo.service;

import org.slf4j.*;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesnippet.demo.entity.Inventory;
import com.codesnippet.demo.entity.Order;
import com.codesnippet.demo.repository.InventoryRepository;
import com.codesnippet.demo.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

      private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private InventoryRepository inventoryRepository;
 
    @Transactional
    /*
    if multiple database operations are performed and multiple orders are pleaced , 
    then there will be data inconsisitency if transactional is removed, 
    becacuse we don't know at one time how much database gets hit

    Transactional internally uses AOP, which will help to invoke a method and 
    it uses @Around pointcut expression , to call our method, if method fails
    it will rollback otherwise it will commit.
    
    */ 
    public void placeOrder(Integer inventoryId,int quantity){
        // Fetch inventory by Id

      
        Inventory inventory = inventoryRepository.findById(inventoryId)
        .orElseThrow(()-> new RuntimeException("Stock not found"));

        // check the quantity 
        if(inventory.getQuantity()<quantity){
            throw new RuntimeException("Quantity not available for " + inventory.getProductName());
        }

        inventory.setQuantity(inventory.getQuantity()-quantity);

        Order order = new Order();
        order.setInventory(inventory);
        order.setQuantity(quantity);
        order.setTotalPrice(quantity * inventory.getPrice());
        orderRepository.save(order);
        inventoryRepository.save(inventory);
    }
}
