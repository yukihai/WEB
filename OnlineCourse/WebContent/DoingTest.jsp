<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	var ans = <%=request.getAttribute("checked")%>;
	if(ans!=null)
	{
		$("#"+ans).prop("checked",true);
	}
	var distance = <%=request.getAttribute("yourtime")%>;
	var x = setInterval(function() {
		// Time calculations for days, hours, minutes and seconds
		var days = Math.floor(distance / (1000 * 60 * 60 * 24));
		var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
		var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
		var seconds = Math.floor((distance % (1000 * 60)) / 1000);

		// Output the result in an element with id="demo"
		document.getElementById("time").innerHTML = "Your time left: " + hours + ":" + minutes + ":" + seconds;
		distance-=1000;
		document.getElementById("hide").value = distance;
		// If the count down is over, write some text 
		if (distance < 0) {
			clearInterval(x);
			document.getElementById("time").innerHTML = "Time out!";
		}
	}, 1000);
</script>
</head>
<body>
<form action="LoadQuestionsServlet" method="post">
<input type="hidden" id="hide" name="yourtime">
<input type="hidden" id="hide2" name="testid" value=<%=request.getAttribute("testid")%>>
<input type="hidden" id="hide3" name="courseid" value=<%=request.getAttribute("courseid")%>>
<input type="hidden" id="hide4" name="stt" value=<%=request.getAttribute("stt")%>>
<input type="hidden" id="hide5" name="go">
<input type="hidden" id="hide6" name="questionid" value=<%=request.getAttribute("questionid")%>>
<input type="hidden" id="hide7" name="userid" value=<%=request.getAttribute("userid")%>>
<h1 id="time"></h1>
	<div id="Question"><%=(request.getAttribute("Question") == null) ? "" : request.getAttribute("Question")%></div><br>
	<label>A:</label><input id="1" value="1" type="radio" name="answer"><%=request.getAttribute("A")%><br>
	<label>B:</label><input id="2" value="2" type="radio" name="answer"><%=request.getAttribute("B")%><br>
	<label>C:</label><input id="3" value="3" type="radio" name="answer"><%=request.getAttribute("C")%><br>
	<label>D:</label><input id="4" value="4" type="radio" name="answer"><%=request.getAttribute("D")%><br>
	<button onclick="document.getElementById('hide5').value = 1">Next</button><br><br>
	<button onclick="document.getElementById('hide5').value = 2">Back</button>
</form>
</body>
</html>