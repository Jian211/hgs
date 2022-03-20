<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp"%>	
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
	
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
#form_container {
	display: flex;
	align-item: center;
	justify-content: center;
}

form {
	margin: 20px;
	width: 550px;
	border: 1px solid rgb(0, 0, 0, 0.1);
	box-shadow: 5px 5px 7px;
}

h3 {
	text-align: center;
	margin-left: 40px;
}

div.mb-3 {
	text-align: center;
	margin: 20px;
	width: 500px;
}

div.col-12 {
	margin-bottom: 10px;
	text-align: center;
}
</style>
</head>
<body>	
	<div style="margin: 0 280px;">

		<!-- 네비게이션 시작 -->
		<!-- Top nav Bar -->
		<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	
		<h3>추천장소 수정</h3>
		<div id="form_container">
			<form role="form" method="post" enctype="multipart/form-data">
	
				<div class="mb-3">
					<label for="title" class="form-label">장소명</label> <input type="text"
						name="title" class="form-control" id="title"
						value='<c:out value="${pageView.title}"/>' required>
				</div>
	
				<div class="mb-3">
					<label for="subjectCategory" class="form-label">장소 카테고리</label> <select
						name="subjectCategory" id="subjectCategory" class="form-select">
						<option value="공원">공원</option>
						<option value="애견카페">애견카페</option>
						<option value="동물병원">동물병원</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="affiliation" class="form-label">장소 지역</label> <select
						name="affiliation" id="affiliation" class="form-select">
						<option value="서울">서울</option>
						<option value="부산">부산</option>
						<option value="인천">인천</option>
						<option value="대구">대구</option>
						<option value="광주">광주</option>
						<option value="대전">대전</option>
						<option value="울산">울산</option>
						<option value="부산">부산</option>
						<option value="세종">세종</option>
						<option value="경기도">경기도</option>
						<option value="강원도">강원도</option>
						<option value="충청북도">충청북도</option>
						<option value="충청남도">충청남도</option>
						<option value="전라북도">전라북도</option>
						<option value="전라남도">전라남도</option>
						<option value="경상북도">경상북도</option>
						<option value="경상남도">경상남도</option>
						<option value="제주">제주</option>
					</select>
				</div>
	
				<div class="mb-3">
					<label for="oldAddress" class="form-label">구주소</label> <input
						name="oldAddress" type="text" class="form-control" id="oldAddress"
						value='<c:out value="${pageView.oldAddress}"/>' required>
				</div>
				<div class="mb-3">
					<label for="newAddress" class="form-label">신주소</label> <input
						name="newAddress" type="text" class="form-control" id="newAddress"
						value='<c:out value="${pageView.newAddress}"/>' required>
				</div>
				<div class="mb-3">
					<label for="homepage" class="form-label">홈페이지</label> <input
						name="homepage" type="text" class="form-control" id="homepage"
						value='<c:out value="${pageView.homepage}"/>' required>
				</div>
				<div class="mb-3">
					<label for="phone" class="form-label">전화번호</label> <input
						type="text" name="phone" class="form-control" id="phone"
						value='<c:out value="${pageView.phone}"/>' required>
				</div>
	
				<div class="mb-3">
					<label for="photo" class="form-label">첨부파일</label> <input
						type="file" name="photo" class="form-control" id="photo">
				</div>
	
	
				<div class="col-12">
					<button class="btn btn-warning" type="submit" data-oper='update'>수정</button>
					<button class="btn btn-danger" type="submit" data-oper='delete'>삭제</button>
					<button class="btn btn-outline-warning" type="submit"
						data-oper='list'>목록보기</button>
				</div>
	
	
	
			</form>
		</div>

	</div>
	<script>
		$(document).ready(function() {

			var formObj = $("form");

			$('button').on("click", function(e) {

				e.preventDefault();

				var operation = $(this).data("oper");

				if (operation === 'delete') {
					formObj.attr("action", "/hgs/place/delete");

				} else if (operation == 'list') {
					self.location = "/hgs/place/list";
					return;
				}
				formObj.submit();
			});
		});
	</script>
</body>
</html>