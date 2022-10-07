package com.kartezyatech.cv_portal_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplyResponse {

    private Long id;
    private Long jobAdvertisementId;
    private String jobName;
    private Long userCvId;
    private String applyDate;
    private String userName;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String status;
}
