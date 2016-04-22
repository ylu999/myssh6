package com.gvace.service.inter;

import java.util.List;

import com.gvace.basic.BasicServiceInterface;

public interface DepartmentServiceInterface extends BasicServiceInterface{
	public List<Object> listByPage(int page,int pageSize);
}
