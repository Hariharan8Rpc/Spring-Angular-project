package com.employee.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="project")
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="title")
	private String title;
	@Column(name="domain")
	private String domain;
	@Column(name="duration")
	private int duration;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="admin_id")
	private Admin admin;	
	
//	@ManyToMany(cascade=CascadeType.ALL)
//	private Set<Employee> employee=new HashSet<>();
//		
//	
//	public Set<Employee> getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Set<Employee> employee) {
//		this.employee = employee;
//	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Project() {
		super();
	}

	
	public Project(String title, String domain, int duration, Admin admin) {
		super();
		this.title = title;
		this.domain = domain;
		this.duration = duration;
		this.admin = admin;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
