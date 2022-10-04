package com.kartezyatech.cv_portal_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCvResponse {

    private Long id;

    private String userBirthDate;

    private String userAddress;

    private String userGraduateSchool;

    private String userGraduateDepartment;

    private double graduateGpa;

    private String userWorkExperience;

    private String userDetailInfo;

    private String userName;
}
