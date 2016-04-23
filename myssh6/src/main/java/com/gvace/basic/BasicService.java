package com.gvace.basic;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BasicService implements BasicServiceInterface{
	protected Class MODEL_CLASS;
	@Resource
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public Class getMODEL_CLASS() {
		return MODEL_CLASS;
	}


	public void setMODEL_CLASS(Class mODEL_CLASS) {
		MODEL_CLASS = mODEL_CLASS;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Object object) {
		sessionFactory.getCurrentSession().save(object);
	}

	public void deleteById(Serializable id) {
		executeQuery("delete from "+MODEL_CLASS.getName()+" where id=?",new Serializable[]{id});
	}

	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	public Object findById(Serializable id) {
		return sessionFactory.getCurrentSession().get(MODEL_CLASS, id);
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
	public Object uniqueResult(String hql, Object[] parameters) {
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

	public List<Object> listByPage(int page, int pageSize) {
		System.out.println("MODEL_NAME"+MODEL_CLASS.getName());
		return executeQueryByPage("from "+MODEL_CLASS.getName(), null, page, pageSize);
	}

	public int getCount() {
		return Integer.parseInt(uniqueResult("select count(*) from "+MODEL_CLASS.getName(), null).toString());
	}

	public int getPageCount(int pageSize) {
		return (getCount()-1)/pageSize + 1;
	}
}
