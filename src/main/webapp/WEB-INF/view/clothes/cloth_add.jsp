<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>옷등록</title>
</head>
<body>
<h3>옷 등록</h3>
<form action=""> 
<h4>계절</h4>
<input type="checkbox"  name="season" value="봄">봄
<input type="checkbox"  name="season" value="여름">여름
<input type="checkbox"  name="season" value="가을">가을
<input type="checkbox"  name="season" value="겨울">겨울
</form>

<form action="">
<h4>상,하의</h4>
<input type="radio"  name="cloth" value="top">상의
<input type="radio"  name="cloth" value="bottom">하의
</form>


</body>
</html>