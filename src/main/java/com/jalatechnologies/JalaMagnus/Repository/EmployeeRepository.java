package com.jalatechnologies.JalaMagnus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalatechnologies.JalaMagnus.Model.Employee;
import com.jalatechnologies.JalaMagnus.Model.User;

//EmployeeRepository extended JpaRepository => JpaRepository provides a methods to perform the database operations
@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long>{

//	finding user by first name
	public List<Employee> findByFirstName(String firstName);
	
//	return user if users first name contains in parameter
	public List<Employee> findByFirstNameContaining(String firstName);
	
//	return user if users first name and mobile contains in parameters
	public List<Employee> findByFirstNameContainingAndMobileContaining(String firstName, String mobile) ;
	
//	return user if users first name or mobile contains in parameters
	public List<Employee> findByFirstNameContainingOrMobileContaining(String firstName, String mobile);
	
//	return user if users mobile contains in parameter
	public List<Employee> findByMobileContaining(String mobile);
}
