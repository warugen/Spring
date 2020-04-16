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
		// td아무곳이나 클릭해도 넘어가게하기
		/* 방법1
		$('tr').click(function() {
			var bid = Number($(this).children(0).eq(2).html());
			if(!isNaN(bid)){
				location.href = '${conPath}/content_view.do?bid=' + bid +'&pageNum=${pageNum}';
			}
		});
		*/
		
		
	});
	// 방법2 tr태그에 onclick이벤트를 등록
	function trClick(bid) {
		location.href = '${conPath}/content_view.do?bid=' + bid +'&pageNum=${pageNum}';
	}
</script>
</head>
<body>
	<!-- 글쓰기 성공 실패 -->
	<c:set var="SUCCESS" value="1"></c:set>
	<c:set var="FAIL" value="0"></c:set>
	<c:if test="${writeResult==SUCCESS }">
	<script type="text/javascript">
	alert('글쓰기 성공');
	</script>
	</c:if>
	<c:if test="${writeResult==FAIL }">
	<script type="text/javascript">
	alert('글쓰기 실패');
	</script>
	</c:if>
	
	<!-- 글수정 성공 실패 -->
	<c:if test="${modifyResult==SUCCESS }">
	<script type="text/javascript">
	alert('글수정 성공');
	</script>
	</c:if>
	<c:if test="${modifyResult==FAIL }">
	<script type="text/javascript">
	alert('글수정 실패');
	</script>
	</c:if>
	
	<!-- 글삭제 성공 실패 -->
	<c:if test="${deleteResult==SUCCESS }">
	<script type="text/javascript">
	alert('글삭제 성공');
	</script>
	</c:if>
	<c:if test="${deleteResult==FAIL }">
	<script type="text/javascript">
	alert('글삭제 실패');
	</script>
	</c:if>
	
	<!-- 답변글 성공 실패 -->
	<c:if test="${replyResult==SUCCESS }">
	<script type="text/javascript">
	alert('답변글 성공');
	</script>
	</c:if>
	<c:if test="${replyResult==FAIL }">
	<script type="text/javascript">
	alert('답변글 실패');
	</script>
	</c:if>
	
	<table>
	<tr><td><a href="${conPath }/write_view.do" >글쓰기</a></td></tr>
	</table>
	<c:set var="oNum" value="${orderNum }"></c:set>
	<c:set var="iNum" value="${inverseNum }"></c:set>
	<table>
		<tr>
			<th>순번</th><th>역순</th><th>글번호</th><th>글쓴이</th><th>글제목</th><th>작성일</th><th>조회수</th>
		</tr>
		<c:if test="${totCnt==0 }">
			<tr><td colspan="7">글이 없습니다.</td></tr>
		</c:if>
		<c:if test="${totCnt!=0 }">
			<c:forEach items="${list }" var="dto">
			<tr onclick="trClick(${dto.bid})">
				<td>${oNum }</td>
				<td>${iNum }</td>
				<td>${dto.bid }</td>
				<td>${dto.bname }</td>
				
				<td class="left">
					<c:forEach var="i" begin="1" end="${dto.bindent }">
						<c:if test="${i==dto.bindent }">
							└☞
						</c:if>
						<c:if test="${i!=dto.bindent }">
							&nbsp;&nbsp;&nbsp;
						</c:if>
					</c:forEach>
					${dto.btitle }
				</td>
				
				<td>
					<fmt:formatDate value="${dto.bdate }" pattern="yy/MM/dd(E)"/>
				</td>
				<td>
					<fmt:formatNumber value="${dto.bhit }" groupingUsed="true"></fmt:formatNumber>
				</td>
			</tr>
			<c:set var="oNum" value="${oNum+1 }"></c:set>
			<c:set var="iNum" value="${iNum-1 }"></c:set>
			</c:forEach>
		</c:if>
	</table>
	
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
		[ <a href="${conPath }/list.do?pageNum=${startPage-1}"> 이 전 </a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i==pageNum }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i!=pageNum }">
				[ <a href="${conPath }/list.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
		[ <a href="${conPath }/list.do?pageNum=${endPage+1}"> 다 음 </a> ]
		</c:if>
	</div>
</body>
</html>