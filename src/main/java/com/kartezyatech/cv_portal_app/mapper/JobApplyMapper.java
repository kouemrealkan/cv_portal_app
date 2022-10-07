package com.kartezyatech.cv_portal_app.mapper;

import com.kartezyatech.cv_portal_app.dto.JobApplyResponse;
import com.kartezyatech.cv_portal_app.entity.JobApply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobApplyMapper {

    @Mapping(target = "id",source = "id")
    @Mapping(target = "jobAdvertisementId",source = "jobAdvertisement.id")
    @Mapping(target = "jobName",source = "jobAdvertisement.jobName")
    @Mapping(target = "userCvId",source = "userCv.id")
    @Mapping(target = "applyDate",source = "applyDate")
    @Mapping(target = "userName",source = "user.userName")
    @Mapping(target = "name",source = "user.name")
    @Mapping(target = "lastName",source = "user.lastName")
    @Mapping(target = "phoneNumber",source = "user.phoneNumber")
    @Mapping(target = "status",source = "status")
    public JobApplyResponse mapToDto(JobApply jobApply);

}
