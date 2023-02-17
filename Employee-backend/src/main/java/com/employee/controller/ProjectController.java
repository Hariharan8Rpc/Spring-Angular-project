package com.employee.controller;

import java.util.ArrayList;
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
import com.employee.model.Admin;
import com.employee.model.Employee;
import com.employee.model.Project;
import com.employee.repository.AdminRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.ProjectRepository;
import com.employee.service.ProjectServiceImpl;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/employeeApi/project")
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectService;
	@PostMapping(value="/addProject/{id}")
	public ResponseEntity<Project> AddProject(@PathVariable("id")long id,@RequestBody Project project) {
		
		return projectService.AddProject(id, project);
	}
	
	@GetMapping("/getproject")
	public List<Project> getAllProject(){
		return projectService.getAllProject();
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Map<String,Boolean>>delete(@PathVariable("id")long id){
	
		return projectService.delete(id);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Project> findProject(@PathVariable("id") long id) {
		return projectService.findProject(id);
	}
		
	@PutMapping("/update/{id}")
	public ResponseEntity<Project> update(@PathVariable Long id,@RequestBody Project project) {		
		return projectService.update(id, project);
	}
	
	@PostMapping("/insertEmployees/{addrId}/{projectId}")
	public ResponseEntity<Map<String, Boolean>> insertEmployees(@PathVariable Long addrId,@PathVariable Long projectId) {
		return projectService.insertEmployees(addrId, projectId);
	}
		
	@Transactional
	@DeleteMapping("/deleteEmployees/{addrId}/{projectId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployees(@PathVariable Long addrId,@PathVariable Long projectId) {
		return projectService.deleteEmployees(addrId, projectId);
	}
	
}
