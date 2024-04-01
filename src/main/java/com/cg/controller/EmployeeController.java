package com.cg.controller;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cg.model.Employee;
//import com.cg.service.EmployeeService;
//
//@RequestMapping(value = "/employee")
//@RestController
//public class EmployeeController {
//	
//	@Autowired
//	private EmployeeService eSrv;
//	
//	
//	@PostMapping(value = "/add" ,consumes = "application/json",produces ="application/json")
//	ResponseEntity<Employee> addEmployee(@RequestBody Employee prd)
//	{
//		int id=eSrv.addEmployee(prd);
//		System.out.println("Employee with "+id+" is added");
//		return ResponseEntity.ok(prd);
//	}
//	
//	@GetMapping(value ="/show",produces = "application/json")
//	
//	public ResponseEntity<List<Employee>> showEmployee()
//	{
//		List<Employee> employees=eSrv.showEmployees();
//		if(employees.isEmpty())
//		{
//			return new ResponseEntity("Sorry! employees not available!",HttpStatus.NOT_FOUND);
//			
//		}
//		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
//	}
//
//}



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Employee;
import com.cg.service.EmployeeService;

 
@RequestMapping(value="/employee")//localhost:8090/EmployeeApp/Employee1/employee
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	
	@PostMapping("/add")
	public ResponseEntity<List<Employee>> insertEmployee(@RequestBody Employee e){
		List<Employee> emp=service.saveEmployee(e);
		if(emp.isEmpty()) {
			return new ResponseEntity("sorry",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/show")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> emp=service.getAllEmployee();
		if(emp.isEmpty()) {
			return new ResponseEntity("sorry it empty",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("id")Integer id){
		Employee e=service.findEmployeeById(id);
		if(e==null) {
			return new ResponseEntity("Sorry!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	
	
}
