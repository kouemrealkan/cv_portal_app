package com.kartezyatech.cv_portal_app.controller;

import com.kartezyatech.cv_portal_app.dto.*;
import com.kartezyatech.cv_portal_app.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.status;
@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterRequest registerRequest){
        authService.registerUser(registerRequest);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthResponse login(UserLoginRequest loginRequest){
        return authService.login(loginRequest);
    }

    @GetMapping("/user-info")
    public ResponseEntity<UserResponse> getUser(){
        return status(HttpStatus.OK).body(authService.getCurrentUser());
    }

    @PostMapping("/logout")
    public ResponseEntity<UserLogoutResponse> userLogout(){
        return ResponseEntity.status(HttpStatus.OK).body(authService.userLogout());
    }

    @GetMapping("/get-user-id")
    public ResponseEntity<UserIdResponse> getUserId(){
        return ResponseEntity.ok(authService.getCurrentUserId());
    }


    @PutMapping("/update-user/{id}")
    public ResponseEntity<String> updateUserInfo(@RequestBody UserUpdateRequest userUpdateRequest, @PathVariable Long id){
        authService.updateUserInfo(userUpdateRequest,id);
        return ResponseEntity.status(HttpStatus.OK).body("User Updated Success");
    }


}
