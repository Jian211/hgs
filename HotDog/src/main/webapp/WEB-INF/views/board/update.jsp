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
		
		<h3>게시물 수정</h3>
		<div id="form_container">
			<form role="form" action="/board/update" method="post">
		
				<div class="mb-3">
					<label for="title" class="form-label">제목</label> <input type="text"
							name="title" class="form-control" id="title"
							value='<c:out value="${pageView.title}"/>' required>
				</div>
		
				<div class="mb-3">
					<label>내용</label> <input class="form-control" name='content'
						value='<c:out value="${pageView.content}"/>'>
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
					formObj.attr("action", "/hgs/board/delete");

				} else if (operation == 'list') {
					self.location = "/hgs/board/list";
					return;
				}
				formObj.submit();
			});
		});
	</script>
</body>
</html>