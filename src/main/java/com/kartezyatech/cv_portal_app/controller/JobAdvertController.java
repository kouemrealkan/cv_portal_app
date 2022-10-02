package com.kartezyatech.cv_portal_app.controller;


import com.kartezyatech.cv_portal_app.dto.JobAdvertRequest;
import com.kartezyatech.cv_portal_app.service.JobAdvertService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job-advert")
@AllArgsConstructor
public class JobAdvertController {

    private final JobAdvertService jobAdvertService;


    @PostMapping("/create-job-advert")
    public ResponseEntity<String> createJobAdvert(@RequestBody JobAdvertRequest jobAdvertRequest)throws Exception{

        jobAdvertService.saveJobAdvert(jobAdvertRequest);
        return new ResponseEntity<>("Job Advert Created", HttpStatus.OK);
    }
}
