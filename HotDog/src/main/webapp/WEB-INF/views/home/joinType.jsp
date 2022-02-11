<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>핫핫!! 핫한 개들의 수다</title>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp" %>
</head>
<body>
	
	<h3>Create an account</h3>
	<h3>Sign up with social</h3>
	<a href="join">이메일로 회원가입 하기</a><br>
	<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=43759419ecbf05fbee7b1064e2ea3094&redirect_uri=http://localhost:8080/hgs/oauth/kakao">카카오 아이디로 회원가입</a><br>
	<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=5aNOGrdJbdtyJSOIZFn3&state=STATE_STRING&redirect_uri=http://localhost:8080/hgs/oauth/naver">네이버 계정으로 회원가입</a><br>
	
	<!-- 이거 구글 -->
	<a href="https://accounts.google.com/o/oauth2/v2/auth?client_id=820302346751-8vua4mbcio64i4v5btqprjkchm41ufhm.apps.googleusercontent.com&redirect_uri=http://localhost:8080/hgs/oauth/google&response_type=code&scope=https%3A//www.googleapis.com/auth/drive.file">구글 계정으로 회원가입</a>
	<div>
		Already have an account?<a href="#">Sign in</a>
	</div>
	
</body>
	
	
</html>
