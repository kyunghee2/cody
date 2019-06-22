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
<title>옷 장</title>
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="../css/clotheslist.css" type="text/css">
<link rel="stylesheet" href="../css/cody.css" type="text/css">
<script src="../js/bootstrap.js"></script>
</head>

<body id="boby">
	<%@include file="/layout/header.jsp"%>
	<!-- 사용자 리스트를 클라이언트에게 보여주기 위하여 출력. -->
${cloth.imgpath}${cloth.imgname}
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div id="myBtnContainer">
					<button class="btn" onclick="filterSelection('all')">모두보기</button>
					<button class="btn" onclick="filterSelection('nature')">상의</button>
					<button class="btn" onclick="filterSelection('cars')">하의</button>


					<a class="btn btn-outline-dark" role="button" id="delete">옷삭제</a>
					<a href="http://localhost:9090/cody/clothes/cloth_add.do" 
					class="btn btn-outline-dark" role="button" id="submitclo">옷등록</a>
				</div>

				<!-- Portfolio Gallery Grid -->
				<div class="row">
					<c:forEach var="cloth" items="${clothes}">
						<c:if test="${cloth.kind==1}">
							<div class="column nature">
								<div class="content">
									<img src="${cloth.imgpath}${cloth.imgname}" class="image"
										alt="Mountains" style="width: 100%" id="img1">
									<h4>Mountains</h4>
									<p>Lorem ipsum dolor..</p>
								</div>
							</div>
						</c:if>
					</c:forEach>

					<!-- <-- 상의~~하의 -->

					<c:forEach var="cloth" items="${clothes}">
						<c:if test="${cloth.kind==2}">
							<div class="column cars">
								<div class="content">
									<img src="${cloth.imgpath}${cloth.imgname}" class="image"
										alt="Mountains" style="width: 100%" id="img1">
									<h4>Retro</h4>
									<p>Lorem ipsum dolor..</p>
								</div>
							</div>
						</c:if>
					</c:forEach>

					<!-- END GRID -->
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>













	<script>
		filterSelection("all")
		function filterSelection(c) {
			var x, i;
			x = document.getElementsByClassName("column");
			if (c == "all")
				c = "";
			for (i = 0; i < x.length; i++) {
				w3RemoveClass(x[i], "show");
				if (x[i].className.indexOf(c) > -1)
					w3AddClass(x[i], "show");
			}
		}

		function w3AddClass(element, name) {
			var i, arr1, arr2;
			arr1 = element.className.split(" ");
			arr2 = name.split(" ");
			for (i = 0; i < arr2.length; i++) {
				if (arr1.indexOf(arr2[i]) == -1) {
					element.className += " " + arr2[i];
				}
			}
		}

		function w3RemoveClass(element, name) {
			var i, arr1, arr2;
			arr1 = element.className.split(" ");
			arr2 = name.split(" ");
			for (i = 0; i < arr2.length; i++) {
				while (arr1.indexOf(arr2[i]) > -1) {
					arr1.splice(arr1.indexOf(arr2[i]), 1);
				}
			}
			element.className = arr1.join(" ");
		}

		// Add active class to the current button (highlight it)
		var btnContainer = document.getElementById("myBtnContainer");
		var btns = btnContainer.getElementsByClassName("btn");
		for (var i = 0; i < btns.length; i++) {
			btns[i].addEventListener("click", function() {
				var current = document.getElementsByClassName("active");
				current[0].className = current[0].className.replace(" active",
						"");
				this.className += " active";
			});
		}

		
		$(document).ready(function() {
			$(".column").click(function() {
				if (!$(this).hasClass("cloth_selected"))
					$(this).addClass("cloth_selected");
				else
					$(this).removeClass("cloth_selected");
			});

			$("#delete").click(function() {
				if (!$(".column").hasClass("cloth_selected")) {
					alert("선택된 항목이 없습니다.");
				} else {
					var c = confirm("정말 삭제 하시겠습니까?");
					if (c == true) {
						if ($(".column").hasClass("cloth_selected"))
							$(".cloth_selected").remove();
					}
				}
			});
		});
	</script>
</body>
</html>