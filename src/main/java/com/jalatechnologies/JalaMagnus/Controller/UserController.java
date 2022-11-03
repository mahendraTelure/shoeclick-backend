package com.jalatechnologies.JalaMagnus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalatechnologies.JalaMagnus.Model.User;
import com.jalatechnologies.JalaMagnus.Repository.UserRepository;

@RestController
@RequestMapping("/jala/api/v1")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
//	getting all users
	@GetMapping("/user")
	public List<User> getEmp(){
		return userRepository.findAll();
	}

//	adding user to the database
	@PostMapping("/user")
	public User createEmployee(@RequestBody User employee) {
		return userRepository.save(employee);
	}
	
	
}
