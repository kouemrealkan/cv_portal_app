package com.kartezyatech.cv_portal_app.repository;

import com.kartezyatech.cv_portal_app.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement,Long> {

}
