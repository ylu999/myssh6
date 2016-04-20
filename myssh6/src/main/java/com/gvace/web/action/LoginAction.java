package com.gvace.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.gvace.domain.Employee;
import com.gvace.service.impl.EmployeeService;
import com.gvace.service.inter.EmployeeServiceInterface;
import com.gvace.web.form.LoginForm; 

public class LoginAction extends DispatchAction{
	@Resource
	EmployeeServiceInterface employeeService;
	
	public EmployeeServiceInterface getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeServiceInterface employeeService) {
		this.employeeService = employeeService;
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginForm loginForm = (LoginForm)form;
		if(loginForm.getPassword()==null || loginForm.getUsername()==null ) return mapping.findForward("err");
		Employee e = new Employee();
		e.setUsername(loginForm.getUsername());
		e.setPassword(loginForm.getPassword());
		
		e = (Employee) employeeService.login(e);
		if(e!=null){
			request.getSession().setAttribute("loginUser", e);
			return mapping.findForward("ok");
		}
		else{
			return mapping.findForward("err");
		}
	}
	
}
