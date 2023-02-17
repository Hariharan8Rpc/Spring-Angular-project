package com.employee.hibernateDao;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeRepoI {

	void saveEmployee(Employee employee);

	void insertEmployee();

	void updateEmployee(Employee employee);

	void deleteEmployee(int id);

	Employee getEmployee(int id);

	List<Employee> getAllEmployee();

}