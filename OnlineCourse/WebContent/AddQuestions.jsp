<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Add Question</title>

	<!-- Bootstrap core CSS-->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom fonts for this template-->
	<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

	<!-- Custom styles for this template-->
	<link href="css/sb-admin.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
    $("button").click(function(){
        $.post("AddQuestionsServlet",
        	{
        		courseid:$("#courseid").val(), 
        		questioncontent:$("#questioncontent").val(),
        		answerA:$("#Acontent").val(),
        		answerB:$("#Bcontent").val(),
        		answerC:$("#Ccontent").val(),
        		answerD:$("#Dcontent").val(),
        		correctanswer:$("input[name='correctanswer']:checked").attr("id"),
        	},function(data,status){
            alert("Data: " + data);
            $(location).attr('href',"AddQuestions.jsp");
        })
    });
});
</script>
</head>
<body>
	<input type="hidden" id ="courseid" value="3">
		<div style="padding-top: 30px">
			<label>Home/Courses/English</label>
		</div>
		<div style="padding-top: 30px">
			Question:<br>
			<textarea style="width: 80%; height: 100px" id="questioncontent"></textarea>
			<br>
		</div>
		<br>Answer:<br>
		<div style="padding-top: 30px">
			A:<textarea id="Acontent" style="width: 80%; height: 50px"></textarea><input id="0" type="radio" name="correctanswer">Correct Answer
		</div>
		<div style="padding-top: 30px">
			B:<textarea id="Bcontent" style="width: 80%; height: 50px"></textarea><input id="1" type="radio" name="correctanswer">Correct Answer
		</div>
		<div style="padding-top: 30px">
			C:<textarea id="Ccontent" style="width: 80%; height: 50px"></textarea><input id="2" type="radio" name="correctanswer">Correct Answer
		</div>
		<div style="padding-top: 30px">
			D:<textarea id="Dcontent" style="width: 80%; height: 50px"></textarea><input id="3" type="radio" name="correctanswer">Correct Answer
		</div>
		<br><button>Save</button>
</body>
</html>