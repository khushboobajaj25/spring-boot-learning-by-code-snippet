package com.example.sprind_data_jpa_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprind_data_jpa_demo.entity.Applications;
import com.example.sprind_data_jpa_demo.service.ApplicationsService;

@RestController
@RequestMapping("/applications")
public class ApplicationsController {
    
    @Autowired
    private ApplicationsService applicationsService;

    @PostMapping("/create/{applicantId}")
    public ResponseEntity<Applications> createApplication(@PathVariable Long applicantId,@RequestBody Applications application){

        return ResponseEntity.ok(applicationsService.saveApplications(applicantId, application));
    }
}
