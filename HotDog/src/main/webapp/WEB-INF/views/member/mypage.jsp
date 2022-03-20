<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>会員情報</title> <!-- 회원정보 -->
	<meta charset="UTF-8">
	<%@ include file="/WEB-INF/views/frame/pageform.jsp"%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mypage.css">
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<style>
		body{
			font-family: 'Noto Sans JP', sans-serif;
			font-weight: 600;
			font-size: large;
		}
	</style>
</head>
<body>

	<!-- HEADER NAV -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>	
	
	<!-- CONTENT -->
	<div class="member-info-container">
		
		<!-- top -->
		<div  class="member-info_title">
			<div>基本情報</div> <!-- 기본정보 -->
			<button onclick=showArrow()>情報修正</button> <!-- 정보수정 -->
		</div>
		<hr>
		
		<!-- email -->
		<div class="member-info_email">
			<div class="info-form">
				<div>
					<div>メール</div> <!-- 이메일 -->
					<div id="email">${member.email}</div>				
				</div>

				<!-- 일반로그인 한 유저만 보여줌 -->
				<c:if test="${ member.snsType eq 0 }">
					<div>
						<div>パスワード</div>			<!-- 패스워드        -->
						<button>パスワード変更</button> <!-- 패스워드 변경 -->
					</div>
				</c:if>
				
				<!-- 소셜로그인 한 유저만 보여줌 -->
				<c:if test="${ member.snsType > 0 }">
					<div>
						<div>SNS</div> 
						<div id="snsType">
							<c:if test="${member.snsType eq 1}">KAKAO</c:if>
							<c:if test="${member.snsType eq 2}">NAVER</c:if>
						</div>				
					</div>
				</c:if>
				
				<div>
					<div>作成日</div> <!-- 생성일 -->
					<div>${member.regDate}</div>
				</div>
				
				<div>
					<div>会員退会</div> 		<!-- 회원탈퇴 -->
					<button onclick="askDelete()">退会</button>	<!-- 탈퇴 -->
				</div>
			</div>
			
		</div>
		<hr>
		
		<!-- name -->
		<div class="member-info_name">
			<div class="flex-box-form">
				<div>名前</div>
				<div id="name">${member.name}</div>
				<div class="arrow-box">
					<img class="arrow" onclick="clickArrow(this)" alt="" src="${pageContext.request.contextPath}/images/angle-right-solid.svg">
				</div>
			</div>
			<div class="name-edit-form" style="display: none;">
				<div>変更する名前を入力してください。</div>
				<div>
					<input type="text" placeholder="${member.name}">
					<button onclick="chgName(this)">変更</button>
				</div>
			</div>
		</div>
		<hr>
		
		<!-- profile -->
		<div class="member-info_profile">
			<div class="flex-box-form"> 
				<div>プロフィール</div>
				<input type="file" id="profile" style="display: none;">
				<img id="showImg" style="width: 100px;" src="${pageContext.request.contextPath}/uploadfile/${member.profile}">
				<div class="arrow-box">
					<img class="arrow" onclick="clickArrow(this)" alt="" src="${pageContext.request.contextPath}/images/angle-right-solid.svg">
				</div>
			</div>
			<div class="profile-edit-form" style="display: none;">
				<div>변경하실 이미지를 </div>
				<input id="member-profile" type="file" onchange="readURL(this);">
				<img id="preview">
				<button id="profile-btn" onclick="chgProfile(this)" >변경하기</button>
			</div>
		</div>
		<hr>
		
		<!-- birth -->
		<div class="member-info_birth">
			<div class="flex-box-form">
				<div>生年月日</div> <!-- 탄생일 -->
				<div id="birthday">${member.birthday}</div>
				<div class="arrow-box"> 
					<img class="arrow" onclick="clickArrow(this)" src="${pageContext.request.contextPath}/images/angle-right-solid.svg">
				</div>
			</div>
			
			<div class="birth-edit-form" style="display: none;">
				<div>変更する名前を入力してください。</div>
				<div>
					<input type="date" >
					<button onclick="chgDay(this)">変更</button>
				</div>
			</div>
		</div>
		<hr>
		
		<!-- sex -->
		<div class="member-info_sex">
			<div class="flex-box-form">
				<div>性別</div> <!-- 성별 -->
				<input type="text" id="sex" value="${ member.sex }" style="display: none">
				<div id="sexText">
					<c:if test="${ member.sex eq 0 }">女</c:if>
					<c:if test="${ member.sex eq 1 }">男</c:if>
				</div>
				<div class="arrow-box"> 
					<img class="arrow" onclick="clickArrow(this)" src="${pageContext.request.contextPath}/images/angle-right-solid.svg">
				</div> 
			</div>
			
			<div class="sex-edit-form" style="display: none;">
				<div>変更する名前を入力してください。</div>
				<div>
					<input type="radio"  name="sex" value="0" checked>女
					<input type="radio"  name="sex" value="1">男
					<button onclick="chgSex(this)">変更</button>
				</div>
			</div>
		</div>
		<hr>
		
		<!-- petNumber -->
		<div class="member-info_petNumber">
			<div class="flex-box-form">
				<div>ペットナンバー</div> <!-- 펫 넘버 -->
				<div id="petNumber">${member.petNumber}</div>
				<div class="arrow-box">
					<img class="arrow" onclick="clickArrow(this)" alt="" src="${pageContext.request.contextPath}/images/angle-right-solid.svg">
				</div>
			</div>
			<div class="petNumber-edit-form" style="display: none;">
				<div>NEWペットナンバーを入力してください。</div>
				<div>
					<input type="text" placeholder="${member.petNumber}">
					<button onclick="chgPetNumber(this)">変更</button>
				</div>
			</div>
		</div>
		<hr>		
	
		<!-- neutering -->
		<div class="member-info_neutering">
			<div class="flex-box-form">
				<div>中性花</div> <!-- 중성화 -->
				<input type="text" id="neutering" value="${ member.neutering }" style="display: none">
				<div id="neuteringText">
					<c:if test="${ member.neutering eq 0 }">未完了</c:if> <!-- 미완료 -->
					<c:if test="${ member.neutering eq 1 }">完了</c:if>	 <!-- 완료 -->
				</div>
				<div class="arrow-box"> 
					<img class="arrow" onclick="clickArrow(this)" src="${pageContext.request.contextPath}/images/angle-right-solid.svg">
				</div> 
			</div>
			
			<div class="neutering-edit-form" style="display: none;">
				<div>完了したらチェックしてください。</div>
				<div>
					<input type="radio"  name="neuter" value="0" checked>未完了
					<input type="radio"  name="neuter" value="1">完了
					<button onclick="chgNeutering(this)">変更</button>
				</div>
			</div>
		</div>
		<hr>
		
		<!-- address -->
		<div class="member-info_address">
			<div class="flex-box-form">
				<div>郵便番号</div> 	<!-- 우편번호, 주소 -->
				<div id="address">${member.address}</div>
				<div class="arrow-box">
					<img class="arrow" onclick="clickArrow(this)" alt="" src="${pageContext.request.contextPath}/images/angle-right-solid.svg">
				</div>
			</div>
			<div class="address-edit-form" style="display: none;">
				<div>変更する名前を入力してください。</div>
				<div>
					<div>
						<input type="button" onclick="daumPostcode()" value="郵便番号検索" class="btn btn-light"> <br> <!-- 우편번호 검색 -->
						<input type="text" id="postcode" placeholder="郵便番号" >  		  <!-- 우편번호 -->
						<input type="text" id="roadAddress" placeholder="道路名住所" > 	  <!-- 도로명주소 -->
						<input type="text" id="jibunAddress" placeholder="地番"> 	 		  <!-- 지번주소 -->
						<span id="guide" style="color: #999; display: none"> </span> 
						<input type="text" id="detailAddress" placeholder="詳細住所 " >	 	  <!-- 상세주소 -->
					</div>
					<button onclick="chgAddress(this)">変更</button>
				</div>
			</div>
		</div>
		<hr>
		
		<!-- breedIdx -->
		<div class="member-info_breedIdx">
			<div class="flex-box-form">
				<div>種類</div>
				<div id="breedIdx" style="display: none;">${member.breedIdx}</div>
				<div id="dogType">
					<c:forEach items="${breedList}" var="breed">
						<c:if test="${breed.breedIdx eq member.breedIdx}"> ${breed.dogType} </c:if>
					</c:forEach>
				</div>
				<div class="arrow-box">
					<img class="arrow" onclick="clickArrow(this)" alt="" src="${pageContext.request.contextPath}/images/angle-right-solid.svg">
				</div>
			</div>
			
			<div class="breedIdx-edit-form" style="display: none;">
				<div>犬種を入力または選択してください。</div>	<!-- 견종을 입력 또는 선택해주세요. -->
				<div>
					<div id="breedContainer">
						<input type="text" id="breed" name="breedIdx" list="breedList" placeholder="犬種入力" > <!-- 견종을 입력해주세요. -->
						<datalist id="breedList">
							<c:forEach items="${breedList}" var="breed">
								<option data-value="${breed.breedIdx}" value="${breed.dogType}"></option>
							</c:forEach>
						</datalist>
					</div>
			
					<button onclick="chgBreed(this)">変更</button>
				</div>
			</div>
		</div>
		<hr>
			
		<!-- hashtags -->
		<div class="member-info_hashtags">
			<div class="flex-box-form">
				<div>ハッシュタグ</div>	<!-- 해시태그 -->
				<div id="tags">
					<c:if test="${hashtags eq null }"><div id="noTags">登録されたハッシュタグ情報がありません。</div></c:if> <!-- 등록된 해시태그 정보가 없습니다. -->
					<c:if test="${hashtags ne null }"> 
						<span id="tagBox">
							<c:forEach items="${hashtags}" var="tagInfo">
								<span class="hashtagIdx" style="display: none;">${tagInfo.hashtagIdx}</span>
								<span class="tag">#${tagInfo.tag}</span>
							</c:forEach>
						</span>
					</c:if> 
				</div>
				<div class="arrow-box" id="showHashList">
					<img class="arrow" onclick="clickArrow(this)" alt="" src="${pageContext.request.contextPath}/images/angle-right-solid.svg">
				</div>
			</div>
			
			<div class="hashtags-edit-form" style="display: none;">
				<div>ご希望のハッシュタグをチェックしてください。</div>		<!-- 원하시는 해시태그를 체크해주세요. -->
				<div id="basic-tag-list">
					<c:forEach items="${basicTagList}" var="btag" >
						<c:set var="i" value="${i+1}"/>
						<label for="tag${i}">${btag.tag}</label>
						<input id="tag${i}" type="checkbox" name="tagInfo" value="${btag.hashtagIdx}" >
					</c:forEach>
					<button onclick="chgTags(this)">変更</button>
				</div>/
			</div>
		</div>
		<hr>
		<div>
			<button onclick='location.reload()'>修正キャンセル</button> <!-- 수정취소 -->
			<button onclick="editAjax()">修正完了</button> <!-- 수정완료 -->
		</div>
		
	</div> <!-- CONTENT DONE -->

</body>
<style>
	.info-form div{
		display: flex;
	}	
	.info-form div div{
		width: 33%;
	}
		
	.flex-box-form {
		display: flex;
	}
	.flex-box-form div:first-child{
		width: 33%;
	}	
	.arrow-box{
		width: 50px;
		margin-left: auto;
	}
	
	/* 수정버튼 누르기 전까지는 숨김 */
	.arrow {
		display: none;
		width : 12px;
	}
</style>
<script>
	// 30번 라인. 수정버튼 눌렀을 때, 화살표들이 none > block 
	function showArrow(){
		const arrowList = document.querySelectorAll(".arrow");
		arrowList.forEach( item => item.style.display = "block");
	}
	
	/*
		유저가 화살표를 누르면,
		화살표 경로가 바뀐다 = 방향이 바뀜(아래)
		form의 display가 none에서 block으로 변하면서 보여진다.
		! 구조를 주의해야함 sibling을 사용했기 떄문
		
		search(a) 	  : 검색하려는 문자가 존재할 시, index반환. 없을 시 -1
		replace(a, b) : a의 문자가 존재할 시, b로 교체  
	*/
	function clickArrow(item){
		if(item.src.search("right") > 0 ){
			item.src = item.src.replace("right","down");								// 화살표 경로 변경
			item.parentNode.parentNode.nextSibling.nextSibling.style.display = "block"; // 변경시 보여지기
		} else {
			item.src = item.src.replace("down","right");								// 화살표 경로 변경
			item.parentNode.parentNode.nextSibling.nextSibling.style.display = "none";  // 변경시 사라지기
		}
	}
	
	// 유저가 이름 변경을 클릭했을 때 이름을 변경함
	function chgName(item){
		const editForm = item.parentNode.parentNode;
		const name = item.previousSibling.previousSibling.value;  // 변경한 이름
		name.length > 0 ? $("#name").text(name) : console.log("변경하실 이름이 없습니다.");
		editForm.style.display = "none"; 		 				  // 수정 후 form none으로
		$(".member-info_name div img").attr("src","${pageContext.request.contextPath}/images/angle-right-solid.svg");
	} 
	
	// 변경할 사진 이미지 미리보기
	function readURL(input) {
	  if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = (e)	=>	document.getElementById('preview').src = e.target.result;
	    reader.readAsDataURL(input.files[0]);
		$("#profile-btn").attr("display","block");
	  } else {
	    document.getElementById('preview').src = "";
	  }
	}
	
	// 프로필 변경 함수
	function chgProfile(item){
		const profileForm = item.parentNode;
		const arrow = document.querySelector(".member-info_profile .arrow");
		const src = document.getElementById('preview').src;
		
		// 변경할 사진지 존재 할 경우, 선택한 이미지로 변경
		if(src.length > 0 ){
			$("#showImg").attr("src",document.getElementById('preview').src); 
			$("#profile")[0].files = $("#member-profile")[0].files;				// 파일 저장하기 
		} else {
		    console.log("변경하실 사진이 없습니다.");
		}
		
		// 완료 시 none
		profileForm.style.display = "none";
		arrow.src = arrow.src.replace("down","right");
	}
	
	// 유저가 날짜 변경을 클릭했을 때 이름을 변경함
	function chgDay(item){
		const dateForm = item.parentNode.parentNode;
		const date = item.previousSibling.previousSibling.value;  // 변경한  날짜
		
		// 제대로 날짜 선택을 하였다면, 선택한 날짜로 변경
		date.length > 0 ? $("#birthday").text(date) : console.log("선택하지 않았습니다.");
		
		// 수정 후 form none으로
		dateForm.style.display = "none"; 		 				 
		$(".member-info_birth div img").attr("src","${pageContext.request.contextPath}/images/angle-right-solid.svg");
	} 

	// 유저가 성별 변경을 클릭했을 때 이름을 변경함
	function chgSex(item){
		const sexForm = item.parentNode.parentNode;
		const sex = $("input[name='sex']:checked").val();
		const sexText = sex > 0 ? "男" : "女";
		$("#sex").val(sex);
		$("#sexText").text(sexText);
		sexForm.style.display = "none"; 		 				 
		$(".member-info_sex div img").attr("src","${pageContext.request.contextPath}/images/angle-right-solid.svg");
	} 
	
	// 유저가 펫 넘버 변경을 클릭했을 때 이름을 변경함
	function chgPetNumber(item){
		const petNumberForm = item.parentNode.parentNode;
		const petNumber = item.previousSibling.previousSibling.value;  // 변경한 이름
		
		//변경할 텍스트가 있을 시, 
		petNumber.length > 0 ? $("#petNumber").text(petNumber) : console.log("변경하실 펫넘버가 없습니다.");
		petNumberForm.style.display = "none"; 		 				  // 수정 후 form none으로
		$(".member-info_petNumber div img").attr("src","${pageContext.request.contextPath}/images/angle-right-solid.svg");
	} 

	// 유저가 중성화 변경을 클릭했을 때 이름을 변경함
	function chgNeutering(item){
		const neuteringForm = item.parentNode.parentNode;
		const neutering = $("input[name='neuter']:checked").val();
		const neuteringText = neutering > 0 ? "完了" : "未完了";
		$("#neutering").val(neutering);
		$("#neuteringText").text(neuteringText);
		neuteringForm.style.display = "none"; 		 				 
		$(".member-info_neutering div img").attr("src","${pageContext.request.contextPath}/images/angle-right-solid.svg");
	} 

	// 유저가 주소변경을 클릭했을 때 이름을 변경함
	function chgAddress(item){
		const addressForm = item.parentNode.parentNode;
		const address = $("#roadAddress").val() +" "+ $("#detailAddress").val();
		
		//변경할 텍스트가 있을 때만 변경
		$("#postcode").val().length > 0 ? $("#address").text(address) : console.log("변경하실 주소가 없습니다.");
		addressForm.style.display = "none"; 		 				 
		$(".member-info_address div img").attr("src","${pageContext.request.contextPath}/images/angle-right-solid.svg");
	} 

	// 유저가 견종 변경을 클릭했을 때 이름을 변경함
	function chgBreed(item){
		const breedForm = item.parentNode.parentNode;
		const breed = $('#breed').val();
		const breedIdx = $("#breedList option[value="+"'"+breed+"'"+"]")[0].dataset.value;
			
		//변경할 텍스트가 있을 때만 변경
		if(breed.length > 0){
			console.log(breed)
			$("#breedIdx").text(breedIdx);
			$("#dogType").text(breed);
		}
		breedForm.style.display = "none"; 		 				 
		$(".member-info_breedIdx div img").attr("src","${pageContext.request.contextPath}/images/angle-right-solid.svg");
	} 

	// 유저가 해시태그 변경을 클릭했을 때 이름을 변경함
	function chgTags(item){
		const hashtagForm = item.parentNode.parentNode;
		const selectedTagList = $("#basic-tag-list input[name=tagInfo]:checked");
		const tags = $("#tags");
		const tagBox = $("#tagBox");
		
		tagBox.html("");
		if(!selectedTagList.length > 0){
			tags.append("<span>登録されたハッシュタグ情報がありません。</span>")			
		} else {
			for (var i = 0; i < selectedTagList.length; i++) { 
				tagBox.append('<span class="hashtagIdx" style="display: none;">'+selectedTagList[i].value+'</span>')		
				tagBox.append('<span class="tag">#'+selectedTagList[i].labels[0].innerText+'</span>')		
			}
			
		}
		
		hashtagForm.style.display = "none"; 		 				 
		$(".member-info_hashtags div img").attr("src","${pageContext.request.contextPath}/images/angle-right-solid.svg");
	} 
	
	// 유저가 해시태그 화살표를 눌렀을때 발생
	$("#showHashList").on("click",function(){
		const memberHashtags = $("#tagBox .hashtagIdx");
		const basicTagList   = $("#basic-tag-list input[name=tagInfo]");
		
		// 유저의 해시태그가 존재할 경우만
		if(document.querySelector("#noTags") == null){
			for (var i = 0; i < memberHashtags.length; i++) {
				const memberTag = memberHashtags[i];
				for (var i = 0; i < basicTagList.length; i++) {
					const basicTag = basicTagList[i];
					const memberTagIdx = memberTag.innerText;
					const basicTagIdx = basicTag.value;

					if( memberTagIdx === basicTagIdx){
						basicTag.checked = "true";
						break;
					}
				}
			}
		}
	});
	
	// 유저가 선택한 해시태그 아이디를 리스트형태로 반환;
	function getHashtagList(){
		let tagIdxList = [];
		
		$('.hashtagIdx').each(function( index, tag ){
			tagIdxList.push(tag.innerText);
		});
		return tagIdxList;
	}
	
	// 유저의 프로필 값을 반환.
	function getProfileData(){
		// null 값은 유저가 프로필 변경을 하지 않았을 경우
		return $('#profile')[0].files == undefined ? " " : $('#profile')[0].files[0];
	}
	
	// 수정완료 버튼 누를 시, ajax를 통해 수정한 데이터 전달 후 페이지 새로고침
	function editAjax(){
		
		const formData = new FormData();
		formData.append("name"	   , $("#name").text());		// name
		formData.append("profile"  , getProfileData());			// profile											// profile
		formData.append("birthday" , $("#birthday").text());	// birthday
		formData.append("sex"	   , $('#sex').val());			// sex
		formData.append("petNumber", $("#petNumber").text());	// petNumber
		formData.append("neutering", $("#neutering").val());	// neutering
		formData.append("address"  , $("#address").text());		// address
		formData.append("breedIdx" , $("#breedIdx").text());	// breedIdx
		formData.append("hashtags" , getHashtagList());			// hashtags
		formData.append('_method', 'put');
	
		//for(var value of formData.values()){	console.log(value);}; 	//데이터 확인
		
		$.ajax({
			url : '/hgs/member/'+ `${logger.memberIdx}`,
			type : 'post',
			data : formData,
			processData : false,
			contentType : false,
			cache: false,
		}).done(function(){
			console.log("ok");
			//location.href = "/hgs/member/mypage";
		}).fail(function(){
			console.log("no");
		});
		
	};
	
	function askDelete(){
		var result = confirm("本当に削除しますか"); // 정말 삭제하시겠습니까?
		result == true ?  deleteMember() : console.log("cancle");	
	}
	
	function deleteMember(){
		$.ajax({
			url : '/hgs/member/'+ `${logger.memberIdx}`,
			type : 'delete',
		}).done(function(data){
			location.href = data;
		}).fail(function(){
			console.log("노노")
		})
	}
	
</script>
<script src="${pageContext.request.contextPath}/js/api/address.js"></script>
<script>
// 	console.log(${member.address})
</script>
</html>