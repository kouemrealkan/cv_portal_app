package com.kartezyatech.cv_portal_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY)
    private UserCv userCv;


    private Instant applyDate;


    private String status ;


    @ManyToOne(fetch = FetchType.LAZY)
    private JobAdvertisement jobAdvertisement;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


}
