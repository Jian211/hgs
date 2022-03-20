<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>핫핫!! 핫한 개들의 수다</title>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp" %>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/join/join.css" />
</head>

<body>

	<div id="header">회원가입하고 인싸가 되어보세요!</div>

	<main role="main" class="container">
	
		<div class="my-3 p-3 bg-white shadow-sm">
		
			<form method="post" enctype="multipart/form-data" >
				<div class="form-group row">
					<label for="email" class="col-sm-3 col-form-label">이메일</label>
					<div class="col-sm-8">
						<c:if test="${not empty emailType.snsType}">
							<input class="form-control" type="email" id="snsId" name="snsId" autocomplete="username" value="${emailType.email}" placeholder="이메일을 입력해주세요 . *">
							<input type="hidden" id="snsType" name="snsType" value="${emailType.snsType}" >
						</c:if>

						<c:if test="${empty emailType}">
							<input type="email" id="email" name="email"	autocomplete="username" placeholder="이메일을 입력해주세요 ." class="form-control">
						</c:if>
					</div>
				</div>

				<!-- 패스워드 입력  정규식 활용 -->
				<div class="form-group row">
					<label for="pw" class="col-sm-3 col-form-label">비밀번호 </label> 
					<div class="col-sm-8">
						<input type="password" id="password1" name="password1" autocomplete="new-password" placeholder="패스워드를 입력해주세요 " class="form-control">
					</div>
				</div>

				<div class="form-group row">
					<label for="repw" class="col-sm-3 col-form-label">비밀번호</label> 
					<div class="col-sm-8">
						<input type="password" id="password2" name="password2"	autocomplete="new-password" placeholder="비밀번호 확인" class="form-control">
					</div>
				</div>

				<div id="password_answer"></div> <!-- 이건 뭐임? -->

				<div class="form-group row">
					<div class="col-sm-12">
						<input type="text" id="dogName" name="name"	placeholder="반려견 이름을 입력해주세요 " class="form-control">
					</div>
				</div>	
				
				<div class="form-group row">
					<div class="col-sm-12" >
						<input type="text" id="petNumber" name="petNumber"	placeholder="등록번호가 있으시면 입력해주세요!" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="profile" class="col-sm-4 col-form-label">프로필 사진</label>
					<input type="file" name="profile" id="profile">
				</div>
				
				<div class="form-group row">
					<div class="col-sm-12">
						<div id="address" >
							<input type="button" onclick="daumPostcode()" value="우편번호 찾기" class="btn btn-light"> <br>
							<input type="text" id="postcode" placeholder="우편번호" class="form-control"> 
							<input type="text" id="roadAddress" placeholder="도로명주소" class="form-control"> 
							<input type="text" id="jibunAddress" placeholder="지번주소" class="form-control"> 
							<span id="guide" style="color: #999; display: none"> </span> 
							<input type="text" id="detailAddress" placeholder="상세주소 " class="form-control">
						</div>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="birthday" class="col-sm-3 col-form-label"> 생년월일 </label>
					<div class="col-sm-8">
						<input type="date" id="birthday" name="birthday" class="form-control">
					</div>
				</div>
			
				<div class="form-group row">
					<label for="sex" class="col-sm-2 col-form-label"> 성별</label>
					<div class="col-sm-10">
						<input type="radio" name="sex" value="0" checked> 여성
						<input type="radio" name="sex" value="1"> 남성
					</div>
				</div>
				
				<div class="form-group row">
					<label for="neutering" class="col-sm-4 col-form-label"> 중성화 여부</label>
					<div class="col-sm-8">
						<input type="radio" id="neutering" name="neutering" value="0" checked> 아니오
						<input type="radio" id="neutering" name="neutering" value="1" > 예
					</div>
				</div>
				
				<div class="form-group row"> 
					<label for="breed" class="col-sm-2 col-form-label"> 품종 </label>
					<div class="col-sm-10"> 
						<div id="breedContainer">
							<input type="text" id="breed" name="breedIdx" list="breedList"	placeholder="품종을 입력해주세요." class="form-control">
							<div id="breed_checking"> </div>
						</div>
					</div>
				</div>
				
				<datalist id="breedList">
					<c:forEach items="${breedList}" var="breed">
						<option data-value="${breed.breedIdx}" value="${breed.dogType}"></option>
					</c:forEach>
				</datalist>

				<ul id="breedList">
				</ul>

				<h5> 관심사를 선택해주세요!!! (중복선택 가능) </h5>
				
				<div id="hashtags">
					<input type="checkbox" name="hashtags" value="28">대형견
					<input type="checkbox" name="hashtags" value="29">중형견 
					<input type="checkbox" name="hashtags" value="30">소형견 
					<input type="checkbox" name="hashtags" value="8">산책 
					<input type="checkbox" name="hashtags" value="3">강아지 
					<input type="checkbox" name="hashtags" value="17">장난감  <br>
					<input type="checkbox" name="hashtags" value="9">사료 
					<input type="checkbox" name="hashtags" value="1">동물병원 
					<input type="checkbox" name="hashtags" value="5">애견카페 
					<input type="checkbox" name="hashtags" value="2">공원	 <br>				
				</div>
				
				<br>
				
				<div class="btn btn-success" id="joinBtn">회원가입 </div>
				<input type="reset" class="btn btn-primary">
				<a href="/hgs" class="btn btn-secondary">로그인창으로 돌아가기</a>
			
			</form>
		</div>
	</main>
</body>
<script>
//submit ajax
joinBtn.onclick = function(){
	const formData = new FormData();
	if(typeof $('#email').val() != "undefined" || $('#email').val()  != null ){
		formData.append('email', $('#email').val());
		console.log($('#email').val())
	} else {
		formData.append('snsId', $('#snsId').val());
		formData.append('snsType', $('#snsType').val());
		console.log($('#snsId').val())
		console.log($('#snsType').val())
	}
	const breedIdx = $("#breedList option[value="+"'"+$('#breed').val()+"'"+"]")[0].dataset.value;
	var tagIdxList = [];
	$("input:checkbox[name=hashtags]:checked").each(function(index,tag){
		tagIdxList.push(tag.value)
	});
	
	formData.append('password',$('#password1').val());	// 비밀번호  	password1
	formData.append('name',$('#dogName').val());		// 반려견 이름  dogName
	formData.append('petNumber',$('#petNumber').val()); // 펫		petNumber
	formData.append('profile',$('#profile')[0].files[0])// 프로파일 	profile
	formData.append('address',$('#roadAddress').val()+"_"+$("#detailAddress").val()); 	// 주소  		roadAddress + _ + detailAddress
	formData.append('birthday',$('#birthday').val()); 	// 생일 		birthday
	formData.append('sex',$("input:radio[name=sex]:checked").val()); // 성별		sex  0이 여자 1이 남자
	formData.append('neutering',$('#neutering')[0].checked ? 1 : 0); // 중성화 여부	neutering
	formData.append('breedIdx',breedIdx);				// 품종
	formData.append('hashtagIdx',tagIdxList); 			// 관심사 
	
	//const pathUrl = `${pathContext.request.contextPath}/member/oauth`;
	
	$.ajax({
		url : 'test',
		type : 'POST',
		data : formData,
		enctype : 'multipart/form-data',
		processData : false,
		contentType : false,
		cash : false,
	}).done(function(){
		console.log("ok")
		location.href = "/hgs";
	}).fail(function(){
		console.log("no")
	})

}
</script>
<script src="${pageContext.request.contextPath}/js/join/join.js"></script>
<script src="${pageContext.request.contextPath}/js/api/address.js"></script>
</html>
