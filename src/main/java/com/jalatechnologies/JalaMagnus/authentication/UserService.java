package com.jalatechnologies.JalaMagnus.authentication;

import org.springframework.http.HttpStatus;

import com.jalatechnologies.JalaMagnus.Model.User;

public interface UserService {
	
	
//	get user by user name 
	public User getbyUsername(String username);
	
//	delete user by id
	public HttpStatus deleteById(Long id);
	
	
}
