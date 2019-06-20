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

<script type="text/javascript">

	$(function () {
		getToday();
		
	});
	
	
	function getToday() {
			
	var date = new Date();
	
	var yyyy = date.getFullYear();
	var mm = date.getMonth()+1;
	var dd = date.getDate();
	
	 if(mm < 10){
	        mm = "0"+mm;
	    }
	  if(dd < 10){
	        dd = "0"+dd;
	    }
	 var now = yyyy + "-" + mm + "-" + dd;
	 console.log(now);
		 $("#today").html(now); 
	}
	
</script>

</head>
<body>
<%@include file="layout/header.jsp"%>
<br>
		<div id="backgroundImage">
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<form id="left_info">
						
						<div id = "now_location">
							<label>현재위치</label>
						</div>
							
						<div id = "tempe">
							<label>온도</label>
						</div>	
						<div id = "hum">
							<label>습도</label>
						</div>	
						<div id = "dust">
							<label>미세먼지</label>
						</div>	
					
					</form>	
				</div>
				
				<div class="col-md-8">
					<form>
						<h1>오늘의 코디</h1>
						<div id= "today"></div>
						
						<div id= "index_cloth_top" class="alert alert-success" role="alert">
							<strong>상의</strong>
						</div>
						
						<div id= "index_cloth_bottom" class="alert alert-success"" role="alert">
							<strong>하의</strong>
						</div>
						
						<div id= "index_cloth_history" class="alert alert-success"" role="alert">
							<strong>최근 입었던 옷 (Top4정도)</strong>
						</div>
					</form>
				
					
					
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>
</html>