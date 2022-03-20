<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Weather</title>
<%@ include file="/WEB-INF/views/frame/pageSet.jsp"%>
<meta charset="utf-8">
<script src="http://code.jquery.com/jquery-1.7.min.js"></script>
</head>
<script>

// $API_KEY = "f25a266c07e9c4b842b6386b1068e10a";

const COORDS = "coords";

function getWeather(lat, lon) {
    fetch("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=f25a266c07e9c4b842b6386b1068e10a&units=metric")
        .then(res => res.json())
        .then(data => {
            console.log(data);
            const now = new Date($.now());
            const temp = data.main.temp;
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
                $('.recomm').append("산책하기 좋은 날씨에요");
            } else {
                $('.recomm').append("산책하기엔 안좋은 날씨에요");
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

<body>
    <h1>Weather API</h1>
    <h2> 날씨 정보</h2>
    <div class="cicon"> </div>
    <div class="local"> 현재 위치 : </div>
    <div class="ctemp">현재 온도 : </div>
    <div class="clowtemp">최저 온도 : </div>
    <div class="chightemp">최고 온도 : </div>
    <div class="recomm"> </div>
</body>
</html>