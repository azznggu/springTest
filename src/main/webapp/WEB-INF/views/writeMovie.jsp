<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>추가하기</title>
<script src="script/jquery-3.1.1.min.js"></script>
<script>
	$(function() {
		$("#writeBtn").on("click", function() {
			if ($("#movie_title").val() == 0||$("#movie_director").val() == 0||$("#movie_actor").val() == 0||$("#movie_genre").val() == 0) {
				alert("入力項目を確認してください。");
				return false;
			}
			$("#form").submit();
		});
		$("#backBtn").on("click", function() {
			window.location = "./";
		});
	});
</script>
</head>
<body>
	<h2>write!</h2>
	<form id="form" action="writeMovie" method="post">
		<table>
			<tr>
				<th>title</th>	
				<td><input type="text" id="movie_title" name="movie_title"></td>
			</tr>
			<tr>
				<th>director</th>
				<td><input type="text" id="movie_director" name="movie_director"></td>
			</tr>
			<tr>
				<th>actor</th>
				<td><input type="text" id="movie_actor" name="movie_actor"></td></tr>
			<tr>
				<th>genre</th>			
				<td><input type="text" id="movie_genre" name="movie_genre"></td>
			</tr>
		</table>
	</form>
	<button id="writeBtn">登録</button>
	<button id="backBtn">一覧へ</button>
</body>
</html>