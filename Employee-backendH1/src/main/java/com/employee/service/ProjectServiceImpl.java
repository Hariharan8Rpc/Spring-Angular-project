package com.employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.exception.ErrorWhileDeletingException;
import com.employee.exception.NotAbleToSaveException;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Admin;
import com.employee.model.Project;
//import com.employee.repository.AdminRepository;
//import com.employee.repository.EmployeeRepository;
//import com.employee.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectServiceImpl implements IProjectService {
	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private ProjectRepository projectRepo;
		
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public ResponseEntity<Project> AddProject(long id, Project project) {
		Project project1=new Project();
		Admin admin1=new Admin();
		admin1=adminRepo.getReferenceById(id);
		project1=project;
		project1.setAdmin(admin1);
		
		return ResponseEntity.ok(projectRepo.save(project1));
	}
	
	@Override
	public List<Project> getAllProject(){
		return projectRepo.findAll();
	}
	
	@Override
	public ResponseEntity<Map<String,Boolean>>delete(long id){
		Project project=projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project Not Found"));
		projectRepo.removeProject(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Project Deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@Override
	public ResponseEntity<Project>findProject(long id) {
		Project p=new Project();		
		p= projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project Not Found"));
		return ResponseEntity.ok(p);
	}
	
	@Override	
	public ResponseEntity<Project> update(Long id, Project project) {
		Project project1=projectRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Project Not Found"));
		project1.setTitle(project.getTitle());
		project1.setDomain(project.getDomain());
		project1.setDuration(project.getDuration());		
		Admin admin1=new Admin();
		admin1=adminRepo.getReferenceById(project.getAdmin().getId());
		project1.setAdmin(project1.getAdmin());
		
		return ResponseEntity.ok(projectRepo.save(project1));
	}
	@Override	
	public ResponseEntity<Map<String, Boolean>> insertEmployees(Long addrId, Long projectId) {
		System.out.println(addrId+ " "+projectId);
		try {
		projectRepo.addEmployeesToProject(addrId, projectId);
		Map<String,Boolean> response=new HashMap<>();
		response.put(" Employee: "+addrId+"Added to Project",Boolean.TRUE);
		return ResponseEntity.ok(response);
		}catch(Exception e) {
			throw new NotAbleToSaveException("Error while Adding Employee to project :"+projectId);
			
		}
	}
	
	@Override
	@Transactional
	public ResponseEntity<Map<String, Boolean>> deleteEmployees( Long addrId,Long projectId) {
		try {
		projectRepo.removeEmployeesFromProject(addrId, projectId);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Removed employee"+ projectId +"Project",Boolean.TRUE);
		return ResponseEntity.ok(response);
		}catch (Exception e){
			throw new ErrorWhileDeletingException("Error while Deleting Employee:"+addrId+" from project");
		}
		
	}
	



}
