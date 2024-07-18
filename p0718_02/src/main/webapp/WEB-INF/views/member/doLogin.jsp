<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<script>
		if(${chkLogin}==1){
			alert("로그인 성공");
			location.href="/index";
		}else{
			alert("로그인 실패. 아이디 및 패스워드 불일치");
			location.href="/member/login";
		};
		
	
	</script>
</body>
</html>