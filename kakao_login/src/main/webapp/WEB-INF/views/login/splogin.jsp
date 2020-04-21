<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 SP</title>
<link href="${conPath }/css/login/login.css" rel="stylesheet">
<!-- kakao api -->
<script src="${conPath }/js/kakao.js" type="text/javascript"></script>
<!-- google api -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="270921267005-3gcmpgpi6mom14ib57bmf2f7pav6b5sf.apps.googleusercontent.com">
<!-- jQuery api -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" ></script>
<script type="text/javascript">


/*  
function init(){
    console.log('init');
    gapi.load('auth2', function() {
      console.log('auth2');
      window.gauth = gapi.auth2.init({
        client_id:'270921267005-3gcmpgpi6mom14ib57bmf2f7pav6b5sf.apps.googleusercontent.com'
      })
      gauth.then(function(){
        console.log('googleAuth success');
        checkLoginStatus();
      }, function(){
        console.log('googleAuth fail');
      });
    });
  }
  */
</script>

<style>
.login_content {
    margin: 0 auto 160px;
    padding-top : 50px;
    width: 380px;
}

.logo a {
    overflow: hidden;
    display: block;
    margin: 0 auto;
    width: 155px;
    height: 120px;
    /*  
    background: url(//pics.g9.co.kr/pc/cloud/member/sprite_login.png) no-repeat 0 -28px;
    */
    background: url(//raw.githubusercontent.com/warugen/TeamProject/master/logo/SP.png) no-repeat;
    text-indent: -999em;
}
a{
	text-decoration: none;
}

.btn1 {
    background: #3a5485;
    color: #fff;
    font-size: 20px;
    font-weight: 700;
    display: inline-block;
    position: relative;
    width: 100%;
    line-height: 18px;
    border: 2px solid #3a5485;
    border-radius: 10px;
    padding: 22px 0 19px;
    text-align: center;
}

.btn1:hover { background: #357bd8; }

.btn2 {
    background: #fff;
    color: #3a5485;
    font-size: 20px;
    font-weight: 700;
    display: inline-block;
    position: relative;
    width: 100%;
    line-height: 18px;
    border: 2px solid #3a5485;
    border-radius: 10px;
    padding: 22px 0 19px;
    text-align: center;
}

div {
    display: block;
}

.btn_wrap {
    text-align: center;
}

.link__login-kakao, .link__login-google {
    border-color: #d6d6d6;
    background : #FFF;
    font-weight: 400;
    color: #4e4e63;
    font-size: 16px;
    padding-bottom: 12px;
    width: 100%;
}

.link_group {
    margin: 40px 0 50px;
    text-align: center;
    font-size: 12px/1.5;
    line-height: 1;
}

.link_group>.bar {
    display: inline-block;
    margin: 0 12px;
    width: 1px;
    height: 12px;
    background: #d8d8d8;
    vertical-align: 11px;
}

.kakao-login-btn {
	display: inline-block;
	width: 100%;
}
</style>
</head>
<body>
	<div class="contaner">
		<div class="login_content">
			<h1 class="logo">
				<a href="http://www.g9.co.kr">G9</a>
			</h1>
<form>
	
	<input type="hidden" name="snsid" value="">
	<input type="hidden" name="provider"  value="">
	<input type="hidden" name="snsemail"  value="">

	<div class="group">
	  <input type="text"><span class="highlight"></span><span class="bar"></span>
	  <label>아이디</label>
	</div>
	<div class="group">
	  <input type="password"><span class="highlight"></span><span class="bar"></span>
	  <label>비밀번호</label>
	</div>
	<div class="btn_wrap">
	<a href="cart.do?method=cart" class="btn1">로그인</a>
	<!-- <button type="button" class="button buttonBlue">로그인
	  <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
	</button> -->
	<p>
	<a id="kakao-login-btn" class="kakao-login-btn" ></a>
	<p>
	<div class="g-signin2" data-onsuccess="onSignIn" data-width="220" data-longtitle="true"></div>
  	</div>
  	
	<div class="link_group">
		<a href="/Member/MemberShip/Signup" class="alink">회원가입</a> <span class="bar">|</span>
		<a href="javascript:Popup('ID');" class="alink">아이디 찾기</a> <span class="bar">|</span>
		<a href="javascript:Popup('PWD');" class="alink">비밀번호 찾기</a>
	</div>
  
</form>
<!-- <form action="">
	<div class="member_login area_box">
		<div id="form_memberlogin" class="box__login">
			<ul class="form_list">
				<li>
					<span class="guide_txt blind">
						<label for="MemberLoginM_MemberID">아이디</label>
					</span>
					<input class="txt" id="MemberLoginM_MemberID" maxlength="10" name="MemberLoginM.MemberID" type="text" value="" />
				</li>
				<li>
					<span class="guide_txt">
						<label for="MemberLoginM_MemberPassword">비밀번호</label>
					</span>
					<input class="txt" id="MemberLoginM_MemberPassword" maxlength="15" name="MemberLoginM.MemberPassword" type="password" />
				</li>
			</ul>

			<div class="btn_wrap">
				<a name="btnDoLoginJson" id="btnDoLoginJson" class="link__login" style="cursor:pointer">로그인</a>
				<a href="javascript:loginWithKakao()" class="link__login-kakao sprite__login--before">카카오 로그인</a>
				<a id="nonMemberBuyBtn" href="javascript:NonMemberGo();" class="link__login-line">비회원으로 구매하기</a>
			</div>

			<div class="link_group">
				<a href="/Member/MemberShip/Signup">회원가입</a> <span class="bar">|</span>
				<a href="javascript:Popup('ID');">아이디 찾기</a> <span class="bar">|</span>
				<a href="javascript:Popup('PWD');">비밀번호 찾기</a>
			</div>
		</div>
	</div>
</form> -->
			
			
		</div>
	</div>
	<script type="text/javascript">
	// 카카오 로그인 함수
	// input your appkey
	Kakao.init('3153b15ee605504fc683c26e15e2324a')
	console.log('kakao init : '+Kakao.isInitialized());
	
	// 버튼생성하기
	Kakao.Auth.createLoginButton({
	   container: '#kakao-login-btn',
	   success: function(authObj) {
	     Kakao.API.request({
	    	 url: '/v2/user/me',	       
	       success: function(res) {
	    	   var obj = JSON.stringify(res);
	         //alert(JSON.stringify(res));
	         alert(obj);
	         console.log(res);
	         console.log("id : "+res.id);
	         console.log("email : "+res.kakao_account.email);
	         console.log("nicknamel : "+res.nickname);
	         
	         $('input[name=snsid]').val(res.id);
	         $('input[name=provider]').val('kakao');
	         $('input[name=snsemail]').val(res.kakao_account.email);
	
	       },
	       fail: function(error) {
	         alert(
	           'login success, but failed to request user information: ' +
	             JSON.stringify(error)
	         );
	         $('input[name=snsid]').val('');
             $('input[name=provider]').val('');
	         $('input[name=snsemail]').val('');
	       },
	     })
	   },
	   fail: function(err) {
	     alert('failed to login: ' + JSON.stringify(err));
	     $('input[name=snsid]').val('');
         $('input[name=provider]').val('');
         $('input[name=snsemail]').val('');
	   },
	 });
	
	// google login
	function onSignIn(googleUser) {
	    var profile = googleUser.getBasicProfile();
	    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	    console.log('Name: ' + profile.getName());
	    console.log('Email: ' + profile.getEmail());
	    
	    $('input[name=snsid]').val(profile.getId());
        $('input[name=provider]').val('google');
        $('input[name=snsemail]').val(profile.getEmail());
	}
	
	</script>
	
</body>
</html>