<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<h1>메인화면</h1>
	<c:if test="${empty userId}">
		<li><a href="join">회원가입</a></li>
		<li><a href="login">로그인</a></li>
	</c:if>
	<c:if test="${not empty userId}">
		<li>${userName}님 환영합니다.</li>
		<li><a href="logout">로그아웃</a></li>
		<li><a href="movieList">영화정보</a></li>
	</c:if>
</body>
</html>