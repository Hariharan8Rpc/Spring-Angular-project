package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employeeApi")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repo;
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	public Employee  save(Employee employee) {
		return repo.save(employee);
	}
	public boolean delete(long id) {
		repo.deleteById(id);
		return repo.existsById(id);
	}
	@GetMapping("/search")
	public List<Employee> search(String keyword){
		return repo.findByKeyword(keyword);
	}
	public Optional<Employee> findEmployee(long id) {
		return repo.findById(id);
	}
}
