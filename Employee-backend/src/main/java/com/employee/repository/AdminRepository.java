package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long>{

}
