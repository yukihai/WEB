<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Add Question</title>

<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(
			function() {
				$("button").click(
						function() {
							$.post("AddQuestionsServlet", {
								courseid : $("#courseid").val(),
								questioncontent : $("#questioncontent").val(),
								answerA : $("#Acontent").val(),
								answerB : $("#Bcontent").val(),
								answerC : $("#Ccontent").val(),
								answerD : $("#Dcontent").val(),
								correctanswer : $(
										"input[name='correctanswer']:checked")
										.attr("id"),
							}, function(data, status) {
								alert("Data: " + data);
								$(location).attr('href', "AddQuestions.jsp");
							})
						});
			});
</script>
</head>
<div id="wrapper">

	<!-- Sidebar -->
	<ul class="sidebar navbar-nav">
		<li class="nav-item active"><a class="nav-link" href="index.html">
				<i class="fas fa-fw fa-tachometer-alt"></i> <span>Trang chủ</span>
		</a></li>

		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-portrait"></i> <span>Tài khoản cá nhân</span>
		</a>
			<div class="dropdown-menu" aria-labelledby="pagesDropdown">
				<h6 class="dropdown-item">Thông tin cá nhân:</h6>
				<a class="dropdown-item" href="taikhoan.html">Tài khoản</a> <a
					class="dropdown-item" href="*">Đổi mật khẩu</a> <a
					class="dropdown-item" href="*">Đăng xuất</a>
			</div></li>
	</ul>
	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Giao Diện</a></li>
			</ol>
			<input type="hidden" id="courseid" value="3">
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
				A:
				<textarea id="Acontent" style="width: 80%; height: 50px"></textarea>
				<input id="0" type="radio" name="correctanswer">Correct
				Answer
			</div>
			<div style="padding-top: 30px">
				B:
				<textarea id="Bcontent" style="width: 80%; height: 50px"></textarea>
				<input id="1" type="radio" name="correctanswer">Correct
				Answer
			</div>
			<div style="padding-top: 30px">
				C:
				<textarea id="Ccontent" style="width: 80%; height: 50px"></textarea>
				<input id="2" type="radio" name="correctanswer">Correct
				Answer
			</div>
			<div style="padding-top: 30px">
				D:
				<textarea id="Dcontent" style="width: 80%; height: 50px"></textarea>
				<input id="3" type="radio" name="correctanswer">Correct
				Answer
			</div>
			<br>
			<button>Save</button>

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Your Website 2018</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>
</div>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/datatables/jquery.dataTables.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="js/demo/datatables-demo.js"></script>
<script src="js/demo/chart-area-demo.js"></script>
</body>
</html>