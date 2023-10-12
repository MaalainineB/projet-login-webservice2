package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Profile;
import com.example.demo.exception.SimpleException;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

//	public Profile login(String username, String password) {
//	    try {
//	        Optional<Profile> optionalUser = userRepository.findByUsernameAndPassword(username, password);
//	        if (optionalUser.isPresent()) {
//	            return optionalUser.get();
//	        } else {
//	            throw new RuntimeException("Username or password does not exist");
//	        }
//	    } catch (Exception e) {
//	        // Handle the exception appropriately, e.g., log the error or rethrow a more specific exception.
//	        throw new RuntimeException("An error occurred during login", e);
//	    }
//	}

	public Profile login(String username, String password) throws SimpleException {
		try {
			if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
				Profile userFound = userRepository.findByUsernameAndPassword(username, password);
				if (userFound != null) {
					return userFound;
				} else {
					throw new SimpleException("User not found");
				}
			} else {
				throw new IllegalArgumentException("Invalid username or password");
			}

		} catch (IllegalArgumentException e) {
			throw e;
		} catch (SimpleException e) {
			throw e;
		}
	}
}
