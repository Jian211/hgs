<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>핫핫!! 핫한 개들의 수다</title>
</head>
<body>
	<form method="post">
		<input type="text" id="email" name="email"  placeholder="email을 입력해주세요." >
		<input type="password" id="password" name="password"  placeholder="password를 입력해주세요." >
		<input type="submit" value="Login">
		<input type="checkbox"><span>로그인 상태 유지</span> 
		<div>
			<span>아이디 찾기</span> | <span>비밀번호 찾기</span>
		</div>
		<div>네이버 로그인</div>
		<div>구글 로그인</div>
		<div>카카오톡 로그인</div>
	</form>
	<div>아직 회원이 아니신가요?<a href="join">회원가입하기</a></div>

</body>
<script>
	
</script>
</html>
