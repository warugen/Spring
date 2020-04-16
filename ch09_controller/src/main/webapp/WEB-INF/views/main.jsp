<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h1>${greeting }</h1>
	<hr>
	<h1>borad관련 요청 경로</h1>
	<h2><a href="${conPath }/board/view">board의 view로</a></h2>
	<h2><a href="${conPath }/board/content">board의 content로</a></h2>
	<h2><a href="${conPath }/board/write">board의 wirte로</a></h2>
	<h2><a href="${conPath }/board/reply">board의 reply로</a></h2>
	<hr>
	
	<h1>member관련 요청 경로</h1>
	<!-- ${conPath}빼도 가능하다 -->
	<button onclick="location.href='${conPath}/member/?method=join'">회원가입</button>
	<button onclick="location.href='member/?method=login'">로그인</button>
	<button onclick="location.href='member/?method=logout'">로그아웃</button>
	<button onclick="location.href='member/?method=modify'">정보수정</button>
</body>
</html>