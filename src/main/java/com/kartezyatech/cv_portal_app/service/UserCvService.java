package com.kartezyatech.cv_portal_app.service;

import com.kartezyatech.cv_portal_app.dto.UserCvRequest;
import com.kartezyatech.cv_portal_app.dto.UserCvResponse;
import com.kartezyatech.cv_portal_app.dto.UserResponse;
import com.kartezyatech.cv_portal_app.entity.User;
import com.kartezyatech.cv_portal_app.entity.UserCv;
import com.kartezyatech.cv_portal_app.exception.CvPortalAppException;
import com.kartezyatech.cv_portal_app.mapper.UserCvMapper;
import com.kartezyatech.cv_portal_app.repository.UserCvRepository;
import com.kartezyatech.cv_portal_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class UserCvService {

    private final UserCvRepository userCvRepository;
    private final UserRepository userRepository;
    private final UserCvMapper userCvMapper;

    public void saveUserCv(UserCvRequest userCvRequest) throws Exception {
        UserCv userCv = new UserCv();
        User user = userRepository.findById(userCvRequest.getUserId()).orElseThrow(()-> new CvPortalAppException("Not Found"));
        userCv.setUserBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(userCvRequest.getUserBirthDate()));
        userCv.setUserAddress(userCvRequest.getUserAddress());
        userCv.setUserGraduateSchool(userCvRequest.getUserGraduateSchool());
        userCv.setUserGraduateDepartment(userCvRequest.getUserGraduateDepartment());
        userCv.setGraduateGpa(userCvRequest.getGraduateGpa());
        userCv.setUserWorkExperience(userCvRequest.getUserWorkExperience());
        userCv.setUserDetailInfo(userCvRequest.getUserDetailInfo());
        userCv.setCreatedDate(Instant.now());
        userCv.setUser(user);
        userCvRepository.save(userCv);
    }


    @Transactional(readOnly = true)
    public List<UserCvResponse> getAllUserCvList(){
        return userCvRepository.findAll()
                .stream()
                .map(userCvMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<UserCvResponse> getUserCvListByUserId(Long userId){
        return userCvRepository.findByUserId(userId)
                .stream()
                .map(userCvMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void updateUserCv(UserCvRequest userCvRequest,Long id){
        UserCv userCv = userCvRepository.findById(id).orElseThrow(()->new CvPortalAppException("Not Found"));
        userCv.setUserAddress(userCvRequest.getUserAddress());
        userCv.setUserGraduateSchool(userCvRequest.getUserGraduateSchool());
        userCv.setUserGraduateDepartment(userCvRequest.getUserGraduateDepartment());
        userCv.setGraduateGpa(userCvRequest.getGraduateGpa());
        userCv.setUserWorkExperience(userCvRequest.getUserWorkExperience());
        userCv.setUserDetailInfo(userCvRequest.getUserDetailInfo());
        userCvRepository.save(userCv);



    }


}
