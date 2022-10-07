package com.kartezyatech.cv_portal_app.repository;

import com.kartezyatech.cv_portal_app.dto.UserCvResponse;
import com.kartezyatech.cv_portal_app.entity.UserCv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCvRepository extends JpaRepository<UserCv,Long> {


    List<UserCv> findByUserId(Long userId);



}
