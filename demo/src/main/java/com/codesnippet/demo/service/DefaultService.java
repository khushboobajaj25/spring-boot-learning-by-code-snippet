package com.codesnippet.demo.service;

import org.springframework.context.annotation.Primary;

@Primary
public class DefaultService implements PaymentService{
    public void processPayment(double amount){
        System.out.println("Processing payment of $" + amount + " through Default.");
    }

    
}
