package com.codesnippet.demo.dbconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component

public class DBConnection {

    //  @Value annotation helps to get the value of key from application.properties
    @Value("${username}")
    String username;

    @Value("${password}")
    String password;
    
    @Autowired(required=false)
    @Qualifier("mySqlConnection")
    MySqlConnection mySqlConnection;

    @Autowired(required = false)
    NOSqlConnection noSqlConnection;

    @PostConstruct
    public void init(){
        System.out.println("DB Connection Init");
        System.out.println("Username: "+ username + "Password: " + password);
      
    }
}

