package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.model.Employee;

public interface PojectRepository extends JpaRepository<Employee,Integer>{
//	@Query("Select e from Employee e Where e.id==e.id")
//	public Employee findProductById(int id);

	

}
