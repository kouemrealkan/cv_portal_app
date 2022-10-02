package com.kartezyatech.cv_portal_app.mapper;

import com.kartezyatech.cv_portal_app.dto.JobAdvertResponse;
import com.kartezyatech.cv_portal_app.entity.JobAdvertisement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobAdvertisementMapper {
    @Mapping(target = "id",source = "id")
    @Mapping(target = "jobName",source = "jobName")
    @Mapping(target = "jobDetail",source = "jobDetail")
    @Mapping(target = "advertDeadLine",source = "advertDeadLine")
    @Mapping(target = "advertDate",expression = "java(java.time.Instant.now())")
    @Mapping(target = "enabled",source = "enabled")

    public JobAdvertResponse mapToDto(JobAdvertisement jobAdvertisement);
}
