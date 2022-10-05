package com.kartezyatech.cv_portal_app.service;

import com.kartezyatech.cv_portal_app.dto.*;
import com.kartezyatech.cv_portal_app.entity.User;
import com.kartezyatech.cv_portal_app.exception.CvPortalAppException;
import com.kartezyatech.cv_portal_app.mapper.UserMapper;
import com.kartezyatech.cv_portal_app.repository.UserRepository;
import com.kartezyatech.cv_portal_app.validator.JwtValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.Instant;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtValidator jwtValidator;

    @Transactional
    public void registerUser(UserRegisterRequest userRegisterRequest) {
        User user =  new User();
        user.setUserName(userRegisterRequest.getUserName());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
        user.setPhoneNumber(userRegisterRequest.getPhoneNumber());
        user.setRole("ROLE_USER");
        user.setCreatedDate(Instant.now());
        userRepository.save(user);
    }

    public AuthResponse login(UserLoginRequest userLoginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequest.getUserName(),userLoginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtValidator.generateAuthToken(authentication);
        User authUser = userRepository.findByUserName(userLoginRequest.getUserName())
                .orElseThrow(()->new CvPortalAppException("user not found"));


        return AuthResponse.builder()
                .authToken(token)
                .expiresAt(Instant.now().plusMillis(jwtValidator.getJwtExpirationInMillis()))
                .userName(userLoginRequest.getUserName())
                .role(authUser.getRole())
                .build();



    }

    @Transactional(readOnly = true)
    public UserResponse getCurrentUser(){
        Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User getUser  = userRepository.findByUserName(principal.getSubject())
                .orElseThrow(()->new CvPortalAppException("user not found"));
        return userMapper.mapToDto(getUser);
    }

    public UserLogoutResponse userLogout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return UserLogoutResponse.builder()
                .message("Logout Success !")
                .build();
    }


    @Transactional(readOnly = true)
    public Long getCurrentUserId(){
        Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User getUser  = userRepository.findByUserName(principal.getSubject())
                .orElseThrow(()->new CvPortalAppException("user not found"));
        return getUser.getId();
    }



}
