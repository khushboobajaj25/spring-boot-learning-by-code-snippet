package com.example.sprind_data_jpa_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sprind_data_jpa_demo.entity.Applicant;


@Repository
public interface ApplicantJpaRepository extends JpaRepository<Applicant,Long> {

    List<Applicant> findByStatusOrderByName(String status);

    @Query("SELECT a FROM Applicant a WHERE a.name LIKE %:partialName%")
    List<Applicant> findByPartialName(String partialName);
} 
