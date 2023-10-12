package com.example.demo.repository;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Profile;

import jakarta.annotation.PostConstruct;

@Component
public class DBInit {

	private final UserRepository userRepository;

	public DBInit(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void initializeDatabase() {
		Profile user1 = new Profile("Mark","123456");
		Profile user2 = new Profile("Bob","654321");
		Profile user3 = new Profile("Mathieu","123AZE");
		
		userRepository.saveAll(List.of(user1,user2,user3));
		
	}
}
