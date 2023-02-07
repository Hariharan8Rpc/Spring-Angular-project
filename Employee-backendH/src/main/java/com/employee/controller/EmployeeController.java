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
import com.employee.hibernateDao.EmployeeRepo;
import com.employee.model.Employee;
import com.employee.repository.AddressRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.ProjectRepository;

@RestController
@RequestMapping("/employeeApi")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private AddressRepository addrrepo;
	@Autowired
	private ProjectRepository projectrepo;

	@Autowired
	private EmployeeRepo empRepo;    

//	@GetMapping("/getAll")
	@GetMapping
	public List<Employee> getAllEmployees(){
		return empRepo.getAllEmployee();
	}
//	@PostMapping(value="/save")
	@PostMapping
	public ResponseEntity<Employee>save(@RequestBody Employee employee) {

		return ResponseEntity.ok(repo.save(employee));
	}

	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Map<String,Boolean>>delete(@PathVariable("id")long id) {
		Long addrid;

		Employee employee1=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist id:"+ id));
		addrid=employee1.getAddress().getId();
//		repo.deleteByaddress_id(addrid);
//		addrrepo.deleteById(addrid);
		repo.deleteById(id);

		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
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

			System.out.println(employee.getAddress().toString());
			employee1.setAddress(employee.getAddress());
//			employee1.setProject(employee.getProject());
//			Employee updatedemp=repo.save(employee1);
		return ResponseEntity.ok(repo.save(employee1));
	}

	@GetMapping("/employeeInProject/{id}")
	public ResponseEntity<List<Employee>> employeeInProject(@PathVariable long id){
		 List<Employee> n=repo.employeesInProject(id);
		return ResponseEntity.ok(repo.employeesInProject(id));
	}



}
