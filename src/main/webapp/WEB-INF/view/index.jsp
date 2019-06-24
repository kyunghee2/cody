<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
				<div class="col-md-12 main-title">
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
						<label>온도</label>&nbsp;<span id="s_tempNow" class="weather_val"></span>
					</div>
					<div class="left-subtitle">
						<label>습도</label>&nbsp;<span id="s_humidity" class="weather_val"></span>
					</div>
					<div class="left-subtitle">
						<label>미세먼지</label>&nbsp;<span id="s_pm10Grade" class="weather_val"></span>
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
							<div class="row text-center text-lg-left" id="cloth_top_list">
								<c:forEach var="cloth" items="${list_top}">									
									<div class="col-lg-3 col-md-4 col-6 ">
										<a href="#" class="d-block mb-4 h-100"> <img key="${cloth.clothid}"
											class="img-fluid img-thumbnail cloth_top" 
											src="${cloth.imgpath}${cloth.imgname}" alt="">
										</a>
									</div>									
								</c:forEach>
								<c:set var="other" value="${4-fn:length(list_top)}"/>

								<c:forEach var = "i" begin = "1" end = "${other}">
						            <div class="col-lg-3 col-md-4 col-6 ">
										<a href="#" class="d-block mb-4 h-100"> <img key=""
											class="img-fluid img-thumbnail cloth_top"
											src="./img/noimage.gif" alt="">
										</a>
									</div>	
						        </c:forEach>
								
							</div>

						</div>
					</div>


					<!-- 상의list <end> -->

					<!-- <h4>하의</h4> -->
					<!-- 하의list <start> -->
					<div class="panel panel-default">
						<div class="panel-heading">하의</div>
						<div class="panel-body">
							<div class="row text-center text-lg-left " id="cloth_bottom_list">
								
								<c:forEach var="cloth" items="${list_bottom}">									
									<div class="col-lg-3 col-md-4 col-6 ">
										<a href="#" class="d-block mb-4 h-100"> <img key="${cloth.clothid}"
											class="img-fluid img-thumbnail cloth_bottom"
											src="${cloth.imgpath}${cloth.imgname}" alt="">
										</a>
									</div>									
								</c:forEach>
								<c:set var= "other2" value="${4-fn:length(list_bottom)}"/>

								<c:forEach var = "i" begin = "1" end = "${other2}">
						            <div class="col-lg-3 col-md-4 col-6 ">
										<a href="#" class="d-block mb-4 h-100"> <img key=""
											class="img-fluid img-thumbnail cloth_bottom"
											src="./img/noimage.gif" alt="">
										</a>
									</div>	
						        </c:forEach>
						        
							</div>


						</div>
					</div>

					<!-- 하의list <end> -->

					<!-- list <start> -->
					<div class="panel panel-default">
						<div class="panel-heading">최근 입었던 옷</div>
						<div class="panel-body">
							<div class="row text-center text-lg-left">

								<c:forEach var="cloth" items="${list_lately}">									
									<div class="col-lg-3 col-md-4 col-6 ">
										<a href="#" class="d-block mb-4 h-100"> <img
											class="img-fluid img-thumbnail cloth_lately"
											src="${cloth.imgpath}${cloth.imgname}" alt="">
										</a>
									</div>									
								</c:forEach>
								<c:set var= "other2" value="${4-fn:length(list_lately)}"/>

								<c:forEach var = "i" begin = "1" end = "${other2}">
						            <div class="col-lg-3 col-md-4 col-6 ">
										<a href="#" class="d-block mb-4 h-100"> <img
											class="img-fluid img-thumbnail cloth_lately"
											src="./img/noimage.gif" alt="">
										</a>
									</div>	
						        </c:forEach>
						        
								<!-- list <end> -->
							</div>
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>
	<form id="form1" action="">
	<input type="hidden" id="clothidlist" name="clothidlist">
	<input type="hidden" id="temp" name="temp">
	<input type="hidden" id="humidity" name="humidity">
	<input type="hidden" id="dust" name="dust">
	<input type="hidden" id="userid" name="userid" value="${userid}">
	</form>
	<script src="./plugin/slick/slick.min.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
		var log = console.log;
		$(function() {
			getToday();
			getLocation();

			$(".cloth_top,.cloth_bottom").click(function() {
				if (!$(this).hasClass("cloth_selected"))
					$(this).addClass("cloth_selected");
				else
					$(this).removeClass("cloth_selected");
			});
			$("#history_add").click(function(e) {
				e.preventDefault();
				if (!$(".cloth_top, .cloth_bottom").hasClass("cloth_selected")) {
					alert("선택된 항목이 없습니다.");
					return false;
				}
				var arrSel = [];
				$.each( $(".cloth_top"), function( key, value ) {
				  var key = $(this).attr("key");
				  if(key != ""){
					  arrSel.push(key);
				  }
				});
				$("#clothidlist").val(arrSel.join(","));
				
				//console.log($('#form1').serializeArray());
				 $.ajax({
					url : "./clothes/clothhistoryadd.do",
					type : "POST",
					data:$('#form1').serializeArray(),				
					success : function(data) {
						if(data.result !=undefined || data.result=="1"){
							alert("저장되었습니다.");
						}else{
							alert("저장실패.");
						}
					},
					error : function(e) {
						log(e);
					}
				}); 
				
				
			});
		});
		
		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(geoPosition, showError);
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
				url : './api/weather.do?lat=' + p_lat + '&lon=' + p_lon,
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
			var ranFlag = false;
			
			//console.log("json.weatherID:"+json.weatherID);
			if (json.weatherID != undefined) {
				var bimg = "";
				var weatherID = json.weatherID;
				//console.log("=====================");
				//console.log(weatherID.substring(0,1));
				var t = weatherID.substring(0,1);
				
				if(t==2 || t==3 || t==5|| t==6){
					if(t==2 || t==3 || t==5) {
						bimg = "./img/weather_2.jpg";
						ranFlag = true;						
					}
					else if(t == 6) bimg = "./img/weather_6.jpg";
					
					$("#backgroundImage").after().css({
						'background-image':  'url("'+bimg+'")',
						'top':'0',
						'left':'0',
						'position': 'absolute',
						'filter':'alpha(opacity=40)',
						'opacity': '0.4!important',
						'z-index': '-1',
						'content': '',
						'width': '100%',
						'height': '200%',
						'background-size': 'cover'
					});
				}
				
				
			}
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
				$("#s_pm10Grade").html(pm10Grade_txt);
				$("#dust").val(pm10Grade);
				if(pm10Grade_img != ""){
					var img = $('<img />').attr("src",pm10Grade_img);
					$("#eicon_area").append(img);
				}				
			}
			if (json.tempNow != undefined){
				var tempNow = json.tempNow;
				$("#s_tempNow").html(json.tempNow+"℃"); //현재기온
				$("#temp").val(json.tempNow);
			}				
			if (json.humidity != undefined){
				$("#s_humidity").html(json.humidity); //습도
				$("#humidity").val(json.humidity);
				if(Number(json.humidity) >= 90){					
					ranFlag = true;	
				}
			}				
			if(ranFlag){
				var img = $('<img />').attr("src","./img/emoticon/emoji23.jpg");
				$("#eicon_area").appendTo(img);
				$("#today_msg").html("우산 챙기세요~").show();
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