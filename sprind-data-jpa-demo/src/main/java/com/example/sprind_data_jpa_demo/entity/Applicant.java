package com.example.sprind_data_jpa_demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String status;

    @OneToOne(mappedBy = "applicant",cascade = CascadeType.ALL)
    private Resume resume;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    // @JsonIgnore
    private List<Applications> applications = new ArrayList<>();

    @ManyToMany()
    @JoinTable(
        name = "applicant_job",
        joinColumns = @JoinColumn(name = "applicant_id"),
        inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    private List<Jobs> jobs =new ArrayList<>();
}
