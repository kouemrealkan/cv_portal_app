package com.kartezyatech.cv_portal_app.service;

import com.kartezyatech.cv_portal_app.dto.JobAdvertRequest;
import com.kartezyatech.cv_portal_app.dto.JobAdvertResponse;
import com.kartezyatech.cv_portal_app.entity.JobAdvertisement;
import com.kartezyatech.cv_portal_app.exception.CvPortalAppException;
import com.kartezyatech.cv_portal_app.mapper.JobAdvertisementMapper;
import com.kartezyatech.cv_portal_app.repository.JobAdvertisementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor

public class JobAdvertService {

    private final JobAdvertisementRepository jobAdvertisementRepository;
    private final JobAdvertisementMapper jobAdvertisementMapper;

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



    @Transactional(readOnly = true)
    public List<JobAdvertResponse> getJobAdvertList(){
        return jobAdvertisementRepository.findAll()
                .stream()
                .map(jobAdvertisementMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateJobAdvert(JobAdvertRequest jobAdvertRequest,Long id) throws Exception{
        JobAdvertisement jobAdvertisement = jobAdvertisementRepository.findById(id).orElseThrow(()->new CvPortalAppException("Not Found"));
        jobAdvertisement.setJobName(jobAdvertRequest.getJobName());
        jobAdvertisement.setJobDetail(jobAdvertRequest.getJobDetail());
        jobAdvertisement.setAdvertDeadLine(new SimpleDateFormat("dd/MM/yyyy").parse(jobAdvertRequest.getAdvertDeadLine()));
        jobAdvertisementRepository.save(jobAdvertisement);
    }

}
