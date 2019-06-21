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

<script type="text/javascript">
	
	var log = console.log;
	
	$(function () {
		$("#cloth_img_upload").on("change", handleImgFileSelect);
		
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
	
	   /* function uploadFile(){
          var form = $("#file_form")[0];
          var formData = new FormData(form);
          formData.append("fileObj", $("#cloth_img_upload")[0].files[0]);
          //console.log(formData)

          $.ajax({
              url: "//70.12.115.75/cody/upload/",
                      processData: false,
                      contentType: false,
                      data: formData,
                      type: 'POST',
                      success: function(result){
                          alert("업로드 성공!!");
                      }
              });
      }  */


	
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
						
			<form id="file_form" method="post" enctype="multipart/form-data">
				<figure class="figure">
				 	 <img id="img"  class="rounded-lg" width="300" height="300">
				  	<figcaption class="figure-caption text-right">옷 이미지 입니다.</figcaption>
				</figure>
			
  			<div class="form-group">
			    <label for="cloth_uploadimg">이미지 등록</label>
			    <input type="file" class="form-control-file" id="cloth_img_upload" name="cloth_img_upload">
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
							<button id="add_cloth" type="submit" class="btn btn-primary">옷 등록하기</button>
						</div>
			</div>
			
			</form>
			</div>
		<div class="col-md-2"></div>
	</div>
</div>			

</body>
</html>