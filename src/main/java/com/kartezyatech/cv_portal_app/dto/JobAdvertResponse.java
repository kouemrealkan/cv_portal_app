package com.kartezyatech.cv_portal_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertResponse {

    private Long id;

    private String jobName;

    private String jobDetail;

    private String advertDeadLine;

    private String advertDate;

    private boolean enabled;
}
