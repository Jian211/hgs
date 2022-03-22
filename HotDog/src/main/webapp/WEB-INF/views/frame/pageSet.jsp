<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">

<!-- 부트 스트랩 -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" -->
<!-- 	crossorigin="anonymous"> -->

<!-- <script -->
<!-- 	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" -->
<!-- 	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" -->
<!-- 	crossorigin="anonymous"></script> -->
	
<script src="https://kit.fontawesome.com/70b9626072.js" crossorigin="anonymous"></script>
	
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


<!-- css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css" />

<!--  
	구글 폰트 
	font-family: 'Noto Sans KR', sans-serif;
-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<!-- 
	일본어 
	font-family: 'Noto Sans JP', sans-serif;
	font-family: 'Noto Sans KR', sans-serif;	
-->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100;300;400;500;700;900&family=Noto+Sans+KR&display=swap" rel="stylesheet">

	
<!-- nav -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/nav.css" />
<script>
	function showMypage(){
		$.ajax({
			url :`member/${logger.memberIdx}`,
			type :"get"
		})
		.done(function(data){
			location.href = "/hgs/"+ data;
		})
		.fail(function(){
			console.log("ㄴㄴ")
		})
	}	
	
	function logout(){
		$.ajax({
			url : "logout",
			type : "get"
		}).done(function(data){
			location.href = "/hgs";
		}).fail(function(){
			console.log("logout fail")
		})
	}
</script>

	