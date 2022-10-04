package com.kartezyatech.cv_portal_app.mapper;

import com.kartezyatech.cv_portal_app.dto.UserCvResponse;
import com.kartezyatech.cv_portal_app.entity.UserCv;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserCvMapper {


    @Mapping(target = "id",source = "id")
    @Mapping(target = "userBirthDate",source = "userBirthDate")
    @Mapping(target = "userAddress",source = "userAddress")
    @Mapping(target = "userGraduateSchool",source = "userGraduateSchool")
    @Mapping(target = "userGraduateDepartment",source = "userGraduateDepartment")
    @Mapping(target = "graduateGpa",source = "graduateGpa")
    @Mapping(target = "userWorkExperience",source = "userWorkExperience")
    @Mapping(target = "userDetailInfo",source = "userDetailInfo")
    @Mapping(target = "userName",source = "user.userName")


    public UserCvResponse mapToDto(UserCv userCv);
}
