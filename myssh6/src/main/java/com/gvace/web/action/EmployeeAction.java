package com.gvace.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.gvace.domain.Department;
import com.gvace.domain.Employee;
import com.gvace.service.impl.EmployeeService;
import com.gvace.service.inter.DepartmentServiceInterface;
import com.gvace.service.inter.EmployeeServiceInterface;
import com.gvace.util.StringHelper;
import com.gvace.web.form.EmployeeForm;

public class EmployeeAction extends DispatchAction{
	@Resource
	EmployeeServiceInterface employeeService;
	@Resource
	DepartmentServiceInterface departmentService;
	
	public EmployeeServiceInterface getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeServiceInterface employeeService) {
		this.employeeService = employeeService;
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("departmentList", departmentService.executeQuery("from Department", null));
		return mapping.findForward("add");
	}
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("list");
	}
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//set id
		return mapping.findForward("update");
	}
	public ActionForward doAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm empForm = (EmployeeForm)form;
		Employee e = new Employee();
		e.setUsername(empForm.getUsername());
		e.setPassword(StringHelper.MD5(empForm.getPassword()));
		e.setName(empForm.getName());
		e.setEmail(empForm.getEmail());
		e.setGrade(empForm.getGrade());
		e.setHireDate(new java.util.Date());
		e.setSalary(empForm.getSalary());
		e.setDepartment((Department)departmentService.findById(Department.class,empForm.getDepartment_id()));
		
		try{
			employeeService.add(e);
		}
		catch(Exception exp){
			return mapping.findForward("err");
		}
		return mapping.findForward("ok");
	}
	public ActionForward doUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm empForm = (EmployeeForm)form;
		Employee e = new Employee();
		e.setUsername(empForm.getUsername());
		
		e = (Employee) ((EmployeeService)employeeService).login(e);
		if(e!=null){
			request.getSession().setAttribute("loginUser", e);
			return mapping.findForward("ok");
		}
		else{
			return mapping.findForward("err");
		}
	}
	public ActionForward doDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm empForm = (EmployeeForm)form;
		Employee e = new Employee();
		e.setUsername(empForm.getUsername());
		
		e = (Employee) ((EmployeeService)employeeService).login(e);
		if(e!=null){
			request.getSession().setAttribute("loginUser", e);
			return mapping.findForward("ok");
		}
		else{
			return mapping.findForward("err");
		}
	}
}
