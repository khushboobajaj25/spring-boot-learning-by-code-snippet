package com.codesnippet.demo.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("singleton")
public class Employee {
    public Employee(){
        System.out.println("employee bean created");
    }

    @PostConstruct
    public void init(){
        System.out.println("Employee object initialized " + this.hashCode());
    }
}
