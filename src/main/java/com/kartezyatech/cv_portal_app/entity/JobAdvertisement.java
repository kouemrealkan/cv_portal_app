package com.kartezyatech.cv_portal_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

    private Long id;

    private String jobName;

    private String jobDetail;


}
