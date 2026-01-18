package com.codesnippet.demo.dbconnection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
//  prefix+value is the combination of key in application.properties so it will take nosqlconnection.enabled value and check if value is true,it will create a bean 
@ConditionalOnProperty(
    prefix = "nosqlconnection",
    value = "enabled",
    havingValue = "true",
    matchIfMissing = false
)
public class NOSqlConnection {
    
    public NOSqlConnection(){
        System.out.println("NoSqL Connection");
    }
}
