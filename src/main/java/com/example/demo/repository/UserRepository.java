package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Profile;

public interface UserRepository extends JpaRepository<Profile, Long> {
	Profile findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
//
}
