package com.codesnippet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesnippet.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    
} 
