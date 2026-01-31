package com.example.sprind_data_jpa_demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.sprind_data_jpa_demo.entity.Resume;
import com.example.sprind_data_jpa_demo.service.ResumeService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ResumeController {
    
    @Autowired
    ResumeService resumeService;
    @PostMapping("/{applicantId}/resume")
    public ResponseEntity<Resume> addResume(@PathVariable Long applicantId, @RequestBody Resume resume) {
        return  ResponseEntity.ok(resumeService.addResume(applicantId, resume));
    }
    
}
