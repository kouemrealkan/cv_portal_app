package com.kartezyatech.cv_portal_app.mapper;


import com.kartezyatech.cv_portal_app.dto.UserIdResponse;
import com.kartezyatech.cv_portal_app.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserIdMapper {

    @Mapping(target = "id",source = "id")
    public UserIdResponse mapToDto(User user);
}
