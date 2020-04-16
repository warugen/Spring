<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<table>
		<tr><th>글제목</th><td>${detail.btitle }</td></tr>
		<tr><th>글내용</th>
				<td><div>${detail.bcontent }</div></td>
		</tr>
		<tr><td><button onclick="${conPath}/list.do?pageNum=${param.pageNum}">목록</button></td></tr>
	</table>
</body>
</html>