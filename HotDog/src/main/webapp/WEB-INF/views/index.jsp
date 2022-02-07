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
	<div>이메일로 회원가입 하기</div>
	<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=43759419ecbf05fbee7b1064e2ea3094&redirect_uri=http://localhost:8080/hgs/oauth">카카오 아이디로 회원가입</a>
	<a href="kakao">카카오로 회원가입</a>
	<div id="naver" onclick="return api('kakao')">카카오 아이디로 회원가입</div>
<!-- 	<div id="google" onclick=auth('google')>구글 아이디로 회원가입</div> -->
	<div>
		Already have an account?<a href="">Sign in</a>
	</div>
	
	
</body>
<script>
	function auth(sns){
		location.href="oauth/api/v1/"+sns;
		
	}	
	
	function api(sns){
		console.log("클릭하심")
		$.ajax({
			url : "<%=request.getContextPath()%>/views/home/joinSNS", 
			type : "GET",
			success : function(data){
				console.log("hi");
			},
			error: function(err){
				
				console.log(err);
			}
		})
	}
	

</script>
	
	
</html>
