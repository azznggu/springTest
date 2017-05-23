<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
<script src="script/jquery-3.1.1.min.js""></script>
<script>
	$(function(){
		$("#loginBtn").on("click", function(){
			$("#form").submit();
		});
		
		$("#backBtn").on("click", function(){
			window.location = "./";
		});
	});
	
</script>
</head>
<body>
	<h1>Login</h1>
	<form id="form" action="login" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPassword"></td>
			</tr>
		</table>
	</form>
	<button id="loginBtn">Login</button>
	<button id="backBtn">Go Back</button>
</body>
</html>