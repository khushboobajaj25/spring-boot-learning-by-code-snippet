package com.example.sprind_data_jpa_demo.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sprind_data_jpa_demo.entity.Applicant;
import com.example.sprind_data_jpa_demo.entity.Jobs;
import com.example.sprind_data_jpa_demo.repository.ApplicantRepository;
import com.example.sprind_data_jpa_demo.repository.JobRepository;

@Service
public class JobService {

    private final ApplicantRepository applicantRepository;
    @Autowired
     private JobRepository jobRepository;

    JobService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

     public Jobs createJob(Jobs job) {
        return jobRepository.save(job);
     }

    public Jobs getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public List<Jobs> getAllJobs() {
        return jobRepository.findAll();
    }

    public Applicant addJobApplicant(Long jobId, Long applicantId) {

        Jobs job = jobRepository.findById(jobId).orElse(null);
        if (job != null) {
            Optional<Applicant> applicant = applicantRepository.findById(applicantId);
            if (applicant.isPresent()) {
                job.getApplicants().add(applicant.get());
                applicant.get().getJobs().add(job);
                jobRepository.save(job);
                applicantRepository.save(applicant.get());
            return applicant.get();
            }
        }
        return null;
    }
        
    
    }
