package com.kartezyatech.cv_portal_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date userBirthDate;

    @NotBlank(message = "address is required")
    private String userAddress;

    private String userGraduateSchool;

    private String userGraduateDepartment;

    private double GraduateGpa;

    private String userWorkExperience;

    private String userDetailInfo;

    private Instant createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @OneToMany(mappedBy = "userCv",orphanRemoval = true)
    private List<JobApply> jobApplies = new ArrayList<>();




}
