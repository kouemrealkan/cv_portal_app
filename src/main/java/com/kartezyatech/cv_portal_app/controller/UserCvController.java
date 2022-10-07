package com.kartezyatech.cv_portal_app.controller;

import com.kartezyatech.cv_portal_app.dto.UserCvRequest;
import com.kartezyatech.cv_portal_app.dto.UserCvResponse;
import com.kartezyatech.cv_portal_app.entity.UserCv;
import com.kartezyatech.cv_portal_app.service.UserCvService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user-cv")
public class UserCvController {

    private final UserCvService userCvService;


    @PostMapping("/create-cv")
    public ResponseEntity<String> createUserCv(@RequestBody UserCvRequest userCvRequest) throws Exception {
        userCvService.saveUserCv(userCvRequest);
        return ResponseEntity.ok().body("User Cv Created");
    }

    @GetMapping("/cv-list")
    public ResponseEntity<List<UserCvResponse>> getCvList(){
        return ResponseEntity.ok().body(userCvService.getAllUserCvList());
    }

    @GetMapping("/cv-list/{userId}")
    public ResponseEntity<List<UserCvResponse>> getCvListByUserId(@PathVariable Long userId){
        return ResponseEntity.ok().body(userCvService.getUserCvListByUserId(userId));
    }

    @GetMapping("/get-user-cv/{id}")
    public ResponseEntity<UserCvResponse> getUserCv(@PathVariable Long id){
        return ResponseEntity.ok().body(userCvService.getUserCv(id));
    }



    @PutMapping("/update-cv/{id}")
    public ResponseEntity<String> updateUserCv(@RequestBody UserCvRequest userCvRequest, @PathVariable Long id){
        userCvService.updateUserCv(userCvRequest,id);
        return ResponseEntity.ok().body("User Cv Updated");
    }

}
