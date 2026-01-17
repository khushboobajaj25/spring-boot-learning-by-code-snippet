package com.codesnippet.demo.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope(value= "request",proxyMode = ScopedProxyMode.INTERFACES)
public class User {
    public User(){
        System.out.println("User bean created");
    }

    @PostConstruct
    public void init(){
        System.out.println("User object initialized " + this.hashCode());
    }
}
// Entity Singleton Controller Singleton
// Entity Singleton Controller Prototype
// Entity Prototype Controller Singleton
// Entity Prototype Controller Prototype


