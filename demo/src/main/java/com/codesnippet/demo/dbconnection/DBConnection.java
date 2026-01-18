package com.codesnippet.demo.dbconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DBConnection {
    
    @Autowired(required = false)
    MySqlConnection mySqlConnection;

    @Autowired(required = false)
    NOSqlConnection noSqlConnection;

    @PostConstruct
    public void init(){
        System.out.println("DB Connection Init");
        System.out.println("MySql Connection init");
        System.out.println("No Sql Connection Init");
    }
}
