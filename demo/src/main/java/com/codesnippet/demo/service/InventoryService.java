package com.codesnippet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesnippet.demo.entity.Inventory;
import com.codesnippet.demo.repository.InventoryRepository;

@Service
public class InventoryService {
    
    @Autowired
    private InventoryRepository inventoryRepository;

    public void addInventory(Inventory inventory){
        inventoryRepository.save(inventory);
    }
}
