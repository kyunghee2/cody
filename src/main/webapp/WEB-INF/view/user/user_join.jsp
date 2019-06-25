<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>회원가입</title>
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
</head>
<body>
	<%@include file="/layout/header.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8" style= "margin-top: 150px">

				<h3>회원가입</h3>
				<br>
				<form action="./add.do" method="POST" name="form1">
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">ID *</label>
						<div class="col-sm-10">
							<div class="input-group mb-3">
								<input type="text" class="form-control"
									placeholder="ID"
									aria-label="ID"
									aria-describedby="ID" id="userid" name="userid" required>
								<div class="input-group-append">
									<button class="btn btn-outline-secondary" type="button" id="btnIdCheck">중복체크</button>
								</div>
							</div>
							<div class="help-block with-errors"></div>
						</div>
					</div>

					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">이름 *</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="이름" required>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호 *</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="userpwd"
								name="userpwd" placeholder="Password" required>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">이메일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="이메일">
						</div>
					</div>
					<fieldset class="form-group">
						<div class="row">
							<legend class="col-form-label col-sm-2 pt-0">성별</legend>
							<div class="col-sm-10">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gender"
										id="gender1" value="0" checked> <label
										class="form-check-label" for="gridRadios1"> 선택안함 </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gender"
										id="gender2" value="1"> <label
										class="form-check-label" for="gridRadios2"> 남 </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gender"
										id="gender3" value="2"> <label
										class="form-check-label" for="gridRadios3"> 여 </label>
								</div>
							</div>
						</div>
					</fieldset>

					<div class="form-group row">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary" onclick="return join();">회원가입</button>
						</div>
					</div>
				</form>


			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
<input type="hidden" id="idCheck" name="idCheck" value=""> 
<script>
$(function(){
	
	$("#userid").change(function(e){
		e.preventDefault();
		$("#idCheck").val("");
	});
	$("#btnIdCheck").click(function(e){
		e.preventDefault();
		var id = $("#userid").val();
		
		if(id != ""){
			$.ajax({
				url : "../api/userIdCheck.do?uid="+id,
				type : "GET",						
				success : function(data) {
					if(data != ""){
						$(".with-errors").html("ID가 중복됩니다.");
						$("#idCheck").val(false);
					}else{
						$(".with-errors").html("사용가능한 ID입니다.");
						$("#idCheck").val(true);
					}
				},
				error : function(e) {
					console.log(e);
				}
			}); 
		}
				
	});
});
function join(){
	var check = $("#idCheck").val();
	//console.log(check);
	$(".with-errors").html("");
	if(check==""){
		$(".with-errors").html("ID중복체크 해주세요");
		return false;
	}
	if(check=="false"){
		$(".with-errors").html("ID가 중복됩니다.");
		return false;
	}else{
		
		return true;
		
	}
	
	
}

</script>

</body>
</html>