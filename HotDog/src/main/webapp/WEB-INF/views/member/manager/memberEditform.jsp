<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>

<style>

#oldfile {
	height: 100px;
}

body {
	background-color: #ffe395;
	padding-top: 80px;
	padding-left: 100px;

	background-image : url('${pageContext.request.contextPath}/uploadfile/civa.jpg');
}

.my-3 {
	height: 520px;
	width: 900px;
	border: 1px solid;
	border-radius: 10px;
	border-color: white;
	margin-left: 80px;
}

</style>


</head>
<body>

	<main role="main" class="container">

		<div class="my-3 p-3 bg-white shadow-sm">
			<h3>프로필 수정</h3>
			<hr>
			<!-- form 경로와 처리 경로가 동일 -> method 로 구분 -->
			<!-- action="reg.do" 생략 가능 -->
			<form method="post" enctype="multipart/form-data">

				<div class="form-group row">
					<label for="email" class="col-sm-2 col-form-label">이메일</label>
					<div class="col-sm-10">
						<input type="hidden" name="memberIdx" value="${member.memberIdx}">
						<input type="email" name="email" id="email"
							value="${member.email}" class="form-control" readonly>
					</div>
				</div>

				<div class="form-group row">
					<label for="petNumber" class="col-sm-2 col-form-label">펫 등록번호</label>
					<div class="col-sm-10">
						<input type="text" name="petNumber" id="petNumber"
							value="${member.petNumber}" class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">이름</label>
					<div class="col-sm-10">
						<input type="text" name="name" id="name" value="${member.name}"
							class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="address" class="col-sm-2 col-form-label">주소</label>
					<div class="col-sm-10">
						<input type="text" name="address" id="address"
							value="${member.address}" class="form-control" required>
					</div>
				</div>

<!-- 				<div class="form-group row"> -->
<!-- 					<label for="neutering" class="col-sm-2 col-form-label">중성화 -->
<!-- 						여부</label> -->
<!-- 					<div class="col-sm-10"> -->
<%-- 						<c:if test="${member.neutering eq 1}"> --%>
<%-- 							<input type="text" name="neutering" id="neutering" value="${member.neutering}" --%>
<!-- 								class="form-control" autocomplete="1" required> -->
<%-- 						</c:if> --%>
<%-- 						<c:if test="${member.neutering ne 1}"> --%>
<%-- 							<input type="text" name="neutering" id="neutering" value="${member.neutering}" --%>
<!-- 								class="form-control" autocomplete="0" required> -->
<%-- 						</c:if> --%>
<!-- 					</div> -->
<!-- 				</div> -->

				<div class="form-group row">
					<label for="profile" class="col-sm-2 col-form-label"> 프로필
						사진 </label>
					<div class="col-sm-10">
						<c:if test="${not empty member.profile}">
							<img id="oldfile"
								src="${pageContext.request.contextPath}/uploadfile/${member.profile}">
							<br>
						</c:if>

						<input type="hidden" name="oldfile" value="${member.profile}">

					</div>
				</div>

				<div class="form-group row">
					<label for="profile" class="col-sm-2 col-form-label"> 사진 변경
					</label>
					<div class="col-sm-10">
						<input type="file" name="profile" id="profile"
							class="form-control-plaintext">
					</div>
				</div>

				<input type="submit" value="정보수정" class="btn btn-primary">
				<input type="reset" class="btn btn-secondary">
					
				<a href="/hgs/home" class="btn btn-info"> 홈으로 </a>
				
				<a href="javascript:delMember(${member.memberIdx})" class="btn btn-danger">탈퇴하기 </a>

			</form>
		</div>

	</main>
	
		<script>
		function delMember(idx) {
			if (confirm("정말로 탈퇴하시겠습니까?")) {
				location.href = 'delete?idx=' + idx;
			}
		}
	</script>

</body>
</html>