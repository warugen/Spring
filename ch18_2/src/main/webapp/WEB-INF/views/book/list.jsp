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
	
	form {
		width: 500px;
		margin: 50px auto;
	}
</style>
</head>
<body>
	<c:if test="${not empty registerResult }">
		<script> alert("도서 등록이 완료 되었습니다");</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">

	<div>
	<!-- <form action="${conPath }/book.do?method=list"> -->
	<form action="${conPath }/book.do">
		<input type="hidden" name="method" value="list">
		<select name="schItem">
		<!-- 
			<option value=""
				<c:if test="${param.schItem=='' }">selected="selected"</c:if>
				></option>
				-->
			<option value="all"
				<c:if test="${param.schItem=='all' }">selected="selected"</c:if>
				>책이름+저자</option>
				 
			<option value="btitle"
				<c:if test="${param.schItem=='btitle' }">selected="selected"</c:if>
				>책이름</option>
			<option value="bwriter"
				<c:if test="${param.schItem=='bwriter' }">selected="selected"</c:if>
			>저자</option>
		</select>
		<input type="text" name="schWord" value="${param.schWord }">
		<input type="submit" value="검색">
	</form>
	</div>
		
		<table>
			<caption>도서 목록</caption>
			
			<tr>
			<c:forEach var="book" items="${list }" >
				<td>
					${book.btitle }<br>
					<a href="${conPath }/book.do?method=detail&bnum=${book.bnum}&pageNum=${paging.currentPage}">
					<img src="${conPath }/bookImgFileUpload/${book.bimg1}"></a><br>
					${book.bwriter } 著 <br>
					출판일 : ${book.brdate }
				</td>
			</c:forEach>
			</tr>
		</table>
		<br>
		<br>
		<div class="paging">
		<c:if test="${paging.startPage>paging.blockSize }">
			[ <a href="${conPath }/book.do?method=list&pageNum=${paging.startPage-1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }"
			end="${paging.endPage }">
			<c:if test="${paging.currentPage==i }">
				[ <b> ${i }</b> ]
			</c:if>
			<c:if test="${paging.currentPage!=i }">
				[ <a href="${conPath }/book.do?method=list&pageNum=${i}"> ${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage<paging.pageCnt }">
			[ <a href="${conPath }/book.do?method=list&pageNum=${paging.endPage+1}">다음</a> ]
		</c:if>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>