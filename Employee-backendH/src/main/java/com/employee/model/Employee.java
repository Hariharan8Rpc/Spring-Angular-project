package com.employee.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="employee")
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")

	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="department")
	private String department;

	@OneToOne(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	@MapsId                        //updated
	@JoinColumn(name="address_id")// updated
	private Address address;

	@ManyToMany(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	private List<Project> project=new ArrayList<>();


	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}


	public Employee() {
		super();
	}


	public Employee(String firstName, String lastName, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	public Employee(String firstName, String lastName, String department, Address address, List<Project> project) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.address = address;
		this.project = project;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

//	addrees getter and setter

}
