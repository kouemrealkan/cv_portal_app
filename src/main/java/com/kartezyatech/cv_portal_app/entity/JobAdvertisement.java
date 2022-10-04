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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String jobName;


    private String jobDetail;

    private Instant advertDate;

    private Date advertDeadLine;

    private boolean isEnabled;


    @OneToMany(mappedBy = "jobAdvertisement")
    private List<JobApply> jobApplyList = new ArrayList<>();



}
