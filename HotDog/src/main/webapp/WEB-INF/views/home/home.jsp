<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html>
<head>
	<meta charset="utf-8">
	<title>Weather</title>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp"%>
	<link rel="stylesheet" href="css/home.css" />
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c3d33077d50916de6b6521acf72299f7&libraries=services"></script>
</head>

<body>
	<!-- Top nav Bar -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	
	<!-- 서치 결과, 이걸 include하믄 좋은디 머리가 안돌아간다. -->
	<div class="search-container" id="search-container" style="display: none"  >
	</div>
	
	<div>${allPlaces}</div>
	<div class="home" style="display: block">
		<!-- 날씨데이터  -->
		<div class="weather">
			<div>
				<span class="weather_date" id="today"></span>
				<span class="weather_temp">현재 </span>
				<span class="ctemp"></span>
				<span class="weather_temp">도 입니다.</span>
			</div>
			<div class="comment">
				<!-- <span class="cicon"></span> -->
				<span class="recomm"></span>
			</div>
			<!-- 
				<h1>Weather API</h1>
				<h2>날씨 정보</h2> 
				<div class="local">현재 위치 :</div> 
				<div class="clowtemp">최저 온도 :</div> 
				<div class="chightemp">최고 온도 :</div>
			 -->
		</div>
	
		<div class="main-container">
			<!-- 지도 위에  유저의 스크랩한 장소들을 표시하기 -->
			<div>
				<div class="logger-map-container standard-box box-outside">
					<div class="logger-map_location-text" style="font-size: 22px; padding : 0 10px 10px;">현재위치 및 스크랩장소 정보</div>
					<div class="">
						<div id="map" style="width: 500px; height: 460px; border-radius: 20px"></div>
					</div>
				</div>
	
				<!--  QnA -->
				<div class="qna box-outside" onclick="qnaLink()">
					<div class="qna_text">${logger.name}야</div>
					<div class="qna_text">궁금한게 있니?</div>
					<div class="qna_text">날 눌러!</div>
					<img style="width: 180px;  float:right;  padding: 50px 5px;" alt="" src="	https://www.kakaocorp.com/page/bg_home_service.png">	
				</div>
			
			</div>
					
			<div class="board-container">
				<c:forEach items="${HomeBoard}" var="board" > 
					<div class="board medium-box box-outside" onclick="boardDetail(${board.boardIdx})">
						<div class="board_top-nav">
							<div class="board_top-nav-img"><img alt="" src="${pageContext.request.contextPath}/uploadfile/${board.profile}"></div>
							<div class="board-top-nav-member">
								<div>${board.name}</div>
								<div>${board.createDate}시간 전</div>
							</div>
						</div>
						<img class="board-img" alt="" src="${pageContext.request.contextPath}/uploadfile/${board.fileName}">
						<div class="board-content">
							<div class="board-tagLikes">
								<div>${board.tags}</div>
								<div>
									<!-- <img alt="" src="images/heart-solid.svg" style="width:16px; color:red"> -->
									좋아요 ${board.likes}
								</div>
							</div>
							<div>${board.content}</div>
						</div>
					</div>
				</c:forEach>	
			</div>
		
			<div class="place-container">
				<c:forEach items="${HomePlace}" var="place">
					<div class="box-outside place" onclick="placeDetail(${place.placeIdx})" >
						<div class="place_cate">#${place.subjectCategory}</div>
						<div class="place_title">${place.title}</div>
						<div class="place_address">${place.newAddress}</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>	
</body>
<script>
// 	$(".mypage").on("click",function(){
		
// 		$.ajax({
// 			url :"/hgs/member",
// 			data : { "idx" : ${logger.memberIdx} },
// 			type :"get",
// 		}).done(function(data){
// 			console.log("성거ㅗㅇ입니다")
// 			console.log(data)
// 			location.href = ""
			
// 		}).fail(function(){
// 			console.log("실패입니다")
// 		});
// 	})
</script>

<script>

	// 보드 디테일로 이동
	function boardDetail (idx){
		location.href = '/hgs/board/view/?boardIdx='+idx;		
	}
	
	// place 디테일로 이동
	function placeDetail (idx){
		location.href = '/hgs/place/view/?placeIdx='+idx;		
	}
	
	// Qna로 이동
	function qnaLink(){
		console.log("qna이동!")		
		//location.href = '/hgs/qna;
	}
	
</script>

<script type="text/javascript">  // 검색 관련 스크립트
	$("#inpt_search").on('focus', function () {
		$(this).parent('label').addClass('active');
	});
	
	$("#inpt_search").on('blur', function () {
		if($(this).val().length == 0)
			$(this).parent('label').removeClass('active');
	});
	
	var searchList = [];
	// 검색 시, ajax 실행
	$("#inpt_search").keydown(function(event){
		if(event.keyCode == 13){ // 13은 js에서 엔터키를 의미한다.
			$.ajax({
				url :"search",
				data : {'q' : $("#inpt_search").val()},
				type : "post"
			}).done(function(data){
				$("#search-container").empty();
				var html = jQuery('<div>').html(data); 
				var contents = html.find("#searchBox").html(); 
				$("#search-container").append(contents)				
				
				// 보이고 안보이고~
				$(".home").css("display","none");
				$(".search-container").css("display","block");
				
				// 검색 창 클리어
				$("#inpt_search").val("");
				
			}).fail(function(){
				console.log("실패")
			});
		
		}
	})
	
	// 서치 검색 결과 시, 일어날 함수
// 	function searchAfter(list){
// 		const parkList = list.homePark;
// 		const cafeList = list.homeCafe;
// 		const hospitalList = list.homeHospital;
// 		const boardList = list.homeBoard;
		
// 		parkList.forEach(function(item,index,arr2){
// 			$(".board-content").append()
// 		}

// 	}
</script>
<script>

	// $API_KEY = "f25a266c07e9c4b842b6386b1068e10a";
	
	const COORDS = "coords";
	
	function getWeather(lat, lon) {
	    fetch("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=f25a266c07e9c4b842b6386b1068e10a&units=metric")
	        .then(res => res.json())
	        .then(data => {
	            console.log(data);
	            const now = new Date($.now());
	            const temp = parseInt(data.main.temp);
	            const minTemp = data.main.temp_min;
	            const maxTemp = data.main.temp_max;
	            const wIcon = data.weather[0].icon;
	            const date = now.getFullYear() + '/' + (now.getMonth() + 1) + '/' + now.getDate() + '/' + now.getHours() + ' ';
	            const weathers = data.weather[data.weather.length - 1];
	            const city = data.name;
	            const description = data.weather[0].main;
				
	            $('.local').append(city);
	            $('.clowtemp').append(minTemp);
	            $('.ctemp').append(temp);
	            $('.chightemp').append(maxTemp);
	            $('h2').prepend(date);
	            $('.cicon').append('<img src="http://openweathermap.org/img/w/' + wIcon + '.png" />')
	            
	            if(description == "Clear" && description == "Clouds") {
	                $('.recomm').append("산책하기 좋은 날씨에요!");
	            } else {
	                $('.recomm').append("주인님에게 한번 나가자구 해볼까요?");
	            }
			
	        });
	}
	
	
	function saveCoords(coordsObj) {
	    localStorage.setItem(COORDS, JSON.stringify(coordsObj));
	}
	
	function handleGeoSucc(pos) {
	    const latitude = pos.coords.latitude;
	    const longitude = pos.coords.longitude;
	    const coordsObj = {
	        latitude,
	        longitude
	    };
	    
	    saveCoords(coordsObj);
	    getWeather(latitude, longitude);
	}
	
	function handleGeoErr(err) {
	    console.log("에러! : 위치정보를 확인할 수 없습니다" + err)
	}
	
	function requestCoords() {
	    navigator.geolocation.getCurrentPosition(handleGeoSucc, handleGeoErr);
	}
	
	function loadCoords() {
	    const loadedCoords = localStorage.getItem(COORDS);
	    if (loadedCoords == null) {
	        requestCoords();
	    } else {
	        const parseCoords = JSON.parse(loadedCoords);
	        getWeather(parseCoords.latitude, parseCoords.longitude);
	    }
	}
	
	function init() {
	    loadCoords();
	}
	
	init();
</script>
<script>
	// 카카오 지도 API
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨 
    }; 

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        
	        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px;">${logger.name}야~</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	     
	    })
	       
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할수 없어요..'
	        
	    displayMarker(locPosition, message);
	}
	
	// 지도에 마커와 인포윈도우를 표시하는 함수입니다
	function displayMarker(locPosition, message) {
	
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({  
	        map: map, 
	        position: locPosition
	    }); 
	    
	    var iwContent = message, // 인포윈도우에 표시할 내용
	        iwRemoveable = true;
	
	    // 인포윈도우를 생성합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content : iwContent,
	        removable : iwRemoveable
	    });
	    
	    // 인포윈도우를 마커위에 표시합니다 
	    infowindow.open(map, marker);
	    
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition);      
	}    
	
	
	
	
</script>
<script>
   /*
	var homeScrapList = [];
	//현재 위치 기반으로 주변 정보(카페,병원 등) 데이터를 받아오기
	if (navigator.geolocation) {
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	         
	 		// 위도와 경도로 주소를 찾는 메소드
	   		var geocoder = new kakao.maps.services.Geocoder();
	   		var coord = new kakao.maps.LatLng(lat, lon);
	   	
	   		var callback = function(result, status) {
	   		    if (status === kakao.maps.services.Status.OK) {
	   		    	var maker = result[0].address;
	   		    	address = maker.region_1depth_name+" "+maker.region_2depth_name; //+" "+maker.region_3depth_name;
						
	   		    	$.ajax({
	   		    		url :"home/places",
	   		    		data :{
	   		    			'address': address
	   		    		},
	   		    		contentType :'application/json; charset=UTF-8',
	   		    		type :"get"
	   		    	}).done(function(data){
	   		    		
	   		    		// 배열에 데이터 삽입
	   		    		for (var i = 0; i < data.length; i++) {
 		   		    		homeScrapList.push(JSON.stringify(data))
						}
	   		    		console.log("homeScrapList = "+ homeScrapList)
	   		    	}).fail(function(){
	   		    		console.log("유저의 스크랩 정보를 찾지 못했습니다.")
	   		    	});
	   		    }
	   		};
	   		geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
	   		
		})
	}
	
	// 받은 데이터를 배열 형식으로 변환하는 함수
	function insertJsonData(data){
		console.log(data)
		for (var i = 0; i < array.length; i++) {
			var array_element = array[i];
			
		}
	}
	*/
	
	// 마커를 표시할 위치와 title 객체 배열입니다 
	// 여기다가 유저가 좋아하는 것들을 받아오기
	
	var placeList = [];  // 여기에 서버에서 받은 데이터를 저장하기위한 변수
	
	for (var i = 0; i < ${scraps}.length; i++) {
		var place = {
			title : ${scraps}[i].title,
			latlng: new kakao.maps.LatLng(${scraps}[i].latitude, ${scraps}[i].longitude)
		}
		placeList.push(place);
	}
	
	// 마커 이미지의 이미지 주소입니다  별포 마크 ( 스크랩 한 가게들 알려주는 마크 )
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	    
	for (var i = 0; i < placeList.length; i ++) {
	    
	    // 마커 이미지의 이미지 크기 입니다
	    var imageSize = new kakao.maps.Size(24, 35); 
	    
	    // 마커 이미지를 생성합니다    
	    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	    
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: placeList[i].latlng, // 마커를 표시할 위치
	        title : placeList[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
	        image : markerImage // 마커 이미지 
	    });
	}
	
</script>

</html>