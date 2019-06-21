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
<link rel="stylesheet" type="text/css" href="./plugin/slick/slick-theme.css">
<link rel="stylesheet" href="./css/index.css" type="text/css">
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
							<label>현재위치</label>&nbsp;<span id="position" class="weather_val">강남구</span>
						</div>

						<div id="tempe">
							<label>온도</label>&nbsp;<span id="tempNow" class="weather_val"></span>
						</div>
						<div id="hum">
							<label>습도</label>&nbsp;<span id="humidity" class="weather_val"></span>
						</div>
						<div id="dust">
							<label>미세먼지</label>&nbsp;<span id="pm10Grade" class="weather_val"></span>
						</div>

					</form>
				</div>

				<div class="col-md-8">
					<form>
						<h1>오늘의 코디</h1>
						<div id="today"></div>


						<div id="msg_info">
						 <label>메세지가 들어갈 부분입니다.</label>
						</div>
						
						<div id="history_button">
							<button id="add_history" type="submit" class="btn btn-secondary">히스토리 추가</button>
						</div>
						
						
						<div id="index_cloth_top" class="alert alert-success subtitle" role="alert">
							<strong>상의</strong>
						</div>
						<!-- 상의list <start> -->
						<div id="slide1" class="autoplay "
							data-slick='{"slidesToShow": 4, "slidesToScroll": 4}'>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
						</div>

						<!-- 상의list <end> -->

						<div id="index_cloth_bottom" class="alert alert-success subtitle"
							" role="alert">
							<strong>하의</strong>
						</div>
						<!-- 하의list <start> -->
						<div id="slide2" class="autoplay "
							data-slick='{"slidesToShow": 4, "slidesToScroll": 4}'>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
						</div>

						<!-- 하의list <end> -->
						<div id="index_cloth_history" class="alert alert-success subtitle"
							" role="alert">
							<strong>최근 입었던 옷</strong>
						</div>
						<!-- list <start> -->
						<div id="slide3" class="autoplay "
							data-slick='{"slidesToShow": 4, "slidesToScroll": 4}'>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
							<div>
								<img src="./upload/pic1.jpg">
							</div>
						</div>

						<!-- list <end> -->
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
	var log = console.log;
		$(function() {
			getToday();
			getLocation();
			
			$('.autoplay').slick({
				slidesToShow : 3,
				slidesToScroll : 1,
				autoplay : false,
				autoplaySpeed : 2000,
			});

		});

		function getLocation() {
		  if (navigator.geolocation) {
		    navigator.geolocation.getCurrentPosition(geoPosition,showError);
		  } else { 
		    log("브라우저에서 위치정보를 가져올 수 없습니다.");
		  }
		}
		function showError(error)
		  {
		  switch(error.code) 
		    {
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
		  log(position);
		  
		  getWeather(lat,lon);
		}
		function getWeather(p_lat,p_lon){
			
			$.ajax({
				url:'./weather.do?lat='+p_lat+'&lon='+p_lon,
				type:"GET",
				//data:$('form').serializeArray(),
				success:function(data){		
					var json = $.parseJSON(data);
					log(json);
					weaderRender(json);
				},
				error:function(e){				
					log(e);
				}
			});
		}
		function weaderRender(json){
			var pm10Grade_txt="좋음";
			if(json.pm10Grade!=undefined){
				var pm10Grade = json.pm10Grade;
				switch(pm10Grade){
					case "1": pm10Grade_txt = "좋음"; break;
					case "2": pm10Grade_txt = "보통"; break;
					case "3": pm10Grade_txt = "나쁨"; break;
					case "4": pm10Grade_txt = "매우나쁨"; break;
					default: pm10Grade_txt = ""; break;
				}
				$("#pm10Grade").html(pm10Grade_txt);
			}
			if(json.tempNow != undefined)		
				$("#tempNow").html(json.tempNow);
			if(json.humidity != undefined)
				$("#humidity").html(json.humidity);
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