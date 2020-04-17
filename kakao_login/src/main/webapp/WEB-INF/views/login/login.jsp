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
<style type="text/css">
.api-btn {
	min-width: 222px;
	height: 49px;
	line-height: 49px;
	font-size: 16px;
	font-weight: 600;
	color: #000;
	background-color: #ffeb00;
}
</style>
<link href="${conPath }/css/style.css" rel="stylesheet">
<script src="${conPath }/js/kakao.js" type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
	});
</script>
</head>
<body>
	<h2>login page</h2>
	<a id="custom-login-btn" href="javascript:loginWithKakao()"> <img
		src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
		width="222" />
	</a>
	<h2>로그아웃</h2>
	<button class="api-btn" onclick="kakaoLogout()">로그아웃</button>
	<br>
	<h2>사용자 프로필 포함해서 가져오기</h2>
	<a id="kakao-login-btn"></a>

	<h2>새 계정으로 로그인</h2>
	<a id="login-form-btn" href="javascript:loginFormWithKakao()"> <img
		src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
		width="222" />
	</a>

	<script type="text/javascript">
  // input your appkey
  Kakao.init('3153b15ee605504fc683c26e15e2324a')
  console.log(Kakao.isInitialized());
  function loginWithKakao() {
    Kakao.Auth.login({
      success: function(authObj) {
        alert(JSON.stringify(authObj))
        console.log(JSON.stringify(authObj))
      },
      fail: function(err) {
        alert(JSON.stringify(err))
      },
    })
  }
  
  function kakaoLogout() {
	    if (!Kakao.Auth.getAccessToken()) {
	      alert('Not logged in.')
	      return
	    }
	    Kakao.Auth.logout(function() {
	      alert('logout ok\naccess token -> ' + Kakao.Auth.getAccessToken())
	    })
	  }
  
  Kakao.Auth.createLoginButton({
	    container: '#kakao-login-btn',
	    success: function(authObj) {
	      Kakao.API.request({
	        url: '/v2/user/me',
	        success: function(res) {
	          alert(JSON.stringify(res))
	          console.log("id : "+res.id);
	          console.log("email : "+res.kakao_account.email);
	          console.log("nicknamel : "+res.nickname);

	        },
	        fail: function(error) {
	          alert(
	            'login success, but failed to request user information: ' +
	              JSON.stringify(error)
	          )
	        },
	      })
	    },
	    fail: function(err) {
	      alert('failed to login: ' + JSON.stringify(err))
	    },
	  })
	  
	  function loginFormWithKakao() {
    Kakao.Auth.loginForm({
      success: function(authObj) {
        alert(JSON.stringify(authObj))
      },
      fail: function(err) {
        alert(JSON.stringify(err))
      },
    })
  }
</script>
</body>
</html>