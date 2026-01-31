package com.example.sprind_data_jpa_demo.service;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sprind_data_jpa_demo.controller.ApplicantController;
import com.example.sprind_data_jpa_demo.entity.Applicant;
import com.example.sprind_data_jpa_demo.entity.Applications;
import com.example.sprind_data_jpa_demo.repository.ApplicantJpaRepository;
import com.example.sprind_data_jpa_demo.repository.ApplicationsRepository;

@Service
public class ApplicationsService {

    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;
    @Autowired
    private ApplicationsRepository applicationsRepository;

    public Applications saveApplications(Long applicantId, Applications application){
        Optional<Applicant> appOptional = applicantJpaRepository.findById(applicantId);
        if(appOptional.isPresent()){
            Applicant applicant = appOptional.get();
            application.setApplicant(applicant);
            return applicationsRepository.save(application);

        }

       return applicationsRepository.save(application);
    }

}
