package com.codesnippet.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext =SpringApplication.run(SpringDemoApplication.class, args);
		System.out.println("Application context created");
		
	}

}
