package com.gvace.web.form;

import org.apache.struts.action.ActionForm;

public class EmployeeForm extends ActionForm {
	private String username;
	private String password;
	private String name;
	private String email;
	private Integer grade;
	private java.util.Date hireDate;
	private Float salary;
	private Integer department_id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public EmployeeForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
