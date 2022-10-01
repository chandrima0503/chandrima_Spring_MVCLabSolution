package com.greatLearning.DebateRegistration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@Column(name="StudentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name="Name")
	private String name;
	@Column(name="Department")
	private String department;
	@Column(name="Country")
	private String country;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public Student(int id, String name, String department, String country) {
		super();
		Id = id;
		this.name = name;
		this.department = department;
		this.country = country;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", department=" + department + ", country=" + country + "]";
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
