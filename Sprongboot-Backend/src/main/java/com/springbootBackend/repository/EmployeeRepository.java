package com.springbootBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootBackend.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
