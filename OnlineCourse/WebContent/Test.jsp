<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="myCSS.css">
<meta charset="UTF-8">
<title>Test</title>
<script src="jquery-3.3.1.min.js"></script>
<script>
	//Set the date we're counting down to
	var countDownDate = new Date(new Date().getTime() + 1801000);

	// Update the count down every 1 second
	var x = setInterval(function() {
		
		// Get todays date and time
		var now = new Date().getTime();

		// Find the distance between now and the count down date
		var distance = countDownDate - now;

		// Time calculations for days, hours, minutes and seconds
		var days = Math.floor(distance / (1000 * 60 * 60 * 24));
		var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
				/ (1000 * 60 * 60));
		var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
		var seconds = Math.floor((distance % (1000 * 60)) / 1000);

		// Output the result in an element with id="demo"
		document.getElementById("demo").innerHTML = "Your time left: " + hours + ":"
				+ minutes + ":" + seconds;

		// If the count down is over, write some text 
		if (distance < 0) {
			clearInterval(x);
			document.getElementById("demo").innerHTML = "Time out!";
		}
	}, 1000);
</script>
<script>
$(document).ready(function(){
	$("button").click(function(){
		var id1, id2;
		if(parseInt(this.id) % 2 == 0)
		{
			id1 = (String)(parseInt(this.id)-1);
			id2 = this.id;
		}
		else
		{
			id1 = this.id;
			id2 = (String)(parseInt(this.id)+1);
		}
		$("#Quest1").load("Questions.html #q" + id1);
		$("#Quest2").load("Questions.html #q" + id2);
		$("#1A").load("Answers.html #q" + id1 + "a");
		$("#1B").load("Answers.html #q" + id1 + "b");
		$("#1C").load("Answers.html #q" + id1 + "c");
		$("#1D").load("Answers.html #q" + id1 + "d");
		$("#2A").load("Answers.html #q" + id2 + "a");
		$("#2B").load("Answers.html #q" + id2 + "b");
		$("#2C").load("Answers.html #q" + id2 + "c");
	 	$("#2D").load("Answers.html #q" + id2 + "d"); 
	});
});
</script>
</head>
<body>
	<center>
		<h1 id="demo">Loading ...</h1>
	</center>
	<br>
	<table>
		<tr>
			<th id="Quest1" style="text-align:center;"><script>$("#Quest1").load("Questions.html #q1");</script></th>
			<th rowspan="4">
  				<div style="padding:2px;display:inline;"><button id="1">1</button></div>
  				<div style="padding:2px;display:inline;"><button id="2">2</button></div>
  				<div style="padding:2px;display:inline;"><button id="3">3</button></div>
  				<div style="padding:2px;display:inline;"><button id="4">4</button></div>
  				<div style="padding:2px;display:inline;"><button id="5">5</button></div>
  				<div style="padding:2px;display:inline;"><button id="6">6</button></div>
				<br>
				<br>
				<button id="next" type="submit" style="width:100px;height:25px;">Next</button>
				<a href="Result.jsp"><div style="padding:5px;"><input type="submit" value="Finish" style="width:100px;" style="float: bottom;"></div></a>
			</th>
		</tr>
		<tr>
			<td>
				<div style="padding-top:30px;"><input type="radio" name="answer1"><label id="1A"><script>$("#1A").load("Answers.html #q1a");</script></label><br></div>
				<div style="padding-top:30px;"><input type="radio" name="answer1"><label id="1B"><script>$("#1B").load("Answers.html #q1b");</script></label><br></div>
				<div style="padding-top:30px;"><input type="radio" name="answer1"><label id="1C"><script>$("#1C").load("Answers.html #q1c");</script></label><br></div>
				<div style="padding-top:30px;"><input type="radio" name="answer1"><label id="1D"><script>$("#1D").load("Answers.html #q1d");</script></label><br></div>
			</td>
		</tr>
		<tr>
			<th id="Quest2" style="text-align:center;"><script>$("#Quest2").load("Questions.html #q2");</script></th>
		</tr>
		<tr>	
			<td>
				<div style="padding-top:30px;"><input type="radio" name="answer2"><label id="2A"><script>$("#2A").load("Answers.html #q2a");</script></label><br></div>
				<div style="padding-top:30px;"><input type="radio" name="answer2"><label id="2B"><script>$("#2B").load("Answers.html #q2b");</script></label><br></div>
				<div style="padding-top:30px;"><input type="radio" name="answer2"><label id="2C"><script>$("#2C").load("Answers.html #q2c");</script></label><br></div>
				<div style="padding-top:30px;"><input type="radio" name="answer2"><label id="2D"><script>$("#2D").load("Answers.html #q2d");</script></label><br></div>
			</td>
		</tr>
	</table>
</body>
</html>