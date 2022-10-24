package com.jalatechnologies.JalaMagnus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jalatechnologies.JalaMagnus.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long>{

}
