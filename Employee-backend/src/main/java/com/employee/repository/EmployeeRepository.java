package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	@Query(value="select * from employee e where e.id like %:keyword% or e.last_name like %keyword% or e.first_name like %keyword% or e.department like %keyword%",nativeQuery=true)
	public List<Employee> findByKeyword(String keyword);

}
