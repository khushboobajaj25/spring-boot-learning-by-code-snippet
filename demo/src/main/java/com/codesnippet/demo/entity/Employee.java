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
/*
Singleton Scope: Only one instance is created for overall application
Prototype Scope: Instances are created only when they are needed
Request Scope: Instances are created for every request hit
Session Scope: Instances are created for particular session. Session can have many requests.
Application Scope: The application scope is similar to singleton,
 but it is specific to the Servlet context of a web application. Beans with application scope are created once per Servlet context and remain until the context is destroyed. To define an application-scoped bean, use @Scope("application").
Choosing the Right Bean Scope

Selecting the appropriate bean scope depends on your use case:

Singleton: When only one instance is needed across the entire application, typically for stateless or shared resources.
Prototype: When new instances are required each time, especially for stateful objects.
Request: When beans are needed only for the duration of an HTTP request in web applications.
Session: When beans need to persist within a user’s session, such as user profiles.
Application: For application-wide resources that span multiple sessions and requests.
*/