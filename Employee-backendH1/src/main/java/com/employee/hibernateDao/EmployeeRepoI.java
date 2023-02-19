package com.employee.hibernateDao;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeRepoI {

	Employee saveEmployee(Employee employee);

//	void insertEmployee();

	void updateEmployee(Employee employee);

	boolean deleteEmployee(long id);

	Employee getEmployee(long id);

	List<Employee> getAllEmployee();

}