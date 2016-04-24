<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<h2>Hello  ${loginUser.name} in ${loginUser.department.name}</h2>
	<a href="${pageContext.request.contextPath}/emp.do?r=add">Add employee</a><br/>
	<a href="${pageContext.request.contextPath}/emp.do?r=list">List employee</a><br/>
	<a href="${pageContext.request.contextPath}/emp.do?r=search">Search employee</a><br/>
	<a href="${pageContext.request.contextPath}/login.do?r=quit">Quit</a>
</body>
</html>