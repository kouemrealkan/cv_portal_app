package com.kartezyatech.cv_portal_app.repository;

import com.kartezyatech.cv_portal_app.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserImageRepository extends JpaRepository<UserImage,Long> {

    Optional<UserImage> findByUserId(Long userId);

}
