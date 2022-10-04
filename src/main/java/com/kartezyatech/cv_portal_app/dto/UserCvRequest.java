package com.kartezyatech.cv_portal_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCvRequest {

    private String userBirthDate;

    private String userAddress;

    private String userGraduateSchool;

    private String userGraduateDepartment;

    private double graduateGpa;

    private String userWorkExperience;

    private String userDetailInfo;

    private Long userId;

}
