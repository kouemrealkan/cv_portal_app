package com.kartezyatech.cv_portal_app.repository;

import com.kartezyatech.cv_portal_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);

}
