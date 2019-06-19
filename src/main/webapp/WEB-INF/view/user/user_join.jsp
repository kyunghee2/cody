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

	<div class="container">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-6">

				<h3>회원가입</h3>
				<br>
				<form>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userid" name="userid"
								placeholder="User ID">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputEmail3" class="col-sm-2 col-form-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="이름">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="userpwd"
								placeholder="Password">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword3" class="col-sm-2 col-form-label">이메일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email"
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
										class="form-check-label" for="gridRadios1"> 선택안함
										 </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gender"
										id="gender2" value="1"> <label
										class="form-check-label" for="gridRadios2"> 남
										 </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="gender"
										id="gender3" value="2"> <label
										class="form-check-label" for="gridRadios3"> 여
										</label>
								</div>
							</div>
						</div>
					</fieldset>
					
					<div class="form-group row">
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary">회원가입</button>
						</div>
					</div>
				</form>


			</div>
			<div class="col-2"></div>
		</div>
	</div>


</body>
</html>