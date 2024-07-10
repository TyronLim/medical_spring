<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 확인</title>
<style>
	table,td,th{border:1px solid black; border-collapse:collapse;}
</style>
</head>
<body>
	<h2>입력 확인</h2>
	<form action="memUpdate" method="post">
		<input type="hidden" name="id" value="${id}">
		<input type="hidden" name="pw" value="${pw}">
		<input type="hidden" name="name" value="${name}">
		<input type="hidden" name="phone" value="${phone}">
		<input type="hidden" name="gender" value="${gender}">
		<input type="hidden" name="hobby" value="${hobby}">
		<table>
			<tr>
				<th>id</th>
				<th>pw</th>
				<th>name</th>
				<th>phone</th>
				<th>gender</th>
				<th>hobby</th>
			</tr>
			<tr>
				<td>${id}</td>
				<td>${pw}</td>
				<td>${name}</td>
				<td>${phone}</td>
				<td>${gender}</td>
				<td>${hobby}</td>
			</tr>
		</table>
		<input type="submit" value="수정">
	</form>


</body>
</html>