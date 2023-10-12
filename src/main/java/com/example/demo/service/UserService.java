package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Profile;
import com.example.demo.exception.SimpleException;

public interface UserService {

	public Profile login(String username, String password) throws SimpleException;

}
