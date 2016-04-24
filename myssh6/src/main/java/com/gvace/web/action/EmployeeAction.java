package com.gvace.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.gvace.domain.Department;
import com.gvace.domain.Employee;
import com.gvace.service.inter.DepartmentServiceInterface;
import com.gvace.service.inter.EmployeeServiceInterface;
import com.gvace.util.StringHelper;
import com.gvace.web.form.EmployeeForm;

public class EmployeeAction extends DispatchAction{
	@Resource
	EmployeeServiceInterface employeeService;
	@Resource
	DepartmentServiceInterface departmentService;
	public void list(HttpServletRequest request){
		Integer page = StringHelper.getIntegerParameter(request, "page");
		if(page==null)page=1;
		Integer pageSize = StringHelper.getIntegerParameter(request, "pageSize");
		if(pageSize==null)pageSize=10;
		List<Object> employeeList = employeeService.listByPage(page, pageSize);
		request.setAttribute("employeeList", employeeList);
		request.setAttribute("pageCount", employeeService.getPageCount(pageSize));
		request.setAttribute("page", page);
	}
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
		return findForwardList(request, mapping,"list");
	}
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee e = (Employee) employeeService.findById(id);
		request.setAttribute("employee", e);
		request.setAttribute("departmentList", departmentService.executeQuery("from Department", null));
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
		e.setDepartment((Department)departmentService.findById(empForm.getDepartment_id()));
		try{
			employeeService.add(e);
		}
		catch(Exception exp){
			return mapping.findForward("err");
		}
		list(request);
		return mapping.findForward("ok");
	}
	public ActionForward doUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmployeeForm empForm = (EmployeeForm)form;
		Employee e = new Employee();
		e.setId(empForm.getId());
		e.setUsername(empForm.getUsername());
		e.setPassword(StringHelper.MD5(empForm.getPassword()));
		e.setName(empForm.getName());
		e.setEmail(empForm.getEmail());
		e.setGrade(empForm.getGrade());
		e.setHireDate(empForm.getHireDate());
		e.setSalary(empForm.getSalary());
		e.setDepartment((Department)departmentService.findById(empForm.getDepartment_id()));
		try{
			System.out.println(e.getId()+e.getName());
			employeeService.update(e);
		}
		catch(Exception exp){
			return mapping.findForward("err");
		}
		list(request);
		return mapping.findForward("ok");
	}
	public ActionForward doDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteById(id);
		return findForwardList(request,mapping,"list");
	}
	public ActionForward findForwardList(HttpServletRequest request,ActionMapping mapping,String forward){
		list(request);
		return mapping.findForward(forward);
	}
}
