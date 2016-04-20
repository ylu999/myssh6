package com.gvace.domain;

public class Employee extends User{
	private Integer id;
	private String name;
	private String email;
	private Integer grade;
	private java.util.Date hireDate;
	private Department department;
	private Float salary;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public java.util.Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	
}
