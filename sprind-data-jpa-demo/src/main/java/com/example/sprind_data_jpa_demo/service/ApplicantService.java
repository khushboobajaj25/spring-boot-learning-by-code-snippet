package com.example.sprind_data_jpa_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.sprind_data_jpa_demo.entity.Applicant;
import com.example.sprind_data_jpa_demo.entity.Resume;
import com.example.sprind_data_jpa_demo.repository.ApplicantJpaRepository;
import com.example.sprind_data_jpa_demo.repository.ApplicantPagingAndSortingRepository;
import com.example.sprind_data_jpa_demo.repository.ApplicantRepository;

@Service
public class ApplicantService {
    
    @Autowired
    private  ApplicantJpaRepository applicantRepository;
    @Autowired
    private ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository;
    public List<Applicant> getAllApplicants() {
        // Iterable<Applicant> all = applicantRepository.findAll();
        // // Implementation here
        // List<Applicant> applicantList = new java.util.ArrayList<>();
        // all.forEach(applicantList::add);
        // return applicantList;

        return ((List<Applicant>) applicantRepository.findAll())
            .stream()
            .toList();

        
        
    }

    public Applicant saveApplicant(Applicant applicant) {
        // Implementation here
        Resume resume = applicant.getResume();
        if(resume!= null){

            resume.setApplicant(applicant);
        }
        return applicantRepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantsWithPagination(int page,int size){
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(page, size));
    }

    public List<Applicant> getApplicantByNameAndByStatus(String status){
        return applicantRepository.findByStatusOrderByName( status);
    }
}
