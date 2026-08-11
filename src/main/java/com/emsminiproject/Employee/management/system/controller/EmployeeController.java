package com.emsminiproject.Employee.management.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Map<String, String>> createEmployee(@RequestBody Employee employee) {
		String result = employeeService.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK)
				.body(Map.of("message", result));
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<Map<String, Object>> fetchEmployeesById(@PathVariable String email) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(Map.of("employee", employeeService.fetchEmployeeById(email)));
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
