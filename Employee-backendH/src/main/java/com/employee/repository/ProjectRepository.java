package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.model.Project;

import jakarta.transaction.Transactional;
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{
	@Transactional
	@Modifying
	@Query(value="INSERT INTO employee_project(employee_address_id,project_id)VALUES(:addrId,:projectId)",nativeQuery=true)
	public void addEmployeesToProject(Long addrId,Long projectId);

//	@Query(value="SELECT employee.* FROM employee_project, employee WHERE `employee`.`address_id` = `employee_project`.`employee_address_id` AND employee_project.project_id =:id ",nativeQuery=true)
	@Modifying
	@Query(value="DELETE FROM employee_project \r\n"
			+ "WHERE employee_project.project_id =:projectId AND employee_project.employee_address_id=:addrId",nativeQuery=true)
	public void removeEmployeesFromProject(Long addrId,Long projectId);
	@Transactional
	@Modifying
	@Query(value="delete from project where id=:projectId ",nativeQuery=true)
	public void removeProject(Long projectId);
}
