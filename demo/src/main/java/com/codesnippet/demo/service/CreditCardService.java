package com.codesnippet.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("creditCardService")
public class CreditCardService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Credit Card.");
    }
    
}
