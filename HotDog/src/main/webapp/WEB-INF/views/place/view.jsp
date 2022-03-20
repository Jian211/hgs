<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<title>Insert title here</title>
<style>
div#content {
	width: 800px
}
</style>


</head>
<body>
	<div style="margin: 0 280px;">
	
		<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
		<!-- 네비게이션 끝 -->
	
		<!-- content 시작 -->
		<main role="main" class="container">
	
	
	
			<div class="my-3 p-3 bg-white rounded shadow-sm">
				<table class="table">
					<tr></tr>
					<td></td>
					<td>
						<img src="${pageContext.request.contextPath}/uploadfile/${pageView.fileName}" class="card-img-top" alt="..." style="height: 100% ">
					</td>
	
					<tr>
						<td>이름</td>
						<td>${pageView.title}</td>
					</tr>
	
					<tr>
						<td>주소</td>
						<td>${pageView.newAddress}</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td>${pageView.phone}</td>
					</tr>
					<tr>
						<td>지역</td>
						<td>${pageView.affiliation}</td>
					</tr>
					<tr>
						<td>홈페이지</td>
						<td><a href="${pageView.homepage}" target="_blank">${pageView.homepage}</a></td>
					</tr>
					<tr>
						<td>지도</td>
						<td><div id="map" style="width: 100%; height: 350px;"></div></td>
					</tr>
	
				</table>
			</div>
	
	
			<div id="replyList"
				class="col-md-8 my-3 p-3 bg-white rounded shadow-sm">
				<h3 class="border-bottom border-gray pb-2 mb-0">댓글</h3>
				<c:if test="${empty replyList}">
					<tr>
						<td><h3>등록된 후기가 없습니다.</h3></td>
					</tr>
				</c:if>
				<c:if test="${not empty replyList}">
					<c:forEach items="${replyList}" var="reply">
	
						<div id="reply${reply.placeReplyIdx}" class="media text-muted pt-3">
	
							<p>작성자 아이디</p>
							<p>${reply.content}</p>
	
							<div onclick="deleteReply(${reply.placeReplyIdx})"
								class="badge  badge-info" style="color: black;">X</div>
						</div>
					</c:forEach>
				</c:if>
	
			</div>
	
			<div class="col-md-8 my-3 p-3 bg-white rounded shadow-sm">
				<h5 class="border-bottom border-gray pb-2 mb-0">작성자 아이디</h5>
	
				<form id="replyWriteForm" class=" text-right" method="POST">
	
					<textarea name="content" id="content" rows="5" cols="30"
						class="form-control p-3" required></textarea>
	
					<!-- <input type="hidden" name="memberIdx" value="${user.member.idx}"> -->
					<input type="hidden" name="placeIdx" value="${pageView.placeIdx}">
	
					<input type="submit" value="작성" class="btn btn-success">
				</form>
	
			</div>
	
	
			<button class="btn btn-warning" data-oper='update'>수정</button>
			<button class="btn btn-outline-warning" data-oper='list'>목록보기</button>
			<%-- 			<c:if test="${loginInfo.idx eq pageView.memberidx}"> --%>
			<%-- 				<a href="edit?idx=${pageView.idx}" class="btn btn-info">수정</a> --%>
			<%-- 				<a href="javascript:deleteMessage(${pageView.idx})" --%>
			<!-- 					class="btn btn-danger">삭제</a> -->
			<%-- 			</c:if> --%>
	
			<form id='operForm' action="/place/update" method="get">
				<input type="hidden" id='placeIdx' name='placeIdx'
					value='<c:out value="${pageView.placeIdx}"/>'>
			</form>
	
		</main>

	</div>





	<!-- 수정, 목록보기 버튼 동작 -->
	<script>
	$(document).ready(function() {

		var operForm = $('#operForm')

		$("button[data-oper='update']").on("click", function(e) {

			operForm.attr("action", "update").submit();
		});

		$("button[data-oper='list']").on("click", function(e) {

			operForm.find("placeIdx").remove();
			operForm.attr("action", "list");
			operForm.submit();
		});

	});
	</script>




	<!-- 후기작성 버튼 클릭 시 동작  -->
	<script>
		$("#replyWriteForm").submit(
					function() {
							$.ajax({
									url : '${pageContext.request.contextPath}/place/reply',
									type : 'POST',
									data : $(this).serialize(),
									success : function(data) {

											var html = '';
							
											html += '<div id="reply'+data+'" class="media text-muted pt-3">';
											html += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">';
											html += $('#content').val();
											html += '</p>';
											html += '<div onclick="deleteReply('+ data + ')" class="badge badge-info">X</div>';
											html += '</div>';
																		
											$('#replyList').append(html);
											$('#content').val('');
											location.reload();
										},
										error : function() {
											console.log('통신에러!');
										}

									});

							return false;
						});
		
		
		function deleteReply(placeReplyIdx){
			
			if(confirm('댓글을 삭제하시겠습니까?')){
				
				
				
				$.ajax({                       
					url : '${pageContext.request.contextPath}/place/reply/'+placeReplyIdx,
					type : 'DELETE',
					success : function(data){
						if(data == '1'){

							$('#reply'+placeReplyIdx).remove();
							
						}
						location.reload();
					}
				});
			}
		}
		
	
		
	</script>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b831cb9231e82dc116c15d613033258a&libraries=services"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
	

		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('${pageView.oldAddress}',
				function(result, status) {

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {
								
								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

								// 결과값으로 받은 위치를 마커로 표시합니다
								var marker = new kakao.maps.Marker({
									map : map,
									position : coords
								});

								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:6px 0;">${pageView.title}</div>'
										});
								infowindow.open(map, marker);

								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
								 
							}
						});
		
		
		
						
	</script>
	<script>
	console.log($(".btn-click"))
	$(".btn-click").on("click",(function(){
		console.log("gdgd")
		const display =	$(".accordion-body").css("display");
		if(display === "none"){
			$(".accordion-body").css("display","block");
		} else {
			$(".accordion-body").css("display","none");
		}
	}))

</script>
</body>
</html>