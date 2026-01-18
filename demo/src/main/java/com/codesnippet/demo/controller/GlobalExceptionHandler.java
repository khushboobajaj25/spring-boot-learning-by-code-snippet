package com.codesnippet.demo.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codesnippet.demo.entity.ErrorResponse;
import com.codesnippet.demo.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),e.getMessage(),"Product Not found");
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        
    }
    

}
/*

*/