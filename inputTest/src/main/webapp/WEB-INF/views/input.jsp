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
	<div class="inputBox">
	<span class="cnt" style="float: right;">"현재 총 ${cnt }명"</span><br>
	<h2>결과는 다음과 같습니다.</h2>
	<h3>이름 : ${student.name }</h3>
	<h3>국어 : ${student.kor }</h3>
	<h3>영어 : ${student.eng }</h3>
	<h3>수학 : ${student.math }</h3>
	<h3>총점 : ${student.total }</h3>
	<h3>평균 : ${student.avg }</h3>
	<br>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}/inputForm.do'">처음으로 다시</button>
	</div>
</body>
</html>