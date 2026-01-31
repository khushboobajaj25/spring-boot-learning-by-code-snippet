package com.example.sprind_data_jpa_demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    String content;

    @OneToOne // tell jpa this particular entity has one to one with applicant
    @JoinColumn(name = "applicantId",nullable = false) // adding a foreign key to the entity
    @JsonIgnore
    private Applicant applicant;

}
