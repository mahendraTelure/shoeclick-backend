package com.jalatechnologies.JalaMagnus.Model;

import java.sql.Date;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {

//	id is auto generated of employee
//	and other details of emplyee
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String firstName, lastName, email, address, country, city, gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dateOfBirth;
	String mobile;
	String aws,devOps, fullStackDeveloper, middleware, webServices, qaAutomation;
	
//	getters and setters for employee  details
	public String getAws() {
		return aws;
	}
	public void setAws(String aws) {
		this.aws = aws;
	}
	public String getDevOps() {
		return devOps;
	}
	public void setDevOps(String devOps) {
		this.devOps = devOps;
	}
	public String getFullStackDeveloper() {
		return fullStackDeveloper;
	}
	public void setFullStackDeveloper(String fullStackDeveloper) {
		this.fullStackDeveloper = fullStackDeveloper;
	}
	public String getMiddleware() {
		return middleware;
	}
	public void setMiddleware(String middleware) {
		this.middleware = middleware;
	}
	public String getWebServices() {
		return webServices;
	}
	public void setWebServices(String webServices) {
		this.webServices = webServices;
	}
	public String getQaAutomation() {
		return qaAutomation;
	}
	public void setQaAutomation(String qaAutomation) {
		this.qaAutomation = qaAutomation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	
}
