package com.kartezyatech.cv_portal_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "username is required")
    private String userName;


    private String email;


    private String phoneNumber;


    private String password;

    @NotBlank(message = "role is required")
    private String role;

    private Instant createdDate;

    @OneToOne(mappedBy = "user")
    private UserImage userImage;



}
