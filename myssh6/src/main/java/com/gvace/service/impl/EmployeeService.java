package com.gvace.service.impl;

import com.gvace.basic.BasicService;
import com.gvace.domain.Employee;
import com.gvace.domain.User;
import com.gvace.service.inter.EmployeeServiceInterface;
import com.gvace.util.StringHelper;


public class EmployeeService extends BasicService implements EmployeeServiceInterface{

	public Employee login(User User) {
		String hql = "from Employee where username=? and password=?";
		Object[] parameters = {User.getUsername(),StringHelper.MD5(User.getPassword())};
		Employee e = (Employee)executeQueryUniqueResult(hql, parameters);
		return e;
	}
}
