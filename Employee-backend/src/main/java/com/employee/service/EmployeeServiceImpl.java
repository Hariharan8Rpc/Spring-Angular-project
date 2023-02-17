package com.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.exception.ErrorWhileDeletingException;
import com.employee.exception.NotAbleToSaveException;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.AddressRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.ProjectRepository;
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;
	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public ResponseEntity<Employee> save(Employee employee) {
		try {
		Employee emp1=repo.save(employee);
		return ResponseEntity.ok(emp1);	
		}catch (Exception e) {	throw new  NotAbleToSaveException("Not Able to save");
		}				
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> delete(long id) {
		Long addrid;		
		
		Employee employee1=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist id:"+ id));
		addrid=employee1.getAddress().getId();
		try {
		repo.deleteById(id);
		}catch (Exception e) {throw new ErrorWhileDeletingException("Error While Deletion");
		}
		Map<String,Boolean> response=new HashMap<>();
		response.put("Deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@Override
	public List<Employee> search(String keyword) {
		return repo.findByKeyword(keyword);
	}

	@Override
	public ResponseEntity<Employee> findEmployee(long id) {
		Employee employee1=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist id:"+ id));
//		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist id:"+ id));
		return ResponseEntity.ok(employee1);
	
	}

	@Override
	public ResponseEntity<Employee> update(Long id, Employee employee) {
		Employee employee1=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist id:"+ id));
		employee1.setFirstName(employee.getFirstName());
		employee1.setLastName(employee.getLastName());
		employee1.setDepartment(employee.getDepartment());	
		
		System.out.println(employee.getAddress().toString());
		employee1.setAddress(employee.getAddress());
//		employee1.setProject(employee.getProject());
//		Employee updatedemp=repo.save(employee1);
//	return ResponseEntity.ok(repo.save(employee1));
	try {
		Employee emp1=repo.save(employee1);
		return ResponseEntity.ok(emp1);	
		}catch (Exception e) {	throw new  NotAbleToSaveException("Not Able to save");
		}	
	}

	@Override
	public ResponseEntity<List<Employee>> employeeInProject(long id) {
		 List<Employee> n=repo.employeesInProject(id);
			return ResponseEntity.ok(repo.employeesInProject(id));
	}
	@Override
	public ResponseEntity<List<Employee>> employeeNotInProject(long id) {
		List<Employee> l1=repo.findAll();
		List<Employee> l2=repo.employeesInProject(id);
		List<Employee> result=l1.stream()
				.filter(x->l2.stream().noneMatch(y->y.getId()==x.getId()))
				.collect(Collectors.toList());
			return ResponseEntity.ok(result);
	}

}
