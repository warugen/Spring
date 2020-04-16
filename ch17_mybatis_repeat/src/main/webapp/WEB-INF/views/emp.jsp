<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<div id="wrap">
		<form action="${conPath }/emp.do">
			사원명 <input type="text" name="ename" value="${searchEmp.ename }"
				size="10"> 직책 <input type="text" name="job"
				value="${searchEmp.job }" size="10"> 부서 <select name="deptno">
				<option value="0">모든부서</option>
				<c:forEach var="dept" items="${deptList }">
					<option value="${dept.deptno }"
						<c:if test="${dept.deptno==search.deptno }">
						selected="selected"
					</c:if>>${dept.dname}</option>
				</c:forEach>
			</select> &nbsp; <input type="submit" value="검색">
		</form>
		<table>
			<tr>
				<th>사원번호</th>
				<th>이름</th>
				<th>직책</th>
				<th>관리자</th>
				<th>입사일</th>
				<th>급여</th>
				<th>상여</th>
				<th>부서번호</th>
			</tr>
			<c:forEach var="e" items="${empList}">
				<tr>
					<td>${e.empno }</td>
					<td>${e.ename }</td>
					<td>${e.job }</td>
					<td>${e.mgr }</td>
					<td><fmt:formatDate value="${e.hiredate }" pattern="yy년MM월dd일" />
					</td>
					<td align="right"><fmt:formatNumber value="${e.sal }"
							pattern="#,###,###" /></td>
					<td align="right"><fmt:formatNumber value="${e.comm }"
							pattern="#,###,####" /></td>
					<td>${e.deptno }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>