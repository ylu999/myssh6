package com.gvace.service.inter;

import com.gvace.basic.BasicServiceInterface;
import com.gvace.domain.Employee;
import com.gvace.domain.User;

public interface EmployeeServiceInterface extends BasicServiceInterface{
	public Employee login(User User);
}
