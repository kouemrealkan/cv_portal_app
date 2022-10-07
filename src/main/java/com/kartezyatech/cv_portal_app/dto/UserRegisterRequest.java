package com.kartezyatech.cv_portal_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
      private String userName;
      private String email;
      private String password;
      private String phoneNumber;
      private String name;
      private String lastName;
}
