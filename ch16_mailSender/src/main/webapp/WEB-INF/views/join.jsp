<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>
</head>
<body>
	<form action="textMail" method="post">
		<p>이름 : <input type="text" name="name" required="required"></p>
		<p>메일 : <input type="email" name="mailaddr" required="required"></p>
		<input type="submit" value="회원가입(TEXT형식단순 메일감)">
	</form>
	<hr color="green">
	<form action="htmlMail" method="post">
		<p>이름 : <input type="text" name="name" required="required"></p>
		<p>메일 : <input type="email" name="mailaddr" required="required"></p>
		<input type="submit" value="회원가입(HTML형식 메일이감)">
	</form>
</body>
</html>