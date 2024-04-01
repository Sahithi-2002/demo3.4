package com.cg.service;

import java.util.List;

import com.cg.model.Employee;

public interface EmployeeService {
	

	List<Employee> saveEmployee(Employee e);

	public List<Employee> getAllEmployee();
	
	public Employee findEmployeeById(int id);
}
