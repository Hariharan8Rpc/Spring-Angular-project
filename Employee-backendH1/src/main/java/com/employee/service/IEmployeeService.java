package com.employee.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.employee.model.Employee;

public interface IEmployeeService {
	public List<Employee> getAllEmployees();
	public ResponseEntity<Employee>save(Employee employee) ;
	public ResponseEntity<Map<String,Boolean>>delete(long id);
//	public List<Employee> search(String keyword);
	public ResponseEntity<Employee> findEmployee(long id);
	public ResponseEntity<Employee> update(Long id,Employee employee);
//	public ResponseEntity<List<Employee>> employeeInProject( long id);
//	public ResponseEntity<List<Employee>> employeeNotInProject( long id);
}
