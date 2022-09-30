package com.kartezyatech.cv_portal_app.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.cors().and()
                .authorizeHttpRequests(authorize->authorize
                .antMatchers("/api/v1/basic/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated());

        return httpSecurity.build();
    }

}
