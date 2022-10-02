package com.kartezyatech.cv_portal_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String userName;
    private String role;
    private String email;
    private String phoneNumber;
    private String createdDate;
}
