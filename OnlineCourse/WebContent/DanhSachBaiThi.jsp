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
</head>
<body id="page-top">
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

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
				<a class="nav-link" href="index.html">
					<i class="fas fa-fw fa-tachometer-alt"></i>
					<span>Giao Diện</span>
				</a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-fw fa-folder"></i>
					<span>Trang</span>
				</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Màn hình đăng nhập:</h6>
					<a class="dropdown-item" href="login.html">Đăng nhập</a>
					<a class="dropdown-item" href="register.html">Đăng kí</a>
					<a class="dropdown-item" href="forgot-password.html">Quên mật khẩu</a>
					<div class="dropdown-divider"></div>
					<h6 class="dropdown-header">Các trang khác:</h6>
					<a class="dropdown-item" href="404.html">404 Page</a>
					<a class="dropdown-item" href="blank.html">Blank Page</a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-cubes"></i>
					<span>Quản lý thành viên</span>
				</a>

				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-item">Bao gồm: </h6>
					<a class="dropdown-item" href="thanhvien.html">Danh sách thành viên</a>
					<a class="dropdown-item" href="*">Thêm</a>
					<a class="dropdown-item" href="*">Sửa</a>
					<a class="dropdown-item" href="*">Xóa</a>
					<a class="dropdown-item" href="*">Tìm kiếm</a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-cubes"></i>
					<span>Quản lý đề thi</span>
				</a>

				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-item">Bao gồm: </h6>
					<a class="dropdown-item" href="Lambai.html">Danh sách đề thi</a>
					<a class="dropdown-item" href="*">Upload</a>
					<a class="dropdown-item" href="*">Sửa</a>
					<a class="dropdown-item" href="*">Xóa</a>
					<a class="dropdown-item" href="*">Tìm kiếm</a>
				</div>

			</li>


			<li class="nav-item">
				<a class="nav-link" href="charts.html">
					<i class="fas fa-fw fa-chart-area"></i>
					<span>Biểu đồ</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="tables.html">
						<i class="fas fa-fw fa-table"></i>
						<span>Bảng</span></a>
					</li>

					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i class="fas fa-portrait"></i>
							<span>Tài khoản cá nhân</span>
						</a>
						<div class="dropdown-menu" aria-labelledby="pagesDropdown">
							<h6 class="dropdown-item">Thông tin cá nhân: </h6>
							<a class="dropdown-item" href="taikhoan.html">Tài khoản</a>
							<a class="dropdown-item" href="*">Đổi mật khẩu</a>
							<a class="dropdown-item" href="*">Đăng xuất</a>
						</div>
					</li>
				</ul>
				<div id="content-wrapper">

					<div class="container-fluid">

						<!-- Breadcrumbs-->
						<ol class="breadcrumb">
							<li class="breadcrumb-item">
								<a href="#" style="color: black"><h5>Quản lý đề thi</h5></a>
							</li>
						</ol>

<form action="test" method="post">
<input type="hidden" name="yourtime" value="1800000">
<input type="hidden" name="testid" value=document.getElementById("tid")>
<input type="hidden" name="courseid" value="3">
<input type="hidden" name="stt" value="0">
<input type="hidden" name="userid" value="2">
						<div class="card mb-3">
							<div class="card-header">
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
											<thead>
												<tr>
													<th>Mã đề thi</th>
													<th>Tên đề thi</th>
													<th>Chủ đề</th>
													<th>Thời gian(phút)</th>
													<th>Độ khó</th>
													<th>Thành viên Upload</th>
													<th>Thao tác</th>
												</tr>
											</thead>

											<tfoot>
												<tr>
													<th>Mã đề thi</th>
													<th>Tên đề thi</th>
													<th>Chủ đề</th>
													<th>Thời gian(phút)</th>
													<th>Độ khó</th>
													<th>Thành viên Upload</th>
													<th>Thao tác</th>
												</tr>
											</tfoot>
											<tbody>
												<tr>
													<td id="tid">1</td>
													<td>Đề Thi 1</td>
													<td>Anh văn 5</td>
													<td>30.0</td>
													<td>Rất dễ</td>
													<td>Dương Văn Cường</td>
													<td><button>Làm bài</button></td>
												</tr>
												<tr>
													<td>2</td>
													<td>Đề Thi 2</td>
													<td>Toán 1</td>
													<td>30.0</td>
													<td>Rất dễ</td>
													<td>Phạm Ngọc Hải</td>
													<td><a type="button" class="btn btn-primary" href="*">Làm bài</a></td>
												</tr>

												<tr>
													<td>3</td>
													<td>Đề Thi 3</td>
													<td>Vật Lý 2</td>
													<td>30.0</td>
													<td>Rất dễ</td>
													<td>Đào Nhật Tâm</td>
													<td><a type="button" class="btn btn-primary" href="*">Làm bài</a></td>
												</tr>


											</tbody>
										</table>
									</div>
								</div>
								<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
							</div>
						</div>
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