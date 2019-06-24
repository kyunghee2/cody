<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>가입완료</title>
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
</head>
<body>
<%@include file="/layout/header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			<br>
			<h1>가입완료</h1>
			<button type="button" class="btn" onclick="location.href='${pageContext.request.contextPath}/index.do';">로그인 화면으로 이동</button>
			
			</div>
		</div>
	</div>
</body>
</html>