package com.gvace.basic;

import java.io.Serializable;
import java.util.List;

public interface BasicServiceInterface {
	public void add(Object object);
	public Object deleteById(Class clazz,Serializable id);
	public void update(Object object);
	public Object findById(Class clazz,Serializable id);
	public List<Object> executeQuery(String hql,Object[] parameters);
	public Object uniqueResult(String hql, Object[] parameters);
	public List<Object> executeQueryByPage(String hql,Object[] parameters,int page,int pageSize);
	public List<Object> listByPage(int page,int pageSize);
	public List executeUpdate(String hql, Object[] parameters);
	public int getCount();
	public int getPageCount(int pageSize);
}
