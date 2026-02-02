package com.example.order.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<com.example.order.entity.Order, Long> {

    public List<Order> findByStatus(String status);
}
