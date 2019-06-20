<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>옷 장</title>
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="../css/clotheslist.css" type="text/css">
<script src="../js/bootstrap.js"></script>
<link rel="stylesheet" href="../css/cody.css" type="text/css">
</head>
<body id="boby">
	<%@include file="/layout/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div id="myBtnContainer">
					<button class="btn" onclick="filterSelection('all')">모두보기</button>
					<button class="btn" onclick="filterSelection('nature')">상의</button>
					<button class="btn" onclick="filterSelection('cars')">하의</button>
					
					<a class="btn btn-outline-dark" role="button" style="float: right;" id="delete">옷삭제</a>
					<a href="http://localhost:9090/cody/clothes/cloth_add.do" 
						class="btn btn-outline-dark" role="button" style="float: right;">옷등록</a>
					</div>

				<!-- Portfolio Gallery Grid -->
				<div class="row">
					<div class="column nature">
						<div class="content">
							<img src="../upload/pic1.jpg" alt="Mountains" style="width: 100%" id="img1">
							<h4>Mountains</h4>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
					<div class="column nature">
						<div class="content">
							<img src="../upload/pic2.jpg" alt="Lights" style="width: 100%" id="img2">
							<h4>Lights</h4>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
					<div class="column nature">
						<div class="content">
							<img src="../upload/pic3.jpg" alt="Nature" style="width: 100%" id="img3">
							<h4>Forest</h4>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
					<div class="column nature">
						<div class="content">
							<img src="../upload/pic1.jpg" alt="Nature" style="width: 100%">
							<h4>Forest</h4>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
					<div class="column nature">
						<div class="content">
							<img src="../upload/pic2.jpg" alt="Nature" style="width: 100%">
							<h4>Forest</h4>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
					<div class="column nature">
						<div class="content">
							<img src="../upload/pic3.jpg" alt="Nature" style="width: 100%">
							<h4>Forest</h4>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
					
					


		<!-- <-- 상의~~하의 --> 


					<div class="column cars">
						<div class="content">
							<img src="../upload/dtd.jpg" alt="Car" style="width: 100%">
							<h4>Retro</h4>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
					<div class="column cars">
						<div class="content">
							<img src="../upload/flower.jpg" alt="Car" style="width: 100%">
							<h4>Fast</h4>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
					<div class="column cars">
						<div class="content">
							<img src="../upload/pink.jpg" alt="Car" style="width: 100%">
							<h4>Classic</h4>
							<p>Lorem ipsum dolor..</p>
						</div>
					</div>
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