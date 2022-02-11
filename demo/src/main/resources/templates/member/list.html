<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 리스트</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->




	<!-- content 시작 -->
	<main role="main" class="container">

		<div
			class="d-flex align-items-center p-3 my-3 text-white bg-purple rounded shadow-sm">
			<h4>방명록</h4>
		</div>

		<div class="my-3 p-3 bg-white rounded shadow-sm">

			<div class="border mt-3 p-2">전체 메시지 수: ${listView.totalCount}</div>


			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th style="width: 20px;">idx</th>
						<th style="">subject</th>
						<th style="width: 200px;">writer</th>
						<th style="width: 200px;">regdate</th>
					</tr>
				</thead>

				<c:if test="${empty listView.list}">
					<tr>
						<td colspan="4">등록된 게시물 데이터가 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty listView.list}">

					<c:forEach items="${listView.list}" var="article">
						<tr>
							<td>${article.idx}</td>
							<td>
								<a href="${pageContext.request.contextPath}/guestbook/view?idx=${article.idx}">
									${article.subject}
								</a>
								<span class="badge  badge-warning">${article.replyCnt}</span>
								<span class="badge badge-pill badge-danger">new</span>
							</td>
							<td><img class="border rounded-circle" style="height: 30px;"
								src="${pageContext.request.contextPath}/uploadfile/${article.photo}">
								${article.username}</td>
							<td>${article.regdate}</td>
						</tr>
					</c:forEach>

				</c:if>


			</table>


			<div class="row justify-content-md-center mt-4">
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


	</main>
	<!-- content 끝 -->








	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

	<script>
		
	</script>

</body>
</html>








