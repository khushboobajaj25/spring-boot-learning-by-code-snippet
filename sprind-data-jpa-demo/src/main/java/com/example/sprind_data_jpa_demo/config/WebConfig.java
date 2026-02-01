package com.example.sprind_data_jpa_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.sprind_data_jpa_demo.interceptor.LoggingInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer // helps to register interceptors
 {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(new LoggingInterceptor())
        .addPathPatterns("/api/**")
        .excludePathPatterns("/api/auth/**");
        
    }
    
}
