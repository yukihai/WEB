<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Test</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	var x = <%=request.getAttribute("message")%>;
	if(x!=null)
	{
		alert(x);
	}
	$("#sid").val(localStorage.getItem("userid"));
});
</script>
</head>
<body>
<form action="AddNewTest" method="post">
<input id="sid" type="hidden" name="userid" value="0">
	Title: <input type="text" name="title"><br>
	Question number: <input type="text" name="quantity"><br>
	Course id: <input type="text" name="courseid"><br>
	Time: <input type="text" name="period"><br>
	<input type="submit" value="Create">
</form>
</body>
</html>