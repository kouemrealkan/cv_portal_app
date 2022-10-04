package com.kartezyatech.cv_portal_app.service;

import com.kartezyatech.cv_portal_app.dto.JobApplyRequest;
import com.kartezyatech.cv_portal_app.dto.JobApplyResponse;
import com.kartezyatech.cv_portal_app.entity.JobAdvertisement;
import com.kartezyatech.cv_portal_app.entity.JobApply;
import com.kartezyatech.cv_portal_app.entity.User;
import com.kartezyatech.cv_portal_app.entity.UserCv;
import com.kartezyatech.cv_portal_app.exception.CvPortalAppException;
import com.kartezyatech.cv_portal_app.mapper.JobApplyMapper;
import com.kartezyatech.cv_portal_app.repository.JobAdvertisementRepository;
import com.kartezyatech.cv_portal_app.repository.JobApplyRepository;
import com.kartezyatech.cv_portal_app.repository.UserCvRepository;
import com.kartezyatech.cv_portal_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class JobApplyService {

    private final JobApplyRepository jobApplyRepository;
    private final JobAdvertisementRepository jobAdvertisementRepository;
    private final UserRepository userRepository;
    private final UserCvRepository userCvRepository;

    private final JobApplyMapper jobApplyMapper;

    @Transactional
    public void saveJobApply(JobApplyRequest jobApplyRequest){
        JobApply jobApply = new JobApply();
        User user = userRepository.findById(jobApplyRequest.getUserId()).orElseThrow(()->new CvPortalAppException("Not Found User"));
        JobAdvertisement jobAdvertisement = jobAdvertisementRepository.findById(jobApplyRequest.getJobAdvertisementId()).orElseThrow(()->new CvPortalAppException("Not Found Advert"));
        UserCv userCv = userCvRepository.findById(jobApplyRequest.getUserCvId()).orElseThrow(()->new CvPortalAppException("User Cv Not Found"));


        jobApply.setUser(user);
        jobApply.setJobAdvertisement(jobAdvertisement);
        jobApply.setUserCv(userCv);


        jobApply.setApplyDate(Instant.now());
        jobApply.setStatus("Başvuru Alındı");


        jobApplyRepository.save(jobApply);

    }

    @Transactional(readOnly = true)
    public List<JobApplyResponse> getAllJobApplyList(){
        return jobApplyRepository.findAll()
                .stream()
                .map(jobApplyMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<JobApplyResponse> getAllApplyListByUserId(Long userId){
        return jobApplyRepository.findByUserId(userId)
                .stream()
                .map(jobApplyMapper::mapToDto)
                .collect(Collectors.toList());
    }


}
