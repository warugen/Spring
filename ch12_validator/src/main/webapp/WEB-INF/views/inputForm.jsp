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
	<form action="${conPath }/input.do" method="post">
		<p>이름 : <input type="text" name="name" value="${student.name }"></p>
		<p>ID : <input type="number" name="id" 		
		value='<c:if test="${student.id!=0 }" >${student.id}</c:if>'>
		</p>
		<input type="submit" value="입력">
	</form>
	<h4>${nameError }</h4>
	<h4>${idError }</h4>
</body>
</html>