package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.employee.model.Project;
import com.employee.model.employeSql;
import com.employee.repository.AddressRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.ProjectRepository;
import com.employee.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employeeApi")
public class EmployeeController{
	@Autowired
	private EmployeeServiceImpl empService;
	
//	@GetMapping("/getAll")
	@GetMapping
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();		
	}
//	@PostMapping(value="/save")
	@PostMapping
	public ResponseEntity<Employee>save(@RequestBody Employee employee) {		
		return empService.save(employee);
	}
		
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Map<String,Boolean>>delete(@PathVariable("id")long id) {		
		return empService.delete(id);
	}
	
	@GetMapping("/search/{keyword}")
	public List<Employee> search(@PathVariable("keyword")String keyword){
		return empService.search(keyword);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("id") long id) {
		return empService.findEmployee(id);
	}
		 
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> update(@PathVariable Long id,@RequestBody Employee employee) {
			
		return empService.update(id, employee);
	}
	
	@GetMapping("/employeeInProject/{id}")
	public ResponseEntity<List<Employee>> employeeInProject(@PathVariable long id){
		return empService.employeeInProject(id);
	}
	
	@GetMapping("/employeeNotInProject/{id}")
	public ResponseEntity<List<Employee>> employeeNotInProject(@PathVariable long id){
		return empService.employeeNotInProject(id);
	} 
}
