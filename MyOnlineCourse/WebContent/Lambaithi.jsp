<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Giao Dien</title>

	<!-- Bootstrap core CSS-->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom fonts for this template-->
	<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

	<!-- Custom styles for this template-->
	<link href="css/sb-admin.css" rel="stylesheet">
	
<script>
	var distance = <%=request.getAttribute("yourtime")%>;
	var x = setInterval(function() {
		// Time calculations for days, hours, minutes and seconds
		var days = Math.floor(distance / (1000 * 60 * 60 * 24));
		var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
		var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
		var seconds = Math.floor((distance % (1000 * 60)) / 1000);

		// Output the result in an element with id="demo"
		document.getElementById("time").innerHTML = "Your time left: " + hours + ":" + minutes + ":" + seconds;
		document.getElementById("hide1").value = "Your time left: " + hours + ":" + minutes + ":" + seconds;
		distance-=1000;
		document.getElementById("hide").value = distance;
		// If the count down is over, write some text 
		if (distance < 0) {
			clearInterval(x);
			document.getElementById("time").innerHTML = "Time out!";
		}
	}, 1000);
</script>
<script src="js/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	var ans = <%=request.getAttribute("checked")%>;
	$("#"+ans).prop("checked",true);
	var num=<%=request.getAttribute("stt")%>;
	var max=<%=request.getAttribute("quantity")%>;
	if(num>=max)
	{
		$("#view1").prop("hidden",true);
		$("#view2").prop("hidden",false);
	}
	else
	{
		$("#view1").prop("hidden",false);
		$("#view2").prop("hidden",true);
	}
	if(num==0) $("#btback").hide();
});
</script>
</head>
<body id="page-top">
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="index.html">Thi trắc nghiệm</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow mx-1">
				<a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-bell fa-fw"></i>
					<span class="badge badge-danger">100+</span>
				</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
					<a class="dropdown-item" href="#">Hoạt động</a>
					<a class="dropdown-item" href="#">Hoạt động khác</a>
				</div>
			</li>
			<li class="nav-item dropdown no-arrow mx-1">
				<a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-envelope fa-fw"></i>
					<span class="badge badge-danger">99</span>
				</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
					<a class="dropdown-item" href="#">Hoạt động</a>
					<a class="dropdown-item" href="#">Hoạt động khác</a>
				</div>
			</li>
			<li class="nav-item dropdown no-arrow">
				<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-user-circle fa-fw"></i>
				</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">Cài đặt</a>
					<a class="dropdown-item" href="#">Các hoạt động</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
				</div>
			</li>
		</ul>

	</nav>

	<div id="wrapper">
				<div id="content-wrapper">

					<div class="container-fluid">

					<form action="LoadQuestionsServlet" method="post">
					<input type="hidden" id="hide" name="yourtime" value=<%=request.getAttribute("yourtime")%>>
					<input type="hidden" id="hide1" name="previoustime" value=<%=request.getAttribute("previoustime")%>>
					<input type="hidden" id="hide2" name="testid" value=<%=request.getAttribute("testid")%>>
					<input type="hidden" id="hide3" name="courseid" value=<%=request.getAttribute("courseid")%>>
					<input type="hidden" id="hide4" name="stt" value=<%=request.getAttribute("stt")%>>
					<input type="hidden" id="hide5" name="go">
					<input type="hidden" id="hide6" name="questionid" value=<%=request.getAttribute("questionid")%>>
					<input type="hidden" id="hide7" name="userid" value=<%=request.getAttribute("userid")%>>
					<input type="hidden" id="hide8" name="quantity" value=<%=request.getAttribute("quantity")%>>
					<input type="hidden" id="hide9" name="classid" value=<%=request.getAttribute("classid")%>>
						<!-- Breadcrumbs-->
						<ol class="breadcrumb">
							<li class="breadcrumb-item">
								<div id="time"><%=request.getAttribute("previoustime")%></div>
							</li>
						</ol>
						
						<div id="view1" class="card mb-3" hidden="hidden">
							<div class="card-header">
								<div class="card-body">
									<div id="Question"><%=(request.getAttribute("Question") == null) ? "" : request.getAttribute("Question")%></div><br>
									<input id="1" value="1" type="radio" name="answer"><%=request.getAttribute("A")%><br>
									<input id="2" value="2" type="radio" name="answer"><%=request.getAttribute("B")%><br>
									<input id="3" value="3" type="radio" name="answer"><%=request.getAttribute("C")%><br>
									<input id="4" value="4" type="radio" name="answer"><%=request.getAttribute("D")%><br>
									</div>
									<button id="btback" onclick="document.getElementById('hide5').value = 2">Quay lại</button>
									<button id="btnext" onclick="document.getElementById('hide5').value = 1" style="position:absolute;right:20px">Tiếp theo</button>
								</div>
						</div>
						<div id="view2" hidden="hidden">
							Kết thúc bài kiểm tra?
							<button onclick="document.getElementById('hide5').value = 2">Quay lại</button>
							<button onclick="document.getElementById('hide5').value = 1" style="position:absolute;right:20px">Kết thúc</button>
						</div>
					</form>
					</div>
				</div>
			</div>


			<!-- Bootstrap core JavaScript-->
			<script src="vendor/jquery/jquery.min.js"></script>
			<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

			<!-- Core plugin JavaScript-->
			<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
			
		</body>
</html>