package com.kartezyatech.cv_portal_app.controller;


import com.kartezyatech.cv_portal_app.dto.JobAdvertRequest;
import com.kartezyatech.cv_portal_app.dto.JobAdvertResponse;
import com.kartezyatech.cv_portal_app.service.JobAdvertService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/job-adverts")
    public ResponseEntity<List<JobAdvertResponse>> getAllJobAdverts(){
        return ResponseEntity.ok(jobAdvertService.getJobAdvertList());
    }

    @PutMapping("/update-job-advert/{id}")
    public ResponseEntity<String> updateJobAdvert(@RequestBody JobAdvertRequest jobAdvertRequest, @PathVariable Long id) throws Exception{
        jobAdvertService.updateJobAdvert(jobAdvertRequest,id);
        return ResponseEntity.ok("Job Advert Updated");
    }

}
