<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>홈</title>
<link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css">
<script src="./js/bootstrap.js"></script>
<link rel="stylesheet" href="./css/cody.css" type="text/css">
<link rel="stylesheet" type="text/css" href="./plugin/slick/slick.css">
<link rel="stylesheet" type="text/css"
	href="./plugin/slick/slick-theme.css">
<link rel="stylesheet" href="./css/index.css" type="text/css">
</head>
<body>
	<%@include file="/layout/header.jsp"%>
	<br>
	<div id="backgroundImage">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>오늘의 코디</h1>
					<div id="today"></div>
					<br>
				</div>
				<div class="col-md-2">
					<div class="left-subtitle">
						<label>현재위치</label>&nbsp;<span id="positionName"
							class="weather_val">강남구</span>
					</div>

					<div class="left-subtitle">
						<label>온도</label>&nbsp;<span id="tempNow" class="weather_val"></span>
					</div>
					<div class="left-subtitle">
						<label>습도</label>&nbsp;<span id="humidity" class="weather_val"></span>
					</div>
					<div class="left-subtitle">
						<label>미세먼지</label>&nbsp;<span id="pm10Grade" class="weather_val"></span>
					</div>

					<div id="eicon_area"></div>
				</div>

				<div class="col-md-10">

					<div class="input-group ">

						<div class="alert alert-success" id="today_msg" >
							<!-- <strong>Success! You should read this message </strong> -->
							today...
						</div>
						&nbsp;
						<button type="button" class="btn btn-info" id="history_add">히스토리
							추가</button>

					</div><br>

					<!-- 상의list <start> -->
					<div class="panel panel-default">
						<div class="panel-heading">상의</div>
						<div class="panel-body">
							<div class="row text-center text-lg-left">

								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/pWkk7iiCoDM/400x300" alt="">
									</a>
								</div>
								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/aob0ukAYfuI/400x300" alt="">
									</a>
								</div>
								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/EUfxH-pze7s/400x300" alt="">
									</a>
								</div>
								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/M185_qYH8vg/400x300" alt="">
									</a>
								</div>
							</div>

						</div>
					</div>


					<!-- 상의list <end> -->

					<!-- <h4>하의</h4> -->
					<!-- 하의list <start> -->
					<div class="panel panel-default">
						<div class="panel-heading">하의</div>
						<div class="panel-body">
							<div class="row text-center text-lg-left">

								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/pWkk7iiCoDM/400x300" alt="">
									</a>
								</div>
								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/aob0ukAYfuI/400x300" alt="">
									</a>
								</div>
								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/EUfxH-pze7s/400x300" alt="">
									</a>
								</div>
								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/M185_qYH8vg/400x300" alt="">
									</a>
								</div>
							</div>


						</div>
					</div>

					<!-- 하의list <end> -->

					<!-- list <start> -->
					<div class="panel panel-default">
						<div class="panel-heading">최근 입었던 옷</div>
						<div class="panel-body">
							<div class="row text-center text-lg-left">

								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/pWkk7iiCoDM/400x300" alt="">
									</a>
								</div>
								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/aob0ukAYfuI/400x300" alt="">
									</a>
								</div>
								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/EUfxH-pze7s/400x300" alt="">
									</a>
								</div>
								<div class="col-lg-3 col-md-4 col-6">
									<a href="#" class="d-block mb-4 h-100"> <img
										class="img-fluid img-thumbnail"
										src="https://source.unsplash.com/M185_qYH8vg/400x300" alt="">
									</a>
								</div>
								<!-- list <end> -->
							</div>
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>
	<!-- <script src="//code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script> -->
	<script src="./plugin/slick/slick.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
		var log = console.log;
		$(function() {
			getToday();
			getLocation();

		});

		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation
						.getCurrentPosition(geoPosition, showError);
			} else {
				log("브라우저에서 위치정보를 가져올 수 없습니다.");
			}
		}
		function showError(error) {
			switch (error.code) {
			case error.PERMISSION_DENIED:
				log("User denied the request for Geolocation.");
				break;
			case error.POSITION_UNAVAILABLE:
				log("Location information is unavailable.");
				break;
			case error.TIMEOUT:
				log("The request to get user location timed out.");
				break;
			case error.UNKNOWN_ERROR:
				log("An unknown error occurred.");
				break;
			}
		}

		function geoPosition(position) {
			var lat = position.coords.latitude;
			var lon = position.coords.longitude
			//log(position);

			getWeather(lat, lon);
		}
		function getWeather(p_lat, p_lon) {

			$.ajax({
				url : './weather.do?lat=' + p_lat + '&lon=' + p_lon,
				type : "GET",
				//data:$('form').serializeArray(),
				success : function(data) {
					var json = $.parseJSON(data);
					log(json);
					weaderRender(json);
				},
				error : function(e) {
					log(e);
				}
			});
		}
		function weaderRender(json) {
			$("#eicon_area").html("");
			var pm10Grade_txt = "좋음";
			
			if (json.pm10Grade != undefined) {
				var pm10Grade = json.pm10Grade;//미세먼지
				var pm10Grade_img = ""; 
				switch (pm10Grade) {
				case "1":
					pm10Grade_txt = "좋음";
					pm10Grade_img = "./img/emoticon/emoji9.jpg";
					break;
				case "2":
					pm10Grade_txt = "보통";
					pm10Grade_img = "./img/emoticon/emoji10.jpg";
					break;
				case "3":
					pm10Grade_txt = "나쁨";
					pm10Grade_img = "./img/emoticon/emoji11.jpg";
					break;
				case "4":
					pm10Grade_txt = "매우나쁨";
					pm10Grade_img = "./img/emoticon/emoji12.jpg";
					break;
				default:
					pm10Grade_txt = "";
					break;
				}
				$("#pm10Grade").html(pm10Grade_txt);
				if(pm10Grade_img != ""){
					var img = $('<img />').attr("src",pm10Grade_img);
					$("#eicon_area").append(img);
				}
				
			}
			if (json.tempNow != undefined){
				var tempNow = json.tempNow;
				$("#tempNow").html(json.tempNow+"℃"); //현재기온
			}				
			if (json.humidity != undefined)
				$("#humidity").html(json.humidity); //습도
			
			
			if(json.rainPercent != undefined){
				var rainPercent = json.rainPercent;//강수 확률 30%이상이면 우산
				log(rainPercent);				
				if(Number(json.rainPercent) >= 30){
					var img = $('<img />').attr("src","./img/emoticon/emoji23.jpg");
					$("#eicon_area").appendTo(img);
					$("#today_msg").html("비올 확율이 있네요. 우산 챙기세요").show();
				}
			}
			
		}
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
			//console.log(now);
			$("#today").html(now);
		}
	</script>
</body>
</html>