<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>옷 장</title>
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">
<script src="./js/bootstrap.js"></script>
</head>
<body>
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

						<div class="col-xs-6 col-md-3">
							<a href="#" class="thumbnail"> <img src="..." alt="..."></a>
							<a href="#" class="thumbnail"> <img src="..." alt="..."></a>
							<a href="#" class="thumbnail"> <img src="..." alt="..."></a>
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