package com.codesnippet.demo.service;

import com.codesnippet.demo.entity.Inventory;
import com.codesnippet.demo.entity.Order;
import com.codesnippet.demo.repository.InventoryRepository;
import com.codesnippet.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class FirstProgrammaticApproach {

  private final PlatformTransactionManager transactionManager;
  private final OrderRepository orderRepository;
  private final InventoryRepository inventoryRepository;

  @Autowired
  public FirstProgrammaticApproach(
    PlatformTransactionManager transactionManager,
    OrderRepository orderRepository,
    InventoryRepository inventoryRepository
  ) {
    this.transactionManager = transactionManager;
    this.orderRepository = orderRepository;
    this.inventoryRepository = inventoryRepository;
  }

  public void placeOrder(Integer inventoryId, int quantity) {
    // Create a new transaction definition
    DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
    transactionDefinition.setName("OrderTransaction");
    transactionDefinition.setPropagationBehavior(
      TransactionDefinition.PROPAGATION_REQUIRED
    );

    // Begin the transaction
    TransactionStatus status = transactionManager.getTransaction(
      transactionDefinition
    );

    try {
      // Step 1: Fetch inventory
      Inventory inventory = inventoryRepository
        .findById(inventoryId)
        .orElseThrow(() -> new RuntimeException("Inventory item not found!"));

      // Step 2: Check stock availability
      if (inventory.getQuantity() < quantity) {
        throw new RuntimeException(
          "Insufficient stock for product: " + inventory.getProductName()
        );
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

      // Commit the transaction
      transactionManager.commit(status);
    } catch (Exception e) {
      // Rollback the transaction in case of any failure
      transactionManager.rollback(status);
      throw e; // Re-throw the exception to propagate the error
    }
  }
}
