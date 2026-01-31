package com.example.sprind_data_jpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sprind_data_jpa_demo.entity.Applications;

public interface ApplicationsRepository extends JpaRepository<Applications,Long> {

    
}