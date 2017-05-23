<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 목록</title>
<script src="script/jquery-3.1.1.min.js"></script>
<script>
	$(function() {
		$("#writeBtn").on("click", function() {
			window.location = "./";
		});
		$("#backBtn").on("click", function() {
			window.location = "./";
		});
	});
</script>
</head>
<body>
	<h2>Movie List</h2>
	<table border="1" style="width: 500px">
		<tr>
			<th>no</th>
			<th>title</th>
			<th>director</th>
			<th>actor</th>
			<th>genre</th>
		</tr>
		<c:forEach var="movie" items="${movieList}">
			<tr align="center">
				<td>${movie.movie_no}</td>
				<td>${movie.movie_title}</td>
				<td>${movie.movie_director}</td>
				<td>${movie.movie_actor}</td>
				<td>${movie.movie_genre}</td>
			</tr>
		</c:forEach>
	</table>
	<button id="writeBtn">新規作成</button>
	<button id="backBtn">戻る</button>
</body>
</html>