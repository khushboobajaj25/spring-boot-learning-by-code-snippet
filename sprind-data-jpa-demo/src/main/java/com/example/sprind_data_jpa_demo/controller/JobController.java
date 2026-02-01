package com.example.sprind_data_jpa_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprind_data_jpa_demo.entity.Applicant;
import com.example.sprind_data_jpa_demo.entity.Jobs;
import com.example.sprind_data_jpa_demo.service.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/getJobs")
    public ResponseEntity<List<Jobs>> getAllJobs(@RequestParam String param) {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @PostMapping("/createJob")
    public ResponseEntity<Jobs> createJob(@RequestBody Jobs job) {
        Jobs createdJob = jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }

    @PostMapping("/addJobApplicant")
    public ResponseEntity<String> addJobApplicant(@RequestParam Long jobId, @RequestParam Long applicantId) {
        Applicant addedApplicant = jobService.addJobApplicant(jobId, applicantId);
        if (addedApplicant != null) {
            return ResponseEntity.ok("Applicant added successfully");
        }
        return ResponseEntity.badRequest().body("Failed to add applicant");
    }
    
    
}
