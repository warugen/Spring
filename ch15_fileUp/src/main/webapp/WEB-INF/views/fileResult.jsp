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
	<h2>업로드 결과 : ${fileResult }</h2>
	<p>파일 1 : ${fileNames[0] }</p>
	<p>파일 2 : ${fileNames[1] }</p>
	<p>파일 3 : ${fileNames[2] }</p>
	<img src="${conPath }/upload/${fileNames[0]}">
	<img src="${conPath }/upload/${fileNames[1]}">
	<img src="${conPath }/upload/${fileNames[2]}">
	<br>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='fileInput'">다시업로드</button>
</body>
</html>