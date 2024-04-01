package com.cg.service;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.model.Employee;
//import com.demo.dao.EmployeeDAO;
//
//import jakarta.transaction.Transactional;
//
//@Service
//public  class EmployeeServiceImpl implements EmployeeService{
//
//	@Autowired
//	private EmployeeDAO dao;
//
//	public List<Employee> showEmployees() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public int addEmployee(Employee e) {
//		// TODO Auto-generated method stub
//		return dao.addEmployee(e);
//	}
//	
//	
//	
//
//}


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.dao.PojectRepository;
import com.cg.model.Employee;


 
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private PojectRepository projectRepo;
	@Override
	public List<Employee> saveEmployee(Employee e){
		projectRepo.saveAndFlush(e);
		return projectRepo.findAll();
	}
	@Override
	public List<Employee> getAllEmployee(){
		List<Employee> list=projectRepo.findAll();
		return list;
	}
	
	
	
	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
 
	
}
