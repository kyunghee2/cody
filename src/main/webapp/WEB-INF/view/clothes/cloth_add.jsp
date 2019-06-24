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
<link rel="stylesheet" href="../css/cloth_add.css" type="text/css">

<script src="../js/bootstrap.js"></script>

<script type="text/javascript">
	
	var log = console.log;
	
	$(function() {
		$("#cloth_img_upload").on("change", addfiles);
		
		$("#add_cloth_img").click(function() {
			log("파일업로드");
			if(!("file")){
				
			}else{
				confirm("옷을 등록하시겠습니까?");
				
				log("파일업로드완료");
			}
		
	
		});
	});
	/*파일추가*/
	function addfiles(e) {
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
				$("#input_img").attr("src", e.target.result);				
			}
			reader.readAsDataURL(f);
		});
	}
	
	/*데이터 전송*/
/* 
	    function uploadFile(){
          var form = $("#file_form")[0];
          var formData = new FormData(form);
          formData.append("fileObj", $("#cloth_img_upload")[0].files[0]);
          	log(formData);
          $.ajax({
              type: 'POST',
              url: "/clothes/cloth_add.do",
              data: formData,
              processData: false,
              contentType: false,
              success: function(data){
            	  if(data.result){
					console.log('success');
					alert("이미지 업로드 성공!");
            	  }else{
            		  alert(data.result);
            	  }
              },
             error : function(error){
            	 alert(error,status);
             }
              }); 
      }   */

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
						
			<form action id="file_form" method="post" enctype="multipart/form-data">
				<div id="out_imgbox">
				<div id="in_imgbox">
				
				 	 <img id="input_img">
				  	
			
				</div>
				</div>
				
	  			<div class="form-group">
				    <label for="cloth_img_upload">이미지 등록</label>
				    <input type="file" class="form-control-file" id="cloth_img_upload" name="file">
				 </div>	
			
			
			
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">계절</label>
				
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" id="spring" name="season" value="1">
						<label class="form-check-label" for="spring">봄</label>
					</div>	
					
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" id="summer" name="season" value="2">
						<label class="form-check-label" for="summer">여름</label>
					</div>
					
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" id="fall" name="season" value="3">
						<label class="form-check-label" for="fall">가을</label>
					</div>
					
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" id="winter" name="season" value="4">
						<label class="form-check-label" for="winter">겨울</label>
					</div>
				</div>
			</div>
				
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">상,하의</label>
				
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="kind" id="top" value="1">
					  <label class="form-check-label" for="cloth_top">상의</label>
					</div>
					
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="kind" id="bottom" value="2">
					  <label class="form-check-label" for="cloth_bottom">하의</label>
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
							<button id="add_cloth_img" type="submit" class="btn btn-primary">옷 등록하기</button>
							<input type="button" id="go_to_myCloth_list" onclick="location.href='${pageContext.request.contextPath}/clothes/myCloth_list.do'" value="내 옷장가기"></input>
						</div>
			</div>
			
			</form>
			</div>
		<div class="col-md-2"></div>
	</div>
</div>			

</body>
</html>
