package com.jalatechnologies.JalaMagnus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalatechnologies.JalaMagnus.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
//	find user by username
	public User findByUsername(String username);
}
