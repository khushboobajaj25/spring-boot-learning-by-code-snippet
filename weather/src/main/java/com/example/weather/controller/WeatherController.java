package com.example.weather.controller;

import com.example.weather.entity.Weather;
import com.example.weather.service.CacheInspectionService;
import com.example.weather.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CacheInspectionService cacheInspectionService;

    

    @GetMapping("/{city}")  
    public ResponseEntity<String> getWeatherByCity(@PathVariable String city) {
        String weather = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(weather);
    }

    @PostMapping("/add")
    public Weather addWeather(@RequestBody Weather weather) {
        return weatherService.addWeather(weather)  ;
    }
 
    @PutMapping("/update/{city}")
    public String updateWeather(@PathVariable String city, @RequestBody String updatedWeather) {
        return weatherService.updateWeather(city, updatedWeather);
    }
    @GetMapping("/cache")
    public ResponseEntity<Void> printCacheContent(@RequestParam String cacheName){
        cacheInspectionService.printCacheContents(cacheName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{city}")
    public ResponseEntity<Void> deleteWeather(@PathVariable String city){
        weatherService.deleteWeather(city);
        return ResponseEntity.ok().build();
    }
}
