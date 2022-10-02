package com.kartezyatech.cv_portal_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertRequest {

    private String jobName;

    private String jobDetail;

    private String advertDeadLine;


}
