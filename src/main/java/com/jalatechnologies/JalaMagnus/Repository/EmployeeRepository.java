package com.jalatechnologies.JalaMagnus.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalatechnologies.JalaMagnus.Model.Employee;
import com.jalatechnologies.JalaMagnus.Model.User;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long>{

//	public User findByUsername(String username);
	public List<Employee> findByFirstName(String firstName);
	
	public List<Employee> findByFirstNameContaining(String firstName);
	public List<Employee> findByFirstNameContainingAndMobileContaining(String firstName, String mobile) ;
	public List<Employee> findByFirstNameContainingOrMobileContaining(String firstName, String mobile);
	public List<Employee> findByMobileContaining(String mobile);
}
