<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<% response.setStatus(200); %>
<h3>문제발생</h3>
<p>${exception}
<br>
<%=exception %>
</p>
</body>
</html>