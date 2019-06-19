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
</head>
<body>
<%@include file="/layout/header.jsp" %>
<br>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">

				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active" id="home-tab"
						data-toggle="tab" href="#home" role="tab" aria-controls="home"
						aria-selected="true">Home</a></li>
					<li class="nav-item"><a class="nav-link" id="profile-tab"
						data-toggle="tab" href="#profile" role="tab"
						aria-controls="profile" aria-selected="false">Profile</a></li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">

						<div class="col-xs-6 col-md-3" class="pull-right" class="form-inline">
							<a href="#" class="thumbnail"> <img src="../img/clouds-3488632_1920.jpg"  width="100%" height="150"></a>
							<a href="#" class="thumbnail"> <img src="../img/cold-front-63037_1920.jpg" width="100%" height="150"></a>
							<a href="#" class="thumbnail"> <img src="../img/rain-2422642_1920.jpg" alt="..."></a>
							<a href="#" class="thumbnail"> <img src="..." alt="..."></a>
						</div>
						
					</div>
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						222222222222222222222222
						<div class="col-xs-6 col-md-3">
							<a href="#" class="thumbnail"> <img src="..." alt="..."></a>
							<a href="#" class="thumbnail"> <img src="..." alt="..."></a>
							<a href="#" class="thumbnail"> <img src="..." alt="..."></a>
							<a href="#" class="thumbnail"> <img src="..." alt="..."></a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>