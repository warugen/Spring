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
	<h1>studentId.jsp입니다.</h1>
	<h2>전송방식 : ${method }</h2>
	<h2>아이디 : ${id }</h2>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}/main.do'">처음으로 다시</button>
</body>
</html>