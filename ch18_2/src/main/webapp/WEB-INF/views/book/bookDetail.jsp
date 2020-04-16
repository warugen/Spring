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
<style>
	#content {
		width: 1200px; height:550px;
		margin: 50px auto;
	}
	img{width: 200px;}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	
	<div id="content">
		<table>
			<caption>${detail.bnum }번 도서 상세보기</caption>
			<tr><th>책이름</th><td colspan="2">${detail.btitle }</td></tr>
			<tr><th>저자</th><td colspan="2">${detail.bwriter }</td></tr>
			<tr><th>출판일</th><td colspan="2">${detail.brdate }</td></tr>
			<tr><th>책이미지</th><td><img src="${conPath }/bookImgFileUpload/${detail.bimg1 }"></td><td><img src="${conPath }/bookImgFileUpload/${detail.bimg2 }"></td></tr>
			<tr><th>책소개</th><td colspan="2">${detail.binfo }</td></tr>
			<tr>
			<td colspan="3">
				<button onclick="location='book.do?method=modifyForm&bnum=${detail.bnum}&pageNum=${param.pageNum }'">수정하기</button>
				<button onclick="location='book.do?method=list&pageNum=${param.pageNum}'">목록</button>
			</td>
			</tr>
		
		</table>
	
	
	</div>
	
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>