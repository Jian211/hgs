<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<div class="searchBox" id="searchBox" >
	<h2 class="search-text">게시판 정보</h2>
	<div class="search-place">
		<c:if test="${allPlaces.homeBoard == null or fn:length(allPlaces.homeBoard) == 0 }">
			<h1 class="noting">검색 결과가 존재하지 않습니다.</h1>
		</c:if>
		<c:forEach items="${allPlaces.homeBoard}" var="board" > 
			<div class="board medium-box box-outside" onclick="boardDetail(${board.boardIdx})">
				<div class="board_top-nav">
					<div class="board_top-nav-img">${board.profile}</div>
					<div class="board-top-nav-member">
						<div>${board.name}</div>
						<div>${board.createDate}시간 전</div>
					</div>
				</div>
				<div class="board-img" style="text-align: center;"><img style="height: 100%; " alt="" src="${pageContext.request.contextPath}/uploadfile/${board.fileName}"></div>
				<div class="board-content">
					<div class="board-tagLikes">
						<div>${board.tags}</div>
						<div>좋아요  ${board.likes}</div>
					</div>
					<div>${board.content}</div>
				</div>
			</div>
		</c:forEach>	
	</div>
	
	<h2 class="search-text">애견카페 정보</h2>
	<div class="search-place">
		<c:if test="${allPlaces.homeCafe == null or fn:length(allPlaces.homeCafe) == 0 }">
			<h1 class="noting">검색 결과가 존재하지 않습니다.</h1>
		</c:if>
		<c:forEach items="${allPlaces.homeCafe}" var="place">
			<div class="box-outside place" onclick="placeDetail(${place.cafeIdx})" >
				<div class="place_cate">#${place.cSubjectCategory}</div>
				<div class="place_title">${place.cTitle}</div>
				<div class="place_address">${place.cNewAddress}</div>
				<div>${place.cFileName}</div>
				<%-- <div>${place.cHashtags}</div> --%>
				<%-- <div>${place.cScrapIdx}</div> --%>
			</div>
		</c:forEach>
	</div>
	
	<h2 class="search-text">동물병원 정보</h2>
	<div class="search-place">
		<c:if test="${allPlaces.homeHospital == null or fn:length(allPlaces.homeHospital) == 0 }">
			<h1 class="noting">검색 결과가 존재하지 않습니다.</h1>
		</c:if>
		<c:forEach items="${allPlaces.homeHospital}" var="place">
			<div class="box-outside place" onclick="placeDetail(${place.hospitalIdx})" >
				<div class="place_cate">#${place.hSubjectCategory}</div>
				<div class="place_title">${place.hTitle}</div>
				<div class="place_address">${place.hNewAddress}</div>
				<div>${place.hFileName}</div>
				<%-- <div>${place.hHashtags}</div> --%>
				<%-- <div>${place.hScrapIdx}</div> --%>
			</div>
		</c:forEach>
	</div>
	
	<h2 class="search-text">공원 정보</h2>
	<div class="search-place">
		<c:if test="${allPlaces.homePark == null or fn:length(allPlaces.homePark) == 0 }">
			<h1 class="noting">검색 결과가 존재하지 않습니다.</h1>
		</c:if>
		<c:forEach items="${allPlaces.homePark}" var="place">
			<div class="box-outside place" onclick="placeDetail(${place.parkIdx})" >
				<div class="place_cate">#${place.pSubjectCategory}</div>
				<div class="place_title">${place.pTitle}</div>
				<div class="place_address">${place.pNewAddress}</div>
				<div>${place.pFileName}</div>
				<%-- <div>${place.pHashtags}</div> --%>
				<%-- <div>${place.pScrapIdx}</div> --%>
			</div>
		</c:forEach>
	</div>
</div>
