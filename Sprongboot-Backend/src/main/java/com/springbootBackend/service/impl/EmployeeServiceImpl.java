package com.springbootBackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootBackend.exception.ResourceNotFoundException;
import com.springbootBackend.model.Employee;
import com.springbootBackend.repository.EmployeeRepository;
import com.springbootBackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent())
//		{
//			return employee.get();
//		}
//		else
//			throw new ResourceNotFoundException("Employee", "Id",id);
		
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
		
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		Employee searchedEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
		
		searchedEmployee.setFirstName(employee.getFirstName());
		searchedEmployee.setLastName(employee.getLastName());
		searchedEmployee.setEmail(employee.getEmail());
		employeeRepository.save(searchedEmployee);
		
		return searchedEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
		employeeRepository.deleteById(id);
		
	}
	
	

}
