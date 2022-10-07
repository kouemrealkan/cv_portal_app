package com.kartezyatech.cv_portal_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "username is required")
    @Column(unique = true)
    private String userName;


    @Column(unique = true)
    @NotBlank(message = "email is required")
    private String email;


    @Column(unique = true)
    @NotBlank(message = "phone number is required")
    private String phoneNumber;


    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "role is required")
    private String role;

    private String name;

    private String lastName;

    private Instant createdDate;

    @OneToOne(mappedBy = "user")
    private UserImage userImage;


    @OneToMany(mappedBy = "user",orphanRemoval = true)
    private List<UserCv> userCvList = new ArrayList<>();


    @OneToMany(mappedBy = "user",orphanRemoval = true)
    private List<JobApply> jobApplies = new ArrayList<>();






}
