package com.db.jpademo2.model;

import javax.persistence.*;

import com.db.pojo.Allocation;

import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@Transient
	private Allocation[] allocations;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Telephone> telephoneList;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_employee",joinColumns = {@JoinColumn(name = "project_id")},inverseJoinColumns = {@JoinColumn(name = "employee_id")})
	private List<Project> projects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Allocation[] getAllocations() {
		return allocations;
	}

	public void setAllocations(Allocation[] allocations) {
		this.allocations = allocations;
	}

	public List<Telephone> getTelephoneList() {
		return telephoneList;
	}

	public void setTelephoneList(List<Telephone> telephoneList) {
		this.telephoneList = telephoneList;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}