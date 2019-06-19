<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<nav class="navbar navbar-dark bg-dark">
	<a class="navbar-brand" href="#"><b>Today's Cody</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarsExample01" aria-controls="navbarsExample01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarsExample01">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="./">홈
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/clothes/cloth_add.do">옷등록</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/clothes/myCloth_list.do">옷장</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout.do">로그아웃</a></li>
						
		</ul>
		
	</div>
</nav>