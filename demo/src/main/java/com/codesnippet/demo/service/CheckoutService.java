// package com.codesnippet.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.stereotype.Service;

// import jakarta.annotation.PostConstruct;

// @Service
// public class CheckoutService {

//     @Autowired
//     // @Qualifier("gPayService")
//     PaymentService paymentService;

//     @PostConstruct
//     public void init(){
//         System.out.println("Checkout service initiated");
//     }

//     public void checkout(double amount) {
//         paymentService.processPayment(amount);
//     }
// }
