<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="test" method="post">
		<input type="hidden" name="testid" value="1">TestID = 1
		<input type="hidden" name="userid" value="2">userID = 2
		<input type="text" value=<%=request.getAttribute("point") %>>
		<input type="hidden" name="stt" value="0">
		<button>Start</button>
	</form>
</body>
</html>