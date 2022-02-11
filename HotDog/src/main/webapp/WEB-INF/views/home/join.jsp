<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>핫핫!! 핫한 개들의 수다</title>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp" %>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	
	<!-- 
	
		1. 이메일 타입에 따른 input창 보여주기  / ok
		2. 주소 api 사용 / ok
		3. 품종 ajax활용
		4. 해쉬태그 폼 
	
	 -->
	
	<h1>회원가입하고 인싸가 되어보세요!</h1>
	
	<form method="post" enctype="multipart/form-data">

		<c:if test="${not empty emailType.snsType}">
			<input type="email" id="snsId" name="snsId" value="${emailType.email}" placeholder="이메일을 입력해주세요 . *"><br>
			<input type="hidden" id="snsType" name="snsType" value="${emailType.snsType}" >
		</c:if>
		<c:if test="${empty emailType}">
			<input type="email" id="email" name="email" autocomplete="username" placeholder="이메일을 입력해주세요 . *"><br>
		</c:if>
		
		<!-- 패스워드 입력  정규식 활용 -->
		<input type="password" id="password1" name="password1" autocomplete="new-password" placeholder="패스워드를 입력해주세요 . *"><br>
		<input type="password" id="password2" name="password2" autocomplete="new-password" placeholder="비밀번호 확인. *"><br>
		<input type="text" id="petNumber" name="petNumber" placeholder="반려견 이름을 입력해주세요 . *" ><br>
		<input type="file" ><br>
		<div id="address">
			<input type="text" id="postcode" placeholder="우편번호">
			<input type="button" onclick="daumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="roadAddress" placeholder="도로명주소">
			<input type="text" id="jibunAddress" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" id="detailAddress" placeholder="상세주소">
		</div>
		<input type="date" name="date">		
		<div>
			<div>성별</div>
			<input type="radio" name="sex" value="girl" checked>여자
			<input type="radio" name="sex" value="boy">남자
		</div>
		<div>
			<div>중성화 여부<input type="checkbox" name="neutering"></div>
		</div>
		<div id="breed-container">
			<div>품종</div>
			<div>
				<input type="text" id="breed" name="breed" placeholder="품종을 입력해주세요.">
				<div id="breed_checking"></div>
			</div>
			<ul id="breed_list">
				
			</ul>
			
		</div>
		<div>
			<input type="checkbox" name="hashtags">대형견
			<input type="checkbox" name="hashtags">중형견
			<input type="checkbox" name="hashtags">소형견
			<input type="checkbox" name="hashtags">산책
			<input type="checkbox" name="hashtags">강아지
		</div>
		
		<input type="submit" value="회원가입">
		<button>로그인창으로 돌아가기</button>
	</form>	
	
</body>

<script>
	$(document).ready(function(){
		console.log('${emailType.snsType}')
		console.log('${emailType}')
		
		// SNS형식 가입이면 이메일을 수정 못하도록 readonly 속성 추가	
// 		if($('#snsId').val().length > 0){
// 			$('#snsId').attr("readonly","readonly");
// 			$('#snsId').attr("style","color:gray");
// 		}
	})
</script>
<script>	
	/* 
		품종 선택 Ajax
		- input창에 입력한 즉시 관련 결과들을 출력.
		- 결과 값들 중에 유저가 선택 한 값이 있다면, 선택한 값을 input창에 채워 넣기
		- 유저가 입력한 값이 DB에 같은 데이터가 있는지 확인 후, 확인 결과를 알리기 
	*/
	const breedContainer = $("#breed-container");
	const breed 		 = breedContainer.children("#breed");
	const breedList 	 = breedContainer.children("#breed_list");
	const breedChecking  = breedContainer.children("#breed_checking");
	
	// 유저가 검색한 결과를 도출하는 Ajax
	breed.keyup(function(){
		$.ajax({
			url : "join/breed",
			data : { "word" : $(this).val() },
			type : "get",
		}).done(function(data){					// 초기화 후 결과 값을 생성
			breedList.empty();   				//   리스트 초기화
			$.each(data, insertToBreedList);	//   b.결과 값 생성	
		}).fail(function(request, error){		// 실패 시, 오류 메시지 출력
			console.log("code : %s	 message : %s	error : %s",request.status, request.responseText,error);
		})
	});
	
	// b.결과 값 생성 : 받은 데이터를 li에 셋팅 후 list에 삽입.
	const insertToBreedList = function(index,value){
		breedList.append("<li>"+value+"</li>");
	}
	
	// 유저가 품종을 선택 시, 품종 데이터를 input 속으로 삽입.
	breedList.on("click","li",function(event){
		breed.val(event.target.innerText);
	});
	
	// input을 벗어날 때, 정확한 입력하지 않았으면, 정확한 값 입력하라고 표시해주기.
	breedContainer.focusout(function(){
		console.log("어디가요")
		$.ajax({
			url  : "join/breed",
			data : {"dogType" : breed.val()},
			type : "post",
		}).done(function(data){
			const pass = "훌륭한 강아지를 키우시고 계시군요?";
			const again = "다시 한번 입력한 값을 확인 해 주시겠어요?";
			breedChecking.val(data > 0 ? pass : again);
		}).fail(function(request,error){
			console.log("code : %s	 message : %s	error : %s",request.status, request.responseText,error);
		});
	});
	
	
</script>
<script>

	// 다음 주소 API //
	
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function daumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</html>
