<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="script/jquery-3.1.1.min.js"></script>
<script>
	$(function() {
		$("#send").attr("disabled", true);

		$("#idCheck").on("click", function() {
			var userId = $("#userId").val();
			if (userId.length == 0) {
				alert("아이디를 먼저 입력하세요.");
				return false;
			}
			var sendData = {"userId" : userId};
			
			$.ajax({
				method : "POST",
				url : "idCheck",
				data : sendData,
				dataType : "text",
				success : function(response) {
					console.log(response);
					if (response == 'success') {
						$("#result").text("사용가능한 아이디입니다.");
						$("#result").css({"color": "#66ff33"});
						$("#send").attr("disabled", false);
					} else {
						$("#result").text("이미 사용 중인 아이디입니다.");
						$("#result").css({"color": "red"});
						$("#send").attr("disabled", true);
						return;
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="join" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userId" name="userId"></td>
				<td><input type="button" id="idCheck" value="중복확인" /></td>
				<td><span id="result"></span></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPassword"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="userPhone"></td>
			</tr>
		</table>
		<input type="submit" id="send" value="가입하기">
	</form>
</body>
</html>