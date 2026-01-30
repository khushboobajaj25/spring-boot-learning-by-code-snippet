package com.example.sprind_data_jpa_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprind_data_jpa_demo.entity.Applicant;
import com.example.sprind_data_jpa_demo.service.ApplicantService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/applicants")
public class ApplicantController {
    @Autowired
    ApplicantService applicantService;
    
    @GetMapping("/getAllApplicants")
    public  List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants(); 
    }

    @PostMapping("/save")
    public Applicant saveApplicants(@RequestBody Applicant applicant) {
        //TODO: process POST request
        
        return applicantService.saveApplicant(applicant); 
    }

    @GetMapping("/page")
    public Iterable<Applicant> getApplicantsWithPage(@RequestParam int page, @RequestParam int size) {
        return applicantService.getApplicantsWithPagination(page,size);
    }

    @GetMapping("/findByNameAndStatus")
    public List<Applicant> getApplicantByNameAndByStatus( @RequestParam String status) {
        return applicantService.getApplicantByNameAndByStatus(status);
    }
    
    
    
    
}
