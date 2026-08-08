package com.emsminiproject.Employee.management.system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsminiproject.Employee.management.system.entity.Employee;
import com.emsminiproject.Employee.management.system.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/insert")
	public String createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/{email}")
	public Object fetchEmployeesById(@PathVariable String email) {
		return employeeService.fetchEmployeeById(email);
	}
	
	@GetMapping
	public List<Employee> fetchEmployees(){
		return employeeService.fetchEmployees();
	}
	
	@PutMapping("/{email}")
	public String updateEmployeeById(@RequestBody Employee newEmployee, @PathVariable String email) {
		return employeeService.updateEmployeeById(newEmployee, email);
	}
	
	@DeleteMapping("/{email}")
	public String deleteEmployeeById(@PathVariable String email) {
		return employeeService.deleteEmployeeById(email);
	}
}
