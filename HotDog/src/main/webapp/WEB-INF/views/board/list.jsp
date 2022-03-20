<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp"%>	
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous">
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="http://localhost:8080/hgs/css/list.css" />
	<title>게시물 리스트</title>
</head>
<body>
	<div class="placeList-container">
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
		<div id="content">
			<div class="text-info">
				<h3 class="place-text-h3">커뮤니티</h3>
				<h5 class="place-text-h5">커뮤니티 > 게시물</h5>
			</div>
	
			<!-- 게시물 등록 버튼 -->
			<a class="btn btn-primary" href="register" role="button">등록</a>
		</div>
	
		<div class="place-list">
			<!-- 게시물 리스트 영역 -->
			<c:if test="${not empty listView.list}">
				<c:forEach items="${listView.list}" var="boards">
					<div class="card" style="width: 18rem;">
						<a
							href="${pageContext.request.contextPath}/board/view?boardIdx=${boards.boardIdx}">
							<img
							src="${pageContext.request.contextPath}/uploadfile/${boards.fileName}"
							class="card-img-top" alt="...">
						</a>
						<div class="card-body">
							<div style="color: gray">#중형견, #산책가고싶어, #휴무</div>
							<h5 class="card-title">${boards.title}</h5>
							<h6 class="card-address">${boards.content}</h6>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
		<div class="row justify-content-md-center mt-4 bottom">
			<div class="btn-toolbar " role="toolbar">
				<div class="btn-group mr-2" role="group">
					<c:if test="${listView.pagination.preNum>0}">
						<a href="list?p=${listView.pagination.preNum}"
							class="btn btn-primary">이전</a>
					</c:if>
					<c:forEach begin="${listView.pagination.startNum}"
						end="${listView.pagination.endNum}" var="pnum">
						<a href="list?p=${pnum}"
							class="btn ${listView.pageNum eq pnum ? 'btn-dark': 'btn-white'}">${pnum}</a>
					</c:forEach>
					<c:if test="${listView.pagination.nextNum>0}">
						<a href="list?p=${listView.pagination.nextNum}"
							class="btn btn-primary">다음</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	



</body>
</html>