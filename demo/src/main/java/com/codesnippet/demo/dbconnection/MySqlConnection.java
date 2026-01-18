package com.codesnippet.demo.dbconnection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
/* 
 Profile annotation is used for using a configuration , whenever we have different environments, and 
 whenever we want specific bean to initialise on specific env we can use @Profile annotation
*/
@Component
@Profile("dev")
@ConditionalOnProperty(
    prefix = "sqlconnection",
    value = "enabled",
    havingValue = "true",
    matchIfMissing = false
)

public class MySqlConnection {
    public MySqlConnection(){
        System.out.println("MySql Connection");
    }

}
