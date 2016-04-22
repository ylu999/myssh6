package com.gvace.service.impl;

import java.util.List;

import com.gvace.basic.BasicService;
import com.gvace.service.inter.DepartmentServiceInterface;

public class DepartmentService extends BasicService implements DepartmentServiceInterface{
	public List<Object> listByPage(int page, int pageSize) {
		return listByPage("Department",page,pageSize);
	}
}
