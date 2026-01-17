package com.codesnippet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.codesnippet.demo.entity.User;

import jakarta.annotation.PostConstruct;

@Controller
@Scope("prototype")
public class UserController {
    @Autowired
    User user;

    public UserController(){
        System.out.println("UserController bean created");
    }

    @PostConstruct
    public void init(){
        System.out.println("UserController init method called. User hashcode: " + user.hashCode());
    }
}
