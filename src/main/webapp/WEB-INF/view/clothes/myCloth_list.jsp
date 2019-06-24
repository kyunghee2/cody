<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
<link
	href="https://fonts.googleapis.com/css?family=Titillium+Web&display=swap"
	rel="stylesheet">

<script src="../js/bootstrap.js"></script>
</head>

<body id="boby">
	<%@include file="/layout/header.jsp"%>
	<!-- 사용자 리스트를 클라이언트에게 보여주기 위하여 출력. -->
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div id="myBtnContainer">
					<button class="btn" onclick="filterSelection('all')">모두보기</button>
					<button class="btn" onclick="filterSelection('nature')">상의</button>
					<button class="btn" onclick="filterSelection('cars')">하의</button>
	
	
						 <a class="btn btn-outline-dark" role="button" id="delete"
						style="float: right;">옷삭제</a> 
						<a href="${pageContext.request.contextPath}/clothes/cloth_add.do"
						class="btn btn-outline-dark" role=z` "button" id="submitclo"
						style="float: right;">옷등록</a>
				</div>


				<!-- Portfolio Gallery Grid -->
				<div class="row">
					<c:forEach var="cloth" items="${clothes}">
						<c:if test="${cloth.kind eq '1'}">
							<div class="column nature" key="${cloth.clothid}">
								<div class="content">
									<img src="..${cloth.imgpath}${cloth.imgname}" class="image"
										alt="Mountains" style="width: 100%" id="img1">
									<c:forTokens items="${cloth.season}" delims="," var="season">
										<c:if test="${season eq '1'}">
											봄
										</c:if>
										<c:if test="${season eq '2'}">
											여름
										</c:if>
										<c:if test="${season eq '3'}">
											가을
										</c:if>
										<c:if test="${season eq '4'}">
											겨울
										</c:if>
									</c:forTokens>

									<h4 class="tid fontA">${cloth.color}</h4>
								</div>

							</div>

						</c:if>

						<!-- <-- 상의~~하의 -->

						<c:if test="${cloth.kind eq '2'}">
							<div class="column cars" key="${cloth.clothid}">
								<div class="content">
									<img src="..${cloth.imgpath}${cloth.imgname}" class="image"
										alt="Mountains" style="width: 100%" id="img1">
									<c:forTokens items="${cloth.season}" delims="," var="season">
										<c:if test="${season eq '1'}">
											봄 
										</c:if>
										<c:if test="${season eq '2'}">
											여름
										</c:if>
										<c:if test="${season eq '3'}">
											가을
										</c:if>
										<c:if test="${season eq '4'}">
											겨울
										</c:if>
									</c:forTokens>
								</div>
							</div>
						</c:if>
						</form>
					</c:forEach>
					
					<!-- END GRID -->
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
<form id="form1" action="">
<input type="hidden" id="clothidlist" name="clothidlist">
</form>

	<script>
		filterSelection("all")
		var list = new Array();
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
			
			
			$("#delete").click(function(e) {
				e.preventDefault();
				if (!$(".column").hasClass("cloth_selected")) {
					alert("선택된 항목이 없습니다.");
					return false;
				}

				var c = confirm("삭제 하시겠습니까?");
				if (c) {
					var arrSel = [];
					$.each( $(".column"), function( key, value ) {
						if ($(this).hasClass("cloth_selected")){
							var key = $(this).attr("key");
							if(key != ""){
							  arrSel.push(key);
							}
						}
					  
					});
					console.log(arrSel);
					$("#clothidlist").val(arrSel.join(","));
								
					 if(arrSel.length > 0){
						$.ajax({
							url : "./clothesremove.do",
							type : "POST",
							data:$('#form1').serializeArray(),				
							success : function(data) {
								if(data.result !=undefined || data.result==1){
									alert("삭제 되었습니다.");
									location.reload();
								}else{
									alert("삭제 실패.");
								}
							},
							error : function(e) {
								log(e);
							}
						}); 
					} 
					
				}
				
				
			});
									
		});
	</script>
</body>
</html>
