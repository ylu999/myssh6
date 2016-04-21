package com.gvace.basic;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BasicService implements BasicServiceInterface{
	@Resource
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Object object) {
		sessionFactory.getCurrentSession().save(object);
	}

	public Object deleteById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	public Object findById(Class clazz, Serializable id) {
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	public List<Object> executeQuery(String hql, Object[] parameters) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null){
			int i=0;
			for(Object param: parameters){
				q.setParameter(i, param);
				i++;
			}
		}
		return q.list();
	}
	public Object executeQueryUniqueResult(String hql, Object[] parameters) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null){
			int i=0;
			for(Object param: parameters){
				q.setParameter(i, param);
				i++;
			}
		}
		return q.uniqueResult();
	}
	public List<Object> executeQueryByPage(String hql, Object[] parameters,
			int page, int pageSize) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null){
			int i=0;
			for(Object param: parameters){
				q.setParameter(i, param);
				i++;
			}
		}
		q.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize);
		return q.list();
	}

	public List executeUpdate(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> listByPage(String className, int page, int pageSize) {
		return executeQueryByPage("from "+className, null, page, pageSize);
	}

}
