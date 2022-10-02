package com.kartezyatech.cv_portal_app.service;

import com.kartezyatech.cv_portal_app.dto.JobAdvertRequest;
import com.kartezyatech.cv_portal_app.entity.JobAdvertisement;
import com.kartezyatech.cv_portal_app.repository.JobAdvertisementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

@Service
@Transactional
@AllArgsConstructor

public class JobAdvertService {

    private final JobAdvertisementRepository jobAdvertisementRepository;


    @Transactional
    public void saveJobAdvert(JobAdvertRequest jobAdvertRequest) throws Exception {
        JobAdvertisement jobAdvertisement = new JobAdvertisement();

        jobAdvertisement.setJobName(jobAdvertRequest.getJobName());
        jobAdvertisement.setJobDetail(jobAdvertRequest.getJobDetail());
        jobAdvertisement.setAdvertDate(Instant.now());

        jobAdvertisement.setAdvertDeadLine(new SimpleDateFormat("dd/MM/yyyy").parse(jobAdvertRequest.getAdvertDeadLine()));
        jobAdvertisement.setEnabled(true);

        jobAdvertisementRepository.save(jobAdvertisement);
    }

}
