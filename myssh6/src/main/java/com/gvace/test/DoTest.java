package com.gvace.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts.action.Action;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gvace.domain.Department;
import com.gvace.domain.Employee;
import com.gvace.domain.User;
import com.gvace.service.impl.EmployeeService;
import com.gvace.service.inter.DepartmentServiceInterface;
import com.gvace.service.inter.EmployeeServiceInterface;
import com.gvace.util.StringHelper;

public class DoTest extends Action{
	public static void main(String[] args){
		System.out.println("???????????????????");
		 System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/applicationContext.xml");
		System.out.println("???????????????????");

		System.out.println("AAAAAAAAAAAa");
		
		Employee e = new Employee();
		e.setUsername("a");
		e.setPassword(StringHelper.MD5("a"));
		e.setName("aaa");
		e.setEmail("aaa@gvace.com");
		e.setHireDate(new Date());
		e.setSalary(80000f);
		e.setGrade(1);
		
		EmployeeServiceInterface employeeServiceInter = (EmployeeServiceInterface)context.getBean("employeeService");
		User user = ((EmployeeService)employeeServiceInter).login(e);
		if(user!=null){
			System.out.println("login good");
		}
		else{
			System.out.println("login bad");
		}
	}
	public void getWebApplicationContext(){
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(
				this.getServlet().getServletContext());
	}
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeServiceInterface employeeServiceInterface = (EmployeeServiceInterface)ac.getBean("employeeService");
		DepartmentServiceInterface departmentServiceInterface = (DepartmentServiceInterface)ac.getBean("departmentService");

		Employee employee = new Employee();
		
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(employee);
		
		Department department = new Department();
		department.setName("CS");
		department.setDescription("Computer Science");
		department.setEmployees(employees);
		
		employee.setUsername("b");
		employee.setPassword(StringHelper.MD5("b"));
		employee.setName("bbb");
		employee.setEmail("bbb@gvace.com");
		employee.setGrade(1);
		employee.setSalary(80000f);
		employee.setDepartment(department);
		//employeeServiceInterface.addEmployee(employee);
		departmentServiceInterface.add(department);
		
	}
	@Test
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentServiceInterface departmentServiceInterface = (DepartmentServiceInterface)ac.getBean("departmentService");
		Department d = (Department) departmentServiceInterface.findById(Department.class,1);
		System.out.println(d.getName());
	}
}
