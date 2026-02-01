package com.example.weather.repository;

import com.example.weather.entity.Weather;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    public Optional<Weather> findByCity(String city);
    public Optional<Weather> deleteByCity(String city);
}
