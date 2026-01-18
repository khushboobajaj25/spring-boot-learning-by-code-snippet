package com.codesnippet.demo.exceptions;

public class ProductNotFoundException extends RuntimeException {
    
    public ProductNotFoundException(String message){
        super(message);
        System.out.println(message);
    }
}
