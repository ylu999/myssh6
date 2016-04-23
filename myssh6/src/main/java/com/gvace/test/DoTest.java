package com.gvace.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts.action.Action;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gvace.domain.Department;
import com.gvace.domain.Employee;
import com.gvace.service.inter.DepartmentServiceInterface;
import com.gvace.service.inter.EmployeeServiceInterface;
import com.gvace.util.StringHelper;

public class DoTest extends Action{

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
		Department d = (Department) departmentServiceInterface.findById(1);
		System.out.println(d.getName());
	}
	@Test
	public void test3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeServiceInterface employeeServiceInterface = (EmployeeServiceInterface)ac.getBean("employeeService");
		List<Object> list = employeeServiceInterface.listByPage(1, 10);
		for(Object o: list){
			System.out.println("Employee:"+((Employee)o).getName());
		}
	}
	@Test
	public void test4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentServiceInterface departmentServiceInterface = (DepartmentServiceInterface)ac.getBean("departmentService");
		List<Object> list = departmentServiceInterface.listByPage(1, 10);
		for(Object o: list){
			System.out.println("Department:"+((Department)o).getName());
		}
	}
	@Test
	public void test5(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentServiceInterface departmentServiceInterface = (DepartmentServiceInterface)ac.getBean("departmentService");
		System.out.println(departmentServiceInterface.getCount());
	}
}
