package com.codesnippet.demo.dbconnection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
    prefix = "nosqlconnection",
    value = "enabled",
    havingValue = "true",
    matchIfMissing = false
)
public class MySqlConnection {
    public MySqlConnection(){
        System.out.println("MySql Connection");
    }

}
