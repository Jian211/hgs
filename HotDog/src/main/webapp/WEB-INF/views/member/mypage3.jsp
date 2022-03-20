<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보</title>
	<%@ include file="/WEB-INF/views/frame/pageform.jsp"%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mypage.css">
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>


	<!-- content 시작 -->

	<main role="main" class="container">

		<div class="my-3 p-3 bg-white rounded shadow-sm">

			<h4>${member.name}님의정보</h4>

			<table class="table">
				<tr>
					<td>이메일</td>
					<td><input type="text" value="${member.email}" readonly></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" value="${member.name}"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<c:if test="${member.sex eq 1}">
							<input type="text" value="남자" readonly >
						</c:if>
						<c:if test="${member.sex ne 1}">
							<input type="text" value="여자" readonly >
						</c:if>
					</td>
				</tr>
				<tr>
					<td>펫 등록번호</td>
					<td><input type="text" value="${member.petNumber}" ></td>
				</tr>
				<tr>
					<td>중성화 여부</td>
					<td>
						<c:if test="${member.neutering eq 1}" >
							Y
						</c:if>
						<c:if test="${member.neutering ne 1}">
							N
						</c:if>
						</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>${member.address}</td>
					<td>주소수정</td>
					<div id="address" >
						<input type="button" onclick="daumPostcode()" value="우편번호 찾기" class="btn btn-light"> <br>
						<input type="text" id="postcode" placeholder="우편번호" class="form-control"> 
						<input type="text" id="roadAddress" placeholder="도로명주소" class="form-control"> 
						<input type="text" id="jibunAddress" placeholder="지번주소" class="form-control"> 
						<span id="guide" style="color: #999; display: none"> </span> 
						<input type="text" id="detailAddress" placeholder="상세주소 " class="form-control">
					</div>
				</tr>
				<tr>
					<td>프로필 사진</td>
					<td><img
						src="${pageContext.request.contextPath}/uploadfile/${member.profile}"
						height="100"></td>
				</tr>

			</table>
			<a href="/hgs/member/manager/memberEdit?idx=${member.memberIdx}">
				내 정보 수정</a> <a href="/hgs/home" class="btn btn-info"> 홈으로 </a>

		</div>
	</main>
</body>
<script src="${pageContext.request.contextPath}/js/api/address.js"></script>
<script>
	console.log(${member.address})
</script>
</html>