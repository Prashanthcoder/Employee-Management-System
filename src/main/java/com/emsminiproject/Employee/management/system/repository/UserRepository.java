package com.emsminiproject.Employee.management.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.emsminiproject.Employee.management.system.dto.RegisterRequestDTO;
import com.emsminiproject.Employee.management.system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
Optional<User> findByEmail(String email);
}
