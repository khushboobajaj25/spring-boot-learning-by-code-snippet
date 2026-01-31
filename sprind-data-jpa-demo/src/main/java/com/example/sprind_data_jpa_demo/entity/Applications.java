package com.example.sprind_data_jpa_demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private String position;

    @ManyToOne
    @JoinColumn(name="applicationId",nullable = false)
    @JsonIgnore
    private Applicant applicant;
}
