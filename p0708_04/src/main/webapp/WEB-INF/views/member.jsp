<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보입력</title>
</head>
<body>
	<h2>정보 입력</h2>
	<form action="doMember" name="frm" method="get">
		<label>id</label>
		<input type="text" name="id"><br>
		
		<label>pw</label>
		<input type="password" name="pw"><br>
		
		<label>name</label>
		<input type="text" name="name"><br>

		<label>phone</label>
		<input type="text" name="phone"><br>
		
		<input type="radio" name="gender" id= "male" value="male">남
		<input type="radio" name="gender" id = "female" value="female">여<br>
	
		<label>취미</label><br>
		<input type="checkbox" name="hobby" id="book" value="book">
		<label for="book">독서</label>
		<input type="checkbox" name="hobby" id="run" value="run">
		<label for="run">조깅</label>
		<input type="checkbox" name="hobby" id="fish" value="fish">
		<label for="fish">낚시</label>
		
		<br>
		<input type="submit" value="확인">
	
	</form>
</body>
</html>