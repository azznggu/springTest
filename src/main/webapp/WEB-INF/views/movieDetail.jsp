<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 상세내용</title>
<script src="script/jquery-3.1.1.min.js"></script>
<script>
	$(function() {
		$("#updateBtn").on("click", function() {
			$("#movie_title").removeAttr("readonly");
			var v = $("#movie_title").val();
			$("#movie_title").focus().val('').val(v);
			$("#movie_director").removeAttr("readonly");	
			$("#movie_actor").removeAttr("readonly");
			$("#movie_genre").removeAttr("readonly");
			$("#doUpdateBtn").css("visibility", "visible");
			$(this).css("visibility", "hidden");

		});
		$("#doUpdateBtn").on("click", function() {
			$("#form").attr("action", "updateMovie");
			$("#form").submit();
		});
		$("#deleteBtn").on("click", function() {
			var result = confirm("現在の情報を削除します。");
			if (result) {
				$("#form").attr("action", "deleteMovie");
				$("#form").submit();
			} else {
				alert("取り消し");
				return;
			}
		});
		$("#backBtn").on("click", function() {
			window.location = "./movieList";
		});
	});
</script>
</head>
<body>
	<h1>Movie詳細内容</h1>
	<form id="form" method="post">
		<table>
			<tr>
				<th>title</th>
				<td><input type="text" id="movie_title" name="movie_title"
					value="${movie.movie_title}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>director</th>
				<td><input type="text" id="movie_director"
					name="movie_director" value="${movie.movie_director}"
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>actor</th>
				<td><input type="text" id="movie_actor" name="movie_actor"
					value="${movie.movie_actor}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>genre</th>
				<td><input type="text" id="movie_genre" name="movie_genre"
					value="${movie.movie_genre}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${movie.userId eq userId}">
						<button type="button" id="doUpdateBtn" style="visibility: hidden;">更新完了</button>
						<button type="button" id="updateBtn">更新</button>
						<button type="button" id="deleteBtn">削除</button>
					</c:if>
					<button type="button" id="backBtn">戻る</button>
				</td>
			</tr>
		</table>
		<input type="hidden" value="${movie.movie_no}" name="movie_no">
	</form>

</body>
</html>