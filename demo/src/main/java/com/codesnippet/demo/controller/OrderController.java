package com.codesnippet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesnippet.demo.entity.Inventory;
import com.codesnippet.demo.entity.Order;
import com.codesnippet.demo.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody Inventory inventory){

        orderService.placeOrder(inventory.getId(),inventory.getQuantity());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
