package com.emsminiproject.Employee.management.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emsminiproject.Employee.management.system.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	Optional<Employee> findByEmail(String email);
}
