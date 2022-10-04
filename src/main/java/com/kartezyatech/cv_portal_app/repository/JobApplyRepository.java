package com.kartezyatech.cv_portal_app.repository;

import com.kartezyatech.cv_portal_app.entity.JobApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplyRepository extends JpaRepository<JobApply,Long> {

    List<JobApply> findByUserId(Long userId);
}
