<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>핫핫!! 핫한 개들의 수다</title>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp"%>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/join/joinType.css" />
</head>
<body>

	<h1 >Create an account</h1>
	<h1>Sign up with social</h1>
	<br>
	<div>
		<a href="join">이메일로 회원가입 하기</a> <br> <br> <a
			href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=43759419ecbf05fbee7b1064e2ea3094&redirect_uri=http://localhost:8080/hgs/member/oauth/kakao">카카오
			아이디로 회원가입</a> <br> <br> <a
			href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=5aNOGrdJbdtyJSOIZFn3&state=STATE_STRING&redirect_uri=http://localhost:8080/hgs/member/oauth/naver">네이버
			계정으로 회원가입</a> <br> <br>
	</div>

	<div id="div01">Already have an account?
		<a href="#"> <br> Sign in</a>
	</div>

</body>
	
</html>
