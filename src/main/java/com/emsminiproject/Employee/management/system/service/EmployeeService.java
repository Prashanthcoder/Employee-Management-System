package com.emsminiproject.Employee.management.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emsminiproject.Employee.management.system.entity.Employee;
import com.emsminiproject.Employee.management.system.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public String createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "employee data inserted successfully";
	}
	
	public Object fetchEmployeeById(String email) {
		Optional<Employee> optionalEmployee = employeeRepository.findByEmail(email);
		if(optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			return employee;
		}
		
		return "Email Id "+email+" not found";
	}
	
	public List<Employee> fetchEmployees(){
		return employeeRepository.findAll();
	}
	
	public String updateEmployeeById(Employee updateEmployee, String email) {
		Optional<Employee> optionalEmployee = employeeRepository.findByEmail(email);
		if(optionalEmployee.isPresent()) {
			Employee existingEmployee = optionalEmployee.get();
			existingEmployee.setName(updateEmployee.getName());
			existingEmployee.setSalary(updateEmployee.getSalary());
			existingEmployee.setEmail(updateEmployee.getEmail());
			existingEmployee.setDepartment(updateEmployee.getDepartment());
			employeeRepository.save(existingEmployee);
			return "updated employee data";
		}
		
		return "Email Id "+email+" not found";
	}
	
	public String deleteEmployeeById(String email) {
		Optional<Employee>  optional = employeeRepository.findByEmail(email);
		if(optional.isEmpty()) {
			return "email id "+email+" not found";
		}
		
		Employee dataToDelete = optional.get();
		employeeRepository.delete(dataToDelete);
//		employeeRepository.deleteByEmail(email);
		return email+" deleted successfully";
	}
}
