<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>

<tr>
<form action="LoginServlet" method="post">
           Enter username:
			<input type="text" name="username"><br>
			Enter password:
			<input type="text" name="password"><br>
			<input type="submit"><br>			
</form>
</tr>
<h3>${incorrect}</h3>
<br>
<br>

<tr>
<form action="NewUserServlet" method="post">
           Select username:
			<input type="text" name="username"><br>
			Select password:
			<input type="text" name="password"><br>
			Select First Name:
			<input type="text" name="FirstName"><br>			
			Select Last Name:
			<input type="text" name="LastName"><br>	
			<input type="submit"><br>			
</form>
</tr>


</table>
</body>
</html>