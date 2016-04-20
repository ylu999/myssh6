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
	<h1>Add</h1>
	<form action="${pageContext.request.contextPath}/emp.do?r=doAdd" method="post">
		<table>
			<tr><td>Username</td><td><input name="username" type="text"></td></tr>
			<tr><td>Password</td><td><input name="password" type="password"></td></tr>
			<tr><td>Name</td><td><input name="name" type="text"></td></tr>
			<tr><td>Email</td><td><input name="email" type="text"></td></tr>
			<tr><td>Grade</td><td><input name="grade" type="text"></td></tr>
			<tr><td>Hire Date</td><td><input name="hiredate" type="text"></td></tr>
			<tr><td>Salary</td><td><input name="salary" type="text"></td></tr>
			<tr><td>Department</td><td>
				<select name="department_id">
					<c:forEach items="${departmentList}" var="department">
						<option value="${department.id}">${department.name}</option>  
					</c:forEach>					
				</select>
			</td></tr>
			<tr>
				<td><input type="submit" value="Add"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>
		</table>
	</form>
</body>
</html>