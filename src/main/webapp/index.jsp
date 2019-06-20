<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>홈</title>
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">
<script src="./js/bootstrap.js"></script>
<link rel="stylesheet" href="./css/cody.css" type="text/css">
<link rel="stylesheet" type="text/css" href="./plugin/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="./plugin/slick/slick-theme.css">
<style type="text/css">

/*     html, body {
      margin: 0;
      padding: 0;
    }

    * {
      box-sizing: border-box;
    } */
.slider {
	width: 50%;
	margin: 100px auto;
}

.slick-slide {
	margin: 0px 20px;
}

.slick-slide img {
	width: 100%;
}

.slick-prev:before, .slick-next:before {
	color: black;
}

.slick-slide {
	transition: all ease-in-out .3s;
	opacity: .2;
}

.slick-active {
	opacity: .5;
}

.slick-current {
	opacity: 1;
}
</style>


</head>
<body>
	<%@include file="layout/header.jsp"%>
	<br>
	<div id="backgroundImage">
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<form id="left_info">

						<div id="now_location">
							<label>현재위치</label>
						</div>

						<div id="tempe">
							<label>온도</label>
						</div>
						<div id="hum">
							<label>습도</label>
						</div>
						<div id="dust">
							<label>미세먼지</label>
						</div>

					</form>
				</div>

				<div class="col-md-8">
					<form>
						<h1>오늘의 코디</h1>
						<div id="today"></div>

						<div id="index_cloth_top" class="alert alert-success" role="alert">
							<strong>상의</strong>
						</div>
						<!-- 상의list <start> -->
						<div id="slide1" class="autoplay "
							data-slick='{"slidesToShow": 4, "slidesToScroll": 4}'>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<h3>2</h3>
							</div>
							<div>
								<h3>3</h3>
							</div>
							<div>
								<h3>4</h3>
							</div>
							<div>
								<h3>5</h3>
							</div>
							<div>
								<h3>6</h3>
							</div>
						</div>

						<!-- 상의list <end> -->

						<div id="index_cloth_bottom" class="alert alert-success"
							" role="alert">
							<strong>하의</strong>
						</div>

						<div id="index_cloth_history" class="alert alert-success"
							" role="alert">
							<strong>최근 입었던 옷 (Top4정도)</strong>
						</div>
					</form>



				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
	<!-- <script src="//code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script> -->
	<script src="./plugin/slick/slick.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
		$(function() {
			getToday();

			$('.autoplay').slick({
				slidesToShow : 3,
				slidesToScroll : 1,
				autoplay : true,
				autoplaySpeed : 2000,
			});

		});

		function getToday() {

			var date = new Date();

			var yyyy = date.getFullYear();
			var mm = date.getMonth() + 1;
			var dd = date.getDate();

			if (mm < 10) {
				mm = "0" + mm;
			}
			if (dd < 10) {
				dd = "0" + dd;
			}
			var now = yyyy + "-" + mm + "-" + dd;
			console.log(now);
			$("#today").html(now);
		}
	</script>
</body>
</html>