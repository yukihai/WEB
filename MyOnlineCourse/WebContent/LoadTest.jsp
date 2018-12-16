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
	<script src="js/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#sid").val(localStorage.getItem("userid"));
	var x = localStorage.getItem("level");
	if(x==1)
		{
			$("#hide0").hide();
			$("#hide4").hide();
			$(".mybt2").hide();
		}
	if(x==4)
		{
			$("#hide0").hide();
			$("#hide4").hide();
			$(".mybt").hide();
			$(".mybt2").hide();
		}
});
</script>
<script>
function DoTest(testid, quantity){
	$("#hide1").val(testid);
	$("#hide2").val(quantity);
};
</script>
<script>
function DoAction(x){
	$("#act").val(x);
};
</script>
<script>
function Toggle(x,y){
	$(x).toggle();
	$(y).hide();
	$("#input1").val("");
	$("#input2").val("");
};
</script>
</head>
<body id="page-top">
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top" onclick="DoTest('1','10')">

		<a class="navbar-brand mr-1" href="Home.jsp">Thi trắc nghiệm</a>

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

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href="Home.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i>
					<span>Trang chủ</span>
				</a>
			</li>
				</ul>
				<div id="content-wrapper">

					<div class="container-fluid">

						<!-- Breadcrumbs-->
						<ol class="breadcrumb">
							<li class="breadcrumb-item">
								<a href="#" style="color: black"><h5>Đề thi của lớp học</h5></a>			
							</li>
						</ol>
<div id="hide0">				
<button onclick="Toggle(div1,div2)">Thêm đề thi cho lớp</button>
<button onclick="Toggle(div2,div1)">Xóa đề thi khỏi lớp</button>
</div>

<div id="hide4">
<button onclick="Toggle(div3)">Thêm đề thi cho lớp học</button>
</div>

<form action="AddRemoveTest" method="get">
<input type="hidden" name="action" id="act">
<div id="div1" style="display: none;">Mã đề thi cần thêm:<input type="text" name="newtestid" id="input1"><input type="submit" value="Lưu" onclick="DoAction(1)"></div>
<div id="div2" style="display: none;">Mã đề thi cần xóa:<input type="text" name="oldtestid" id="input2"><input type="submit" value="Xóa" onclick="DoAction(2)"></div>
</form>

<form action="TestControl" method="get">
<div id="div3" style="display: none;">Mã đề thi:<input type="text" name="selectedtestid" id="input3">Mã lớp học:<input type="text" name="classid" id="input4"><input type="submit" value="Lưu" onclick="DoAction(3)"></div>
</form>

<form action="test" method="post">
<input id="hide1" type="hidden" name="testid" value="0">
<input id="hide2" type="hidden" name="quantity" value="0">
<input id="hide3" type="hidden" name="classid" value=<%=request.getAttribute("classid") %>>
<input type="hidden" name="userid" value=<%=request.getAttribute("userid") %>>
<div>${table}</div>
</form>						
						
						<!-- Sticky Footer -->
						<footer class="sticky-footer">
							<div class="container my-auto">
								<div class="copyright text-center my-auto">
									<span>Copyright © Your Website 2018</span>
								</div>
							</div>
						</footer>
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