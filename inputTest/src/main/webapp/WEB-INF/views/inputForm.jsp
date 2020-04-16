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
<script type="text/javascript">
function chk() {
    
	var kor = frm.kor.value;
	var eng = frm.eng.value;
	var math = frm.math.value;
	
	if (frm.name.value.length < 1) {
        alert('이름은 1글자 이상 입력해 주세요.');
        frm.name.focus();
        return false;
    }
	
	if (kor == "" || isNaN(kor) || Number(kor) < 0 || Number(kor) > 100) {
		alert('0보다는 큰값 100보다는 작은값을 입력해 주세요.');
		frm.kor.focus();
		return false;
	}
	
	if (eng == "" || isNaN(eng) || Number(eng) < 0 || Number(eng) > 100) {
		alert('0보다는 큰값 100보다는 작은값을 입력해 주세요.');
		frm.eng.focus();
		return false;
	}
	
	if (math == "" || isNaN(math) || Number(math) < 0 || Number(math) > 100) {
		alert('0보다는 큰값 100보다는 작은값을 입력해 주세요.');
		frm.math.focus();
		return false;
	}
	
    return true;
    
}
</script>
</head>
<body>
	<!-- 
	<form action="input.do">
	 -->
	<form action="${conPath }/input.do" name="frm" onsubmit="return chk()">
	<span class="cnt" style="float: right;">"현재 총 ${cnt }명"</span><br>
		<h2>개인정보 입력</h2>
		<!-- 
		이름 : <input type="text" name="name" required="required" ><br>
		국어 : <input type="number" name="kor" min="0" max="100" required="required" ><br>
		영어 : <input type="number" name="eng" min="0" max="100" required="required" ><br>
		수학 : <input type="number" name="math" min="0" max="100" required="required" ><br>
		 -->
		이름 : <input type="text" name="name"  ><br>
		국어 : <input type="number" name="kor"  ><br>
		영어 : <input type="number" name="eng"  ><br>
		수학 : <input type="number" name="math"  ><br>
		<br>
		<button onclick="submit" >입력</button>
	</form>
</body>
</html>