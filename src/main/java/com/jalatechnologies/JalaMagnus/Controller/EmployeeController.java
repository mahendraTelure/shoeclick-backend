package com.jalatechnologies.JalaMagnus.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalatechnologies.JalaMagnus.Model.Employee;
import com.jalatechnologies.JalaMagnus.Model.Search;
import com.jalatechnologies.JalaMagnus.Repository.EmployeeRepository;
import com.jalatechnologies.JalaMagnus.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/jala/api/v1")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
//	for retrive all employee
	@GetMapping("/emp")
	public List<Employee> getEmp() {
		return employeeRepository.findAll();
	}
	
//	searching the employee
	@PostMapping("/search")
	public List<Employee> searchEmployee(@RequestBody Search search) {
		
		if (search.getFirstName().trim() != null  && search.getMobile() == null) {			
//		if user inserted only name
			return employeeRepository.findByFirstNameContaining(search.getFirstName());
		}else if (search.getFirstName().trim() == null  && search.getMobile() != null) {
//			if user inserted only number
			return employeeRepository.findByMobileContaining(search.getMobile());
		}else if (search.getFirstName().trim() != null  && search.getMobile() != null) {
//			if user inserted both name and mobile 
			return employeeRepository.findByFirstNameContainingAndMobileContaining(search.getFirstName(), search.getMobile());
		}
		return employeeRepository.findAll();

	}
	
//	adding employee to database
	@PostMapping("/emp")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	

//	getting single employee
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

//	deleting employee
	@DeleteMapping("/emp/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws Exception {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

//	Put method mapped and endpoint is /emp/
//	@PutMapping("/emp/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
//			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {
//		Employee employee = employeeRepository.findById(employeeId)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//		employee.setId(employeeId);
//		employee.setFirstName(employeeDetails.getFirstName());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setAddress(employeeDetails.getAddress());
//		employee.setCountry(employeeDetails.getCountry());
//		employee.setCity(employeeDetails.getCity());
//		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
//		employee.setGender(employeeDetails.getGender());
//		employee.setMobile(employeeDetails.getMobile());
//		employee.setEmail(employeeDetails.getEmail());
//		final Employee updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
//	}

//	updating the employee
	@PutMapping("/emp")
	public Employee updatdeEmp(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}

}
