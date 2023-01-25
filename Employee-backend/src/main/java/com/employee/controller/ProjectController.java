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

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/employeeApi/project")
public class ProjectController {
	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private ProjectRepository projectRepo;
		
	@Autowired
	private AdminRepository adminRepo;
	
	@PostMapping(value="/addProject/{id}")
	public ResponseEntity<Project> AddProject(@PathVariable("id")long id,@RequestBody Project project) {
		Project project1=new Project();
		Admin admin1=new Admin();
		admin1=adminRepo.getReferenceById(id);
//		admin1.setId(id);
		project1=project;
		project1.setAdmin(admin1);
		
//		project1.setAdmin(admin1);
//		System.out.println(admin1);
		return ResponseEntity.ok(projectRepo.save(project1));
	}
	
	@GetMapping("/getproject")
	public List<Project> getAllProject(){
		return projectRepo.findAll();
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Map<String,Boolean>>delete(@PathVariable("id")long id){
		Project project=projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project Not Found"));
		projectRepo.removeProject(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Project Deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/find/{id}")
	public Optional<Project> findProject(@PathVariable("id") long id) {
		return projectRepo.findById(id);
	}
	
//	@GetMapping("/employees")
//	public ResponseEntity<Employee> projectEmployees() {
//		List<Employee> employee=new ArrayList<>();
//		
//		employee=empRepo.
//		Project project1=projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project Not Found"));		
//	
//		
//		return ResponseEntity.ok(projectRepo.save(project1));
//	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Project> update(@PathVariable Long id,@RequestBody Project project) {
		Project project1=projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project Not Found"));
		project1.setTitle(project.getTitle());
		project1.setDomain(project.getDomain());
		project1.setDuration(project.getDuration());
		
		Admin admin1=new Admin();
		admin1=adminRepo.getReferenceById(project.getAdmin().getId());
		project1.setAdmin(project1.getAdmin());
		
		
//			Employee updatedemp=repo.save(employee1);
		return ResponseEntity.ok(projectRepo.save(project1));
	}
	
	@PostMapping("/insertEmployees/{addrId}/{projectId}")
	public void insertEmployees(@PathVariable Long addrId,@PathVariable Long projectId) {
		System.out.println(addrId+ " "+projectId);
		projectRepo.addEmployeesToProject(addrId, projectId);
//		Map<String,Boolean> response=new HashMap<>();
//		response.put("Added to Project",Boolean.TRUE);
//		return ResponseEntity.ok(response);
	}
	
//	@DeleteMapping("/deleteEmployees/{addrId}/{projectId}")
//	public ResponseEntity<Map<String,Boolean>> deleteEmployees(@PathVariable Long addrId,@PathVariable Long projectId) {
//		projectRepo.removeEmployeesFromProject(addrId, projectId);
//		Map<String,Boolean> response=new HashMap<>();
//		response.put("Added to Project",Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
	@Transactional
	@DeleteMapping("/deleteEmployees/{addrId}/{projectId}")
	public void deleteEmployees(@PathVariable Long addrId,@PathVariable Long projectId) {
		projectRepo.removeEmployeesFromProject(addrId, projectId);
//		Map<String,Boolean> response=new HashMap<>();
//		response.put("Added to Project",Boolean.TRUE);
	}
	
}
