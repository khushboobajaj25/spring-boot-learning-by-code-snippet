package com.codesnippet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.codesnippet.demo.entity.Inventory;
import com.codesnippet.demo.entity.Order;
import com.codesnippet.demo.repository.InventoryRepository;
import com.codesnippet.demo.repository.OrderRepository;


@Service
public class SecondProgrammaticApproach {

    private final TransactionTemplate transactionTemplate;
    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public SecondProgrammaticApproach(TransactionTemplate transactionTemplate,
                        OrderRepository orderRepository,
                        InventoryRepository inventoryRepository) {
        this.transactionTemplate = transactionTemplate;
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public void placeOrder(Integer inventoryId, int quantity) {
        transactionTemplate.execute(status -> {
            try {
                // Step 1: Fetch inventory
                Inventory inventory = inventoryRepository.findById(inventoryId)
                        .orElseThrow(() -> new RuntimeException("Inventory item not found!"));

                // Step 2: Check stock availability
                if (inventory.getQuantity() < quantity) {
                    throw new RuntimeException("Insufficient stock for product: " + inventory.getProductName());
                }

                // Step 3: Deduct stock
                inventory.setQuantity(inventory.getQuantity() - quantity);
                inventoryRepository.save(inventory);

                // Step 4: Create and save order
                Order order = new Order();
                order.setInventory(inventory);
                order.setQuantity(quantity);
                order.setTotalPrice(quantity * inventory.getPrice());
                orderRepository.save(order);

                return null; // Transaction successful
            } catch (Exception e) {
                status.setRollbackOnly(); // Mark transaction for rollback
                throw e;
            }
        });
    }
}
