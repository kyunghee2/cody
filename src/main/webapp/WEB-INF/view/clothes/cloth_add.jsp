<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>옷 등록</title>
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
<script src="../js/bootstrap.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">
	
	$(function () {
		$("#cloth_uploadimg").on("change", handleImgFileSelect);
	});
	
	function handleImgFileSelect(e) {
		var files = e.target.files;
		var fileArr = Array.prototype.slice.call(files);
		
		fileArr.forEach(function (f) {
			if(!f.type.match("image.*")){
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}
			
			sel_file = f;
			
			var reader = new FileReader();
			reader.onload = function (e) {
				$("#img").attr("src", e.target.result);				
			}
			reader.readAsDataURL(f);
		});
		
	}

</script>

</head>
<body>
<%@include file="/layout/header.jsp" %>
<br>

<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
			
			<h3>옷 등록</h3>
			<br>
						
			<form method="post" enctype="multipart/form-data">
				<figure class="figure">
				 	 <img id="img"  class="figure-img img-fluid rounded">
				  	<figcaption class="figure-caption text-right">옷 이미지 입니다.</figcaption>
				</figure>
			
  			<div class="form-group">
			    <label for="cloth_uploadimg">이미지 등록</label>
			<!--     <button type="submit" class="btn btn-outline-primary">이미지등록</button><br> -->
			    <input type="file" class="form-control-file" id="cloth_uploadimg">
			 </div>	
			</form>
			
			<form>
			
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">계절</label>
				
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="season" value="봄">
						<label class="form-check-label" for="inlineCheckbox1">봄</label>
					</div>	
					
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" id="inlineCheckbox2" name="season" value="여름">
						<label class="form-check-label" for="inlineCheckbox2">여름</label>
					</div>
					
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" id="inlineCheckbox3" name="season" value="가을">
						<label class="form-check-label" for="inlineCheckbox3">가을</label>
					</div>
					
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" id="inlineCheckbox4" name="season" value="겨울">
						<label class="form-check-label" for="inlineCheckbox4">겨울</label>
					</div>
				</div>
			</div>
				
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">상,하의</label>
				
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="cloth" id="inlineRadio1" value="top">
					  <label class="form-check-label" for="inlineRadio1">상의</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="cloth" id="inlineRadio2" value="top">
					  <label class="form-check-label" for="inlineRadio2">하의</label>
					</div>
				</div>	
			</div>
	
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">색상</label>
				
				<div class="col-sm-10">
					<input type="text" class="form-control" name="color" id="color" placeholder="ex) 흰색">
				</div>	
			</div>
			
			<div class="form-group row">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary">옷 등록하기</button>
						</div>
			</div>
			
			
			</form>
			</div>
		<div class="col-md-2"></div>
	</div>
</div>			

</body>
</html>