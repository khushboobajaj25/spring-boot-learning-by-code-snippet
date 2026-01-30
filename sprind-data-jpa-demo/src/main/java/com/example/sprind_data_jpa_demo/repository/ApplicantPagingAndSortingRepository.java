package com.example.sprind_data_jpa_demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.sprind_data_jpa_demo.entity.Applicant;
@Repository
public interface ApplicantPagingAndSortingRepository extends PagingAndSortingRepository<Applicant,Long> {
    
}
