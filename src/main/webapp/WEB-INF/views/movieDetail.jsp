<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 상세내용</title>
<script src="script/jquery-3.1.1.min.js"></script>
<script>
	$(function(){
		$("#updateBtn").on("click", function(){
			 $("#form").attr("action", "updateMovie");
			 $("#form").submit();
		});
		$("#deleteBtn").on("click", function(){
			 $("#form").attr("action", "deleteMovie");
			 $("#form").submit();
		});
		$("#backBtn").on("click", function(){
			window.location="./movieList";
		});
	});
</script>
</head>
<body>
<h1>Movie詳細内容</h1>
	<table>
		<tr>
			<th>title</th>
			<td><input type="text" id="movie_title" name="movie_title" value="${movie.movie_title}"></td>
		</tr>
		<tr>
			<th>director</th>
			<td><input type="text" id="movie_director" name="movie_director" value="${movie.movie_director}"></td>
		</tr>
		<tr>
			<th>actor</th>
			<td><input type="text" id="movie_actor" name="movie_actor" value="${movie.movie_actor}"></td>
		</tr>
		<tr>
			<th>genre</th>
			<td><input type="text" id="movie_genre" name="movie_genre" value="${movie.movie_genre}"></td>
		</tr>
	</table>
	
	<form id="form" method="post">
		<input type="hidden" value="${movie.movie_no}">
	</form>
	
	<button id="updateBtn">更新</button>
	<button id="deleteBtn">削除</button>
	<button id="backBtn">戻る</button>
</body>
</html>