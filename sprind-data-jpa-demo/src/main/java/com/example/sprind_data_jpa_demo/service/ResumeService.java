package com.example.sprind_data_jpa_demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprind_data_jpa_demo.entity.Applicant;
import com.example.sprind_data_jpa_demo.entity.Resume;
import com.example.sprind_data_jpa_demo.repository.ApplicantJpaRepository;
import com.example.sprind_data_jpa_demo.repository.ResumeJpaRepository;

@Service
public class ResumeService {
    @Autowired
    ApplicantJpaRepository  applicantJpaRepository;

    @Autowired
    ResumeJpaRepository resumeJpaRepository;

    public Resume addResume(Long applicantId, Resume resume){
        Optional<Applicant> applicantOptional = applicantJpaRepository.findById(applicantId);
        if(applicantOptional.isPresent()){
            Applicant applicant = applicantOptional.get();
            resume.setApplicant(applicant);
            return resumeJpaRepository.save(resume);
        }
        else{
            throw new RuntimeException("Applicant not found");
        }
    }
}
