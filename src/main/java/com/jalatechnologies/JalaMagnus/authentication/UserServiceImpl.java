package com.jalatechnologies.JalaMagnus.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jalatechnologies.JalaMagnus.Model.User;
import com.jalatechnologies.JalaMagnus.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	

	public User getbyUsername(String username) {
		return this.userRepository.findByUsername(username);
	}


	public HttpStatus deleteById(Long id) {
		this.userRepository.deleteById(id);
		return HttpStatus.OK;
	}

}
