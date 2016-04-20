<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Login</h1>
	
	<form action="login.do?r=login" method="post">
		<table>
			<tr>
				<td>username:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
				<td><input type="reset" value="Reset"/></td>
			</tr>	
		</table>
	</form>
</body>
</html>
