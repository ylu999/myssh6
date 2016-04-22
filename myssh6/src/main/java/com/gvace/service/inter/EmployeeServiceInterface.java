package com.gvace.service.inter;

import java.util.List;

import com.gvace.basic.BasicServiceInterface;
import com.gvace.domain.Employee;
import com.gvace.domain.User;

public interface EmployeeServiceInterface extends BasicServiceInterface{
	public List<Object> listByPage(int page,int pageSize);
	public Employee login(User User);
}
