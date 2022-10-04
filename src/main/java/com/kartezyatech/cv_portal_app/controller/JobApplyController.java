package com.kartezyatech.cv_portal_app.controller;

import com.kartezyatech.cv_portal_app.dto.JobApplyRequest;
import com.kartezyatech.cv_portal_app.dto.JobApplyResponse;
import com.kartezyatech.cv_portal_app.service.JobApplyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job-apply")
@AllArgsConstructor

public class JobApplyController {

    private final JobApplyService jobApplyService;


    @PostMapping("/create-apply")
    public ResponseEntity<String> createJobApply(@RequestBody JobApplyRequest jobApplyRequest){

        jobApplyService.saveJobApply(jobApplyRequest);
        return ResponseEntity.ok("Job Apply Success");
    }


    @GetMapping("/apply-list")
    public ResponseEntity<List<JobApplyResponse>> getAllJobApply(){
        return ResponseEntity.ok(jobApplyService.getAllJobApplyList());
    }


    @GetMapping("/apply-list/{userId}")
    public ResponseEntity<List<JobApplyResponse>> getJobApplyListByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(jobApplyService.getAllApplyListByUserId(userId));
    }

}
