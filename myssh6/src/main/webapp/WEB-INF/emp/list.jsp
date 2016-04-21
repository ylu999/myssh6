<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr><th>id</th><th>username</th><th>name</th><th>email</th><th>grade</th><th>hireDate</th><th>Salary</th><th>Department</th><th></th><th></th></tr>
			<c:forEach items="${employeeList}" var="employee">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.username}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.grade}</td>
					<td>${employee.hireDate}</td>
					<td>${employee.salary}</td>
					<td>${employee.department.name}</td>
					<td>
						<a href="${pageContext.request.contextPath}/emp.do?r=update&id=${employee.id}">Update</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/emp.do?r=doDelete&id=${employee.id}">Delete</a>
					</td>
				</tr>  
			</c:forEach>
	</table>	
</body>
</html>