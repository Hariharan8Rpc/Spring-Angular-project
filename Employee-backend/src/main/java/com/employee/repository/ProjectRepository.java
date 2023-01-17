package com.employee.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;
import com.employee.model.Project;
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

	@Query(value="INSERT INTO `employee_management`.`employee_project`\r\n"
			+ "	(`employee_address_id`,\r\n"
			+ "	`project_id`)\r\n"  
			+ "	VALUES\r\n"
			+ "	(<{employee_address_id=:addrId }>,\r\n"
			+ "	<{project_id=:projectId }>)",nativeQuery=true)
	public ResponseEntity<Map<String,Boolean>> addEmployeesToProject(Long addrId,Long projectId);
	
//	@Query(value="SELECT employee.* FROM employee_project, employee WHERE `employee`.`address_id` = `employee_project`.`employee_address_id` AND employee_project.project_id =:id ",nativeQuery=true)
	@Modifying
	@Query(value="DELETE FROM employee_project \r\n"
			+ "WHERE employee_project.project_id =:projectId AND employee_project.employee_address_id=:addrId",nativeQuery=true)
	public void removeEmployeesFromProject(Long addrId,Long projectId);
	
}
