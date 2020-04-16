<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet" />
</head>
<body>
	<form action="${conPath }/modify.do" method="post" >
	<input type="hidden" name="bid" value="${bid }">
	<input type="hidden" name="pageNum" value="${param.pageNum }">
		<table>
			<caption>글수정 하기</caption>
			<tr>
				<th>글번호</th>
				<td><input type="text" name="bid" value="${dto.bid }" readonly="readonly" ></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required" value="${dto.bname }" /></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required="required" value="${dto.btitle }" /></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea name="bcontent"  cols="30" rows="10">${dto.bcontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn" />
					<input type="reset" value="취소" class="btn" />
					<input type="button" value="목록" onclick="location.href='${conPath}/list.do?pageNum=${param.pageNum }'" class="btn" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>