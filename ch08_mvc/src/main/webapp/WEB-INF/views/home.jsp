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
	<h2>home.jsp입니다.</h2>
	<h2>${greeting }</h2>
	<h2><a href="${conPath }/main">Main요청</a></h2>
	
	<hr>
	<img alt="이미지" src="${conPath }/img/PS19071000346.jpg">
	<h2>제가 짧게 한말씀 드리겠습니다....</h2>
	
</body>
</html>