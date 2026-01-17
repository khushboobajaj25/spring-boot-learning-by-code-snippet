package com.codesnippet.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesnippet.demo.service.PaymentService;

@RestController
public class PaymentController {
    
    private final Map<String,PaymentService> paymentMethods;
    public PaymentController(Map<String,PaymentService>  paymentMethods){
        this.paymentMethods = paymentMethods;
    }
    @GetMapping("/payment/{method}")
    public String processPaymentByMethod(@PathVariable String method, @RequestParam double amount){

        PaymentService paymentService = paymentMethods.get(method+"Service");
        paymentService.processPayment(amount);
        System.out.println("Payment chosen is " + paymentService.getClass());
        return "Payment is processed through " + method;
    }
}
