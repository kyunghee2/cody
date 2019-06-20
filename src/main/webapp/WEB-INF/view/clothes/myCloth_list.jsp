<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>옷 장</title>
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
<script src="../js/bootstrap.js"></script>
<link rel="stylesheet" href="../css/cody.css" type="text/css">
</head>
<body>
	<%@include file="/layout/header.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">

				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active" id="home-tab"
						data-toggle="tab" href="#home" role="tab" aria-controls="home"
						aria-selected="true">상의</a></li>
					<li class="nav-item"><a class="nav-link" id="profile-tab"
						data-toggle="tab" href="#profile" role="tab"
						aria-controls="profile" aria-selected="false">하의</a></li>

					<a href="http://localhost:9090/cody/clothes/cloth_add.do"
						class="btn btn-outline-dark" role="button" style="float: right;">옷등록</a>
					<a class="btn btn-outline-dark" role="button" style="float: right;">옷삭제</a>

				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="col-xs-6 col-md-3 input-group-append overflow-auto" id="topclothes">
							<a href="#" class="thumbnail"> <img
								src="../img/clouds-3488632_1920.jpg"></a> <a href="#"
								class="thumbnail"> <img
								src="../img/cold-front-63037_1920.jpg"></a> <a href="#"
								class="thumbnail"> <img src="../img/rain-2422642_1920.jpg"></a>
							<a href="#" class="thumbnail"> <img
								src="../img/rain-731313_1920.jpg"></a> <a href="#"
								class="thumbnail"> <img src="../img/sky-2048854_1920.jpg"></a>
							<a href="#" class="thumbnail"> <img
								src="../img/clouds-3488632_1920.jpg"></a> <a href="#"
								class="thumbnail"> <img
								src="../img/cold-front-63037_1920.jpg"></a> <a href="#"
								class="thumbnail"> <img src="../img/rain-2422642_1920.jpg"></a>
							<a href="#" class="thumbnail"> <img
								src="../img/rain-731313_1920.jpg"></a> <a href="#"
								class="thumbnail"> <img src="../img/clouds-3488632_1920.jpg"></a>
							<a href="#" class="thumbnail"> <img
								src="../img/cold-front-63037_1920.jpg"></a> <a href="#"
								class="thumbnail"> <img src="../img/rain-2422642_1920.jpg"></a>
							<a href="#" class="thumbnail"> <img
								src="../img/rain-731313_1920.jpg"></a> <a href="#"
								class="thumbnail"> <img src="../img/sky-2048854_1920.jpg"></a>
						</div>

					</div>
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<div class="col-xs-6 col-md-3" id="pants">
							<a href="#" class="thumbnail"> <img src="../img/pic1.jpg"></a>
							<a href="#" class="thumbnail"> <img src="../img/pic2.jpg"></a>
							<a href="#" class="thumbnail"> <img src="../img/pic3.jpg"></a>
							<a href="#" class="thumbnail"> <img src="../img/pic1.jpg"></a>
							<a href="#" class="thumbnail"> <img src="../img/pic2.jpg"></a>
							<a href="#" class="thumbnail"> <img src="../img/pic3.jpg"></a>
							<a href="#" class="thumbnail"> <img src="../img/pic1.jpg"></a>
							<a href="#" class="thumbnail"> <img src="../img/pic2.jpg"></a>
							<a href="#" class="thumbnail"> <img src="../img/pic3.jpg"></a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>