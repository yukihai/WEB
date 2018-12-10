<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
	User name:<input type="text" name="username">
	Password:<input type="password" name="password">
	<input type="submit" name="login" value="Login">
	<label name="state"><%= (request.getAttribute("message") == null) ? "" : request.getAttribute("message") %></label>
	</form>
</body>
</html>