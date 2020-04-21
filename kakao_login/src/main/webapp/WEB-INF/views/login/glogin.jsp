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
<%-- <link href="${conPath }/css/style.css" rel="stylesheet"> --%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
function checkLoginStatus(){
    var loginBtn = document.querySelector('#loginBtn');
    var nameTxt = document.querySelector('#name');
    var gid = document.querySelector('#gid');
    var gname = document.querySelector('#gname');
    var gemail = document.querySelector('#gemail');
    
    if(gauth.isSignedIn.get()){
      console.log('logined');
      loginBtn.value = 'Logout';
      
      var profile = gauth.currentUser.get().getBasicProfile();
      
      console.log(profile.getId());
      console.log(profile.getName());
      console.log(profile.getEmail());
      
      $('input[name=gid]').val(profile.getId());
      $('input[name=gname]').val(profile.getName());
      $('input[name=gemail]').val(profile.getEmail());

      
    } else {
      console.log('logouted');
      loginBtn.value = 'Login';
      
      $('input[name=gid]').val('');
      $('input[name=gname]').val('');
      $('input[name=gemail]').val('');
    }
  }
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

</script>
</head>
<body>
	<span id="name"></span>
	<input type="button" id="loginBtn" value="checking..." onclick="
    if(this.value === 'Login'){
      gauth.signIn().then(function(){
        console.log('gauth.signIn()');
        checkLoginStatus();
      });
    } else {
      gauth.signOut().then(function(){
        console.log('gauth.signOut()');
        checkLoginStatus();
      });
    }
  ">
  <br>
  <a href="https://accounts.google.com/o/oauth2/v2/auth?scope=https%3A//www.googleapis.com/auth/drive.metadata.readonly&include_granted_scopes=true&response_type=token&state=state_parameter_passthrough_value&redirect_uri=http%3A%2F%2Flocalhost%3A8181%2Fkakao%2Flogin.do%3Fmethod%3Dglogin&client_id=270921267005-3gcmpgpi6mom14ib57bmf2f7pav6b5sf.apps.googleusercontent.com">구글 로그인</a>
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>

<input type="text" name="gid" value="">
<input type="text" name="gname"  value="">
<input type="text" name="gemail"  value="">
  
</body>
</html>