<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp"%>
	<link rel="stylesheet" href="http://localhost:8080/hgs/css/list.css" />
	<meta charset="UTF-8">
	<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
	<title>추천장소 리스트</title>
</head>
<body>
	<div class="placeList-container">
	<!-- Top nav Bar -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	
		<!-- content 시작 -->
		<div id="content">
			<div class="text-info">
				<h3 class="place-text-h3">추천 장소</h3>
				<h5 class="place-text-h5">추천장소 > 공원</h5>
			</div>
	
			<!-- 추천장소  리스트 영역-->
			<!-- 추천장소 탭메뉴 -->
			<div class="tab-menu">
				<ul class="nav nav-pills mb-3 " id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="pills-home-tab"	data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">
							애견카페
						</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" type="button"	role="tab" aria-controls="pills-profile" aria-selected="false">
							동물병원
						</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-contact-tab"	data-bs-toggle="pill" data-bs-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact" aria-selected="false">
							공원
						</button>
					</li>
				</ul>
			</div>
			<!-- 추천장소 등록 버튼(관리자 전용) -->
			<div>
				<a class="btn btn-primary" href="register" role="button">등록</a>
			</div>
			
		</div>
	
		<!-- 추천장소 리스트 영역 -->
		<div class="place-list">
			<c:if test="${not empty listView.list}">
				<c:forEach items="${listView.list}" var="places">
					<div class="card" style="width: 18rem;">
						<a
							href="${pageContext.request.contextPath}/place/view?placeIdx=${places.placeIdx}">
							<img
							src="${pageContext.request.contextPath}/uploadfile/${places.fileName}"
							class="card-img-top" alt="...">
						</a>
						<div class="card-body">
							<h5 class="card-title">${places.title}</h5>
							<h6 class="card-address">${places.newAddress}</h6>
							<div class="badge rounded-pill bg-warning text-dark">${places.subjectCategory}</div>
							<a
								href="${pageContext.request.contextPath}/place/view?placeIdx=${places.placeIdx}"
								class="btn btn-primary">스크랩</a>
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