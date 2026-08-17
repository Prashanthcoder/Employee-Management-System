package com.emsminiproject.Employee.management.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="emp")
public class Employee {
	@Id
	@Email(message="Enter proper email id")
	@NotBlank(message="Email must not be empty, null, space")
	private String email;
	@NotBlank(message="Name must not be empty, null, space")
	private String name;
	@Positive(message="Salary must more then or equal to 0")
	private double salary;
	@NotBlank(message="Department must not be empty, null or space")
	private String department;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
