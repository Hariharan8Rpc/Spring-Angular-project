package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employeeApi")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repo;
	
//	@GetMapping("/getAll")
	@GetMapping
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
//	@PostMapping(value="/save")
	@PostMapping
	public ResponseEntity<Employee>save(@RequestBody Employee employee) {
		
		return ResponseEntity.ok(repo.save(employee));
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public boolean delete(@PathVariable("id")long id) {
		repo.deleteById(id);
		return repo.existsById(id);
	}
	@GetMapping("/search/{keyword}")
	public List<Employee> search(@PathVariable("keyword")String keyword){
		return repo.findByKeyword(keyword);
	}
	@GetMapping("/find/{id}")
	public Optional<Employee> findEmployee(@PathVariable("id") long id) {
		return repo.findById(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id,@RequestBody Employee employee) {
			Employee employee1=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist id:"+ id));
			employee1.setFirstName(employee.getFirstName());
			employee1.setLastName(employee.getLastName());
			employee1.setDepartment(employee.getDepartment());			
//			Employee updatedemp=repo.save(employee1);
		return ResponseEntity.ok(repo.save(employee1));
	}
}
