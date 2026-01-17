package com.codesnippet.demo.service;

import org.springframework.context.annotation.Scope;

// @Scope("prototype")
public interface PaymentService {

    public void processPayment(double amount);
    
} 