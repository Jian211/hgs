<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>

<%@ include file="/WEB-INF/views/frame/pageform.jsp"%>

<style>

body {
	background-color: #ffe395;
	padding-top: 80px;
	padding-left: 100px;

	background-image : url('${pageContext.request.contextPath}/uploadfile/civa.jpg');
	
	backdrop-filter: blur(4px);
	
	height : 2000px;
}

#content>div {
	padding: 15px;
}

#content>table {
	border: 0;
	border-collapse: collapse;
	
	width: 900px;
}
#content>table td, #content>table th {
	border: 1px solid #aaa;
	padding: 10px;
	
	text-align: center;
}

#listInfo {
	border : 1px solid #aaa;
	width : 870px;
}

#paging {
	overflow: hidden;
}

#paging>a {
	display: block;
	
	width: 30px;
	height: 30px;
	
	border: 1px solid #aaa;
	
	text-align: center;
	line-height: 30px;
	
	float : left;
	
	margin-right: 5px;
	
	text-decoration: none;
}

#paging>a:hover {
	background-color: #ff0;
	color: #00f;
}

.curpage {
	background-color: #333;
	color: #fff;
}

</style>
</head>
<body>

	<!-- 해더 시작 -->
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->


	<!-- content 시작 -->
	<main role="main" class="container">

		<div
			class="d-flex align-items-center p-3 my-3 bg-purple rounded shadow-sm">
			<h3> 전체 회원 리스트</h3>
		</div>

		<div class="my-3 p-3 bg-orange rounded shadow-sm">

			<form>
				<div class="form-row">
					<div class="col-auto">
						<select name="searchType" class="form-control">
							<option value="uid"
								${param.searchType eq 'uid' ? 'selected' : ''}>아이디</option>
							<option value="uname"
								${param.searchType eq 'uname' ? 'selected' : ''}>이름</option>
							<option value="both"
								${param.searchType eq 'both' ? 'selected' : ''}>아이디 +
								이름</option>
						</select>
					</div>
					<div class="col-auto">
						<input type="text" name="keyword" class="form-control"
							value="${param.keyword}">
					</div>
					<div class="col-auto">
						<input type="submit" value="검색" class="btn btn-primary">
					</div>
				</div>
			</form>

			<div class="border mt-3 p-2">전체 회원 수: ${listView.totalCount}명 ,
				현재 페이지: ${listView.currentPage}/${listView.pageTotalCount}</div>

			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th>회원번호</th>
						<th>이메일</th>
						<th>펫 등록번호</th>
						<th>이름</th>
						<th>생일</th>
						<th>성별</th>
						<th>주소</th>
						<th>중성화 여부</th>
					</tr>
				</thead>

				<c:if test="${empty listView.list}">
			<tr>
						<td colspan="7">등록된 회원 데이터가 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty listView.list}">

					<c:forEach items="${listView.list}" var="member">
						<tr>
							<td>${member.memberIdx}</td>
							<td>${member.email}</td>
							<td>${member.petNumber}</td>
							<td>${member.name}</td>
							<td>${member.birthday}</td>
							<td>${member.sex}</td>
							<td>${member.address}</td>
							<td>${member.neutering}</td>
							<td><a href="memberEdit?idx=${member.memberIdx}">수정</a> <a
								href="javascript:delMember(${member.memberIdx})">삭제</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>

			<div class="btn-toolbar" role="toolbar" >
				<div class="btn-group mr-2" role="group">
					
					<c:if test="${listView.pageTotalCount > 0}">
		
						<c:forEach begin="1" end="${listView.pageTotalCount}" var="pnum">
							<a
								href="memberList.do?p=${pnum}&searchType=${param.searchType}&keyword=${param.keyword}"
								class="btn ${listView.currentPage eq pnum ? 'btn-dark': 'btn-white'}">${pnum}</a>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>

	</main>
	
	<!-- content 끝 -->
	<!-- Javascript 추가 -->

	<script>
		function delMember(idx) {
			if (confirm("해당 회원 정보를 삭제하시겠습니까?")) {
				location.href = 'delete?idx=' + idx;
			}
		}
	</script>

</body>
</html>








