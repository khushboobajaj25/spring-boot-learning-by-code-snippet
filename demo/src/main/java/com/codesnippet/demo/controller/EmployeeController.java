package com.codesnippet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codesnippet.demo.entity.User;


@Controller
@Scope("singleton")
public class EmployeeController {
    
    @Autowired
    User user;

    public EmployeeController(){
        System.out.println("EmployeeController bean created");
    }

    @PostConstruct
    public void init() {
        System.out.println("EmployeeController init method called." + this.hashCode()+ "User hashcode: " + user.hashCode());
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUserDetails(){
        System.out.println("getUserDetails method called.");
        return ResponseEntity.status(HttpStatus.OK).body("User details fetched successfully");
    }
}
