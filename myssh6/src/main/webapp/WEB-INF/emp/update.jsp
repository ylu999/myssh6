<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/emp.do?r=doUpdate" method="post">
		<table>
			<tr><td>id</td><td><input name="id" type="text" readonly="readonly" value="${employee.id}"/></tr>
			<tr><td>Username</td><td><input name="username" type="text" value="${employee.username}"/></td></tr>
			<tr><td>Password</td><td><input name="password" type="password" value="${employee.password}"/></td></tr>
			<tr><td>Name</td><td><input name="name" type="text" value="${employee.name}"/></td></tr>
			<tr><td>Email</td><td><input name="email" type="text" value="${employee.email}"/></td></tr>
			<tr><td>Grade</td><td><input name="grade" type="text" value="${employee.grade}"/></td></tr>
			<tr><td>Hire Date</td><td><input name="hiredate" type="text" value="${employee.hireDate}"/></td></tr>
			<tr><td>Salary</td><td><input name="salary" type="text" value="${employee.salary}"/></td></tr>
			<tr><td>Department</td><td>

				<select name="department_id" >
					<c:forEach items="${departmentList}" var="department">
					    <c:choose>
					    	<c:when test="${department.id == employee.department.id}">
								<option value="${department.id}" selected>${department.name}</option>  
					    	</c:when>
					    	<c:otherwise>
								<option value="${department.id}">${department.name}</option>  
					    	</c:otherwise>
					    </c:choose>
					</c:forEach>					
				</select>
			</td></tr>
			<tr>
				<td><input type="submit" value="Update"/></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>