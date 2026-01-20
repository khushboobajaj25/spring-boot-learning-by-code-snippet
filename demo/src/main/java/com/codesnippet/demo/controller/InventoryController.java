package com.codesnippet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesnippet.demo.entity.Inventory;
import com.codesnippet.demo.service.InventoryService;

@RestController
@RequestMapping("inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<?> addInventory(@RequestBody Inventory inventory){
        inventoryService.addInventory(inventory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
