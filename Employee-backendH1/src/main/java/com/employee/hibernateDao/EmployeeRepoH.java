package com.employee.hibernateDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.model.Employee;


import jakarta.persistence.Persistence;
@Repository
public class EmployeeRepoH implements EmployeeRepoI {

jakarta.persistence.EntityManager  emgr;
	
	jakarta.persistence.EntityManagerFactory factory;
	
	jakarta.persistence.EntityTransaction trnx ;
	
	public EmployeeRepoH() {
		factory = Persistence.createEntityManagerFactory("EmployeeApp-persistence");
    	
    	emgr = factory.createEntityManager();
    	
    	trnx = emgr.getTransaction();
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		emgr.persist(employee);
		return employee;
		
	}


	@Override
	public void updateEmployee(Employee employee) {
		Employee emp = emgr.find(Employee.class, employee.getId());
		
		
		emp=employee;
		emgr.persist(employee);
	}

	@Override
	public boolean deleteEmployee(long id) {
		Employee emp = emgr.find(Employee.class, id);
    	trnx.begin();
    	emgr.remove(emp);
    	trnx.commit();
    	emp = emgr.find(Employee.class, id);
    	return emp==null;
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return emgr.find(Employee.class, id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		jakarta.persistence.TypedQuery<Employee> query1 = emgr.createQuery("from Employee",Employee.class);
    	List<Employee> employeeList = query1.getResultList();
    	 return employeeList;
	}

}
