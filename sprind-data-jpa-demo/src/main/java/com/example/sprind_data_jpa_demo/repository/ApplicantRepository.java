package com.example.sprind_data_jpa_demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sprind_data_jpa_demo.entity.Applicant;
@Repository

public interface ApplicantRepository extends ListCrudRepository<Applicant, Long> {

    
} 

