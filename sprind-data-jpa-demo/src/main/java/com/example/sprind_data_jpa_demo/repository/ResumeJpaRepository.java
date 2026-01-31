package com.example.sprind_data_jpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sprind_data_jpa_demo.entity.Resume;

@Repository
public interface ResumeJpaRepository extends JpaRepository<Resume,Long> {

    
} 