<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>doLogin</title>
	</head>
	<body>
		<script>
			if(${chkLogin}==1){
				alert("로그인 완료");
				location.href='/index';
			}else if(${chkLogin}==0){
				alert("아이디 패스워드 일치하지 않습니다");
				location.href='/member/login';
			}else{
				alert("로그아웃되었습니다.");
				location.href='/index';
			}
		</script>
	
	</body>
</html>