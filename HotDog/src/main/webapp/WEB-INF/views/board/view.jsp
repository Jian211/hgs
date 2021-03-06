<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp"%>	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
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
#content table td {
	padding: 5px;
}

#content>table tr>td:nth-child(1) {
	width: 100px;
	text-align: center;
	background-color: #ddd;
}

#content>table td>img {
	height: 25px;
	border: 1px solid #aaa;
	border-radius: 50%;
	vertical-align: middle;
}

#content>table {
	border: 0;
	border-collapse: collapse;
	width: 800px;
}

#content>table td {
	padding: 10px;
}

#content>table tr {
	border-top: 1px solid #aaa;
	border-bottom: 1px solid #aaa;
}

#replyArea {
	width: 600px;
	margin-top: 20px;
}

div.reply {
	border: 1px solid #aaa;
	overflow: hidden;
	padding: 15px;
	margin-top: 5px;
}

div.reply>div.img {
	width: 50px;
	float: left;
}

div.reply>div.img>img {
	width: 40px;
	height: 40px;
	border: 1px solid #aaa;
	border-radius: 50%;
}

div.reply>div.content {
	width: 480 px;
	float: left;
}

div.reply>div.close {
	width: 30px;
	float: right;
}

div.reply>div.close>div {
	width: 25px;
	height: 25px;
	text-align: center;
	line-height: 20px;
	background-color: #aaa;
}

#replyWrite {
	width: 600px;
	margin-top: 20px;
}

#replyWrite>h4 {
	margin: 5px 0;
}

#replyWrite textarea {
	width: 100%;
	font-size: 120%;
	padding: 5px;
}

#replyWrite>form {
	text-align: right;
}
</style>


</head>
<body>
	<div style="margin: 0 280px;">
		<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
		<!-- ??????????????? ??? -->
	
		<!-- content ?????? -->
		<main role="main" class="container">
	
			<div class="my-3 p-3 bg-white rounded shadow-sm">
				<table class="table">
					<tr>
						<td>?????????</td>
						<td>????????? ??????</td>
					</tr>
					<tr>
						<td>??????</td>
						<td>${pageView.title}</td>
					</tr>
					<tr>
						<td>??????</td>
						<td><pre style="line-height: 180%">${pageView.content}</pre></td>
					</tr>
					<tr>
						<td>??????</td>
						<td><img
							src="${pageContext.request.contextPath}/uploadfile/${pageView.fileName}" width="500px">
						</td>
					</tr>
					<tr>
						<td>
							<span class="badge bg-secondary"><h5>#??????</h5></span>
							<span class="badge bg-secondary"><h5>#???</h5></span>
							<span class="badge bg-secondary"><h5>#??????</h5></span>
						</td>
					</tr>
				</table>
			</div>
	
			<div id="replyList"
				class="col-md-8 my-3 p-3 bg-white rounded shadow-sm">
				<h3 class="border-bottom border-gray pb-2 mb-0">??????</h3>
				<c:if test="${empty replyList}">
					<tr>
						<td><h3>????????? ????????? ????????????.</h3></td>
					</tr>
				</c:if>
				<c:if test="${not empty replyList}">
					<c:forEach items="${replyList}" var="reply">
	
						<div id="reply${reply.boardReplyIdx}" class="media text-muted pt-3">
	
							<p>????????? ?????????</p>
							<p>${reply.content}</p>
	
							<div onclick="deleteReply(${reply.boardReplyIdx})"
								class="badge  badge-info" style="color: black;">X</div>
						</div>
					</c:forEach>
				</c:if>
	
			</div>
	
			<div class="col-md-8 my-3 p-3 bg-white rounded shadow-sm">
				<h5 class="border-bottom border-gray pb-2 mb-0">????????? ?????????</h5>
	
				<form id="replyWriteForm" class=" text-right" method="POST">
	
					<textarea name="content" id="content" rows="5" cols="30"
						class="form-control p-3" required></textarea>
	
					<!-- <input type="hidden" name="memberIdx" value="${user.member.idx}"> -->
					<input type="hidden" name="boardIdx" value="${pageView.boardIdx}">
	
					<input type="submit" value="??????" class="btn btn-success">
				</form>
	
			</div>
	
			
				<button class="btn btn-warning" data-oper='update'>??????</button>
				<button class="btn btn-outline-warning" data-oper='list'>????????????</button>
				<%-- 			<c:if test="${loginInfo.idx eq pageView.memberidx}"> --%>
				<%-- 				<a href="edit?idx=${pageView.idx}" class="btn btn-info">??????</a> --%>
				<%-- 				<a href="javascript:deleteMessage(${pageView.idx})" --%>
				<!-- 					class="btn btn-danger">??????</a> -->
				<%-- 			</c:if> --%>
	
				<form id='operForm' action="/board/update" method="get">
				<input type="hidden" id='boardIdx' name='boardIdx'
					value='<c:out value="${pageView.boardIdx}"/>'>
			</form>
	
	
		</main>


	</div>

	<!-- ?????? ?????? ?????? -->
	<script>
	$(document).ready(function() {

		var operForm = $('#operForm')

		$("button[data-oper='update']").on("click", function(e) {

			operForm.attr("action", "update").submit();
		});

		$("button[data-oper='list']").on("click", function(e) {

			operForm.find("boardIdx").remove();
			operForm.attr("action", "list");
			operForm.submit();
		});

	});
	</script>




	<!--  ???????????? ?????? ?????? ??? ??????  -->
	<script>
		$("#replyWriteForm").submit(
					function() {
							$.ajax({
									url : '${pageContext.request.contextPath}/board/reply',
									type : 'POST',
									data : $(this).serialize(),
									success : function(data) {

										var html = '';
										html += '<div id="reply'+data+'" class="media text-muted pt-3">';
										html += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">';
										html += '<strong class="d-block text-gray-dark">@????????? ?????????</strong>';
										html += $('#message').val();
										html += '</p>';
										html += '<div onclick="deleteReply('+data+')" class="badge  badge-info" style="color: black;">x</div>';
										html += '</div>';
										html += '<hr>';

											$('#replyList').append(html);
											$('#content').val('');
											location.reload();
										},
										error : function() {
											console.log('????????????!');
										}

									});

							return false;
						});
		
		
		function deleteReply(boardReplyIdx){
			
			if(confirm('????????? ?????????????????????????')){
				
				
				
				$.ajax({                       
					url : '${pageContext.request.contextPath}/board/reply/'+boardReplyIdx,
					type : 'DELETE',
					success : function(data){
						if(data == '1'){

							$('#reply'+boardReplyIdx).remove();
							
						}
						location.reload();
					}
				});
			}
		}
		
	
		
	</script>








</body>
</html>