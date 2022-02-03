<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>핫핫!! 핫한 개들의 수다</title>
</head>
<body>
<h1>
	<form method="post">
		<input type="text" id="email" name="email"  placeholder="email을 입력해주세요." >
		<input type="password" id="password" name="password"  placeholder="password를 입력해주세요." >
		<input type="submit" value="Login">
	</form>
	<ul>
		<li onclick="kakaoLogin();">
	      <a href="javascript:void(0)">
	          <span>카카오 로그인</span>
	      </a>
		</li>
		<li onclick="kakaoLogout();">
	      <a href="javascript:void(0)">
	          <span>카카오 로그아웃</span>
	      </a>
		</li>
	</ul>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('c3d33077d50916de6b6521acf72299f7'); 	//발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); 				// sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>
</h1>

</body>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
</html>
