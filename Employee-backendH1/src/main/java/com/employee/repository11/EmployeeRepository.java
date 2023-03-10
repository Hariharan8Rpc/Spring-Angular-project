package com.employee.repository11;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;
import com.employee.model.employeSql;

import jakarta.transaction.Transactional;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query(value="select * from employee e where e.address_id like %:keyword% or e.last_name like %:keyword% or e.first_name like %:keyword% or e.department like %:keyword%",nativeQuery=true)
	public List<Employee> findByKeyword(String keyword);
	@Transactional
	void deleteByaddress_id(long id);
	
	@Query(value="SELECT employee.* FROM employee_project, employee WHERE `employee`.`address_id` = `employee_project`.`employee_address_id` AND employee_project.project_id =:id ",nativeQuery=true)
	public List<Employee> employeesInProject(Long id);
	
//	@Query(value="SELECT employee.* FROM employee_project, employee WHERE `employee`.`address_id` = `employee_project`.`employee_address_id` AND employee_project.project_id !=:id ",nativeQuery=true)
//	public List<Employee> employeesNotInProject(Long id);
}
