package com.kartezyatech.cv_portal_app.mapper;

import com.kartezyatech.cv_portal_app.dto.UserResponse;
import com.kartezyatech.cv_portal_app.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id",source = "id")
    @Mapping(target = "userName",source = "userName")
    @Mapping(target = "role",source = "role")
    @Mapping(target = "email",source = "email")
    @Mapping(target = "phoneNumber",source = "phoneNumber")
    @Mapping(target = "createdDate",source = "createdDate")
    @Mapping(target = "name",source = "name")
    @Mapping(target = "lastName",source = "lastName")
    public UserResponse mapToDto(User user);
}
