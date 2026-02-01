package com.example.weather.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String city;
    
    private String forecast;
    
    // Constructors
    public Weather() {
    }
    
    public Weather(String city, String forecast) {
        this.city = city;
        this.forecast = forecast;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getForecast() {
        return forecast;
    }
    
    public void setForecast(String forecast) {
        this.forecast = forecast;
    }
}
