package com.codesnippet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesnippet.demo.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
    
}
