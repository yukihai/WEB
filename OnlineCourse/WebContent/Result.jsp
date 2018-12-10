<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Home.jsp">
	Điểm của bạn:<div><%=request.getAttribute("point") %>
	<button>Trang chủ</button>
</form>
</body>
</html>