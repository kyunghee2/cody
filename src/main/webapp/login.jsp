<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Login</title>
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="./css/login2.css" type="text/css">
<style>
	.msg {
		color:red;
	}
</style>
</head>
<body>
<form class="form-signin" action="login.do" method="POST">
      <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal">Cody Login</h1>
        <p></p>
      </div>

      <div class="form-label-group">
        <input type="text" id="userid" name="userid" class="form-control" required="required" autofocus="">
        <label for="inputEmail">ID</label>
      </div>

      <div class="form-label-group">
        <input type="password" id="userpwd" name="userpwd" class="form-control" required="required">
        <label for="inputPassword">PW</label>
      </div>
	  <div>
	  	<span class="msg">${msg}</span>
	  </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      
    </form>
</body>
</html>