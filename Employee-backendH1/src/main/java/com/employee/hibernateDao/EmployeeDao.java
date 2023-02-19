package com.employee.hibernateDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;

import com.employee.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EmployeeDao implements  EmployeeRepoI{
	@Autowired
	private EntityManager entityManager;
	@Override
	public Employee saveEmployee(Employee employee) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		// TODO Auto-generated method stub
		Query<Employee> query=currentSession.createSession.createQuery("From Employee",Employee.class);
		
		return qgetuery.;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
