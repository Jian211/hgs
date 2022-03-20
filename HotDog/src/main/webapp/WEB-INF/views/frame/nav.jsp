<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="nav">
	<div class="nav_logoAndSearch">
		<div>
			<a href="/hgs/home">
				<img src="http://localhost:8080/hgs/images/hgs_logo.png">
			</a>
		</div>
		<div>
			핫한 개들의 수다!
		</div>
	</div>

	<div class="nav_container">
		<div>
			<a href="/hgs/board/list">커뮤니티</a>
		</div>
		<div>
			<a href="#">이벤트</a>
		</div>
		<div>
			<a href="/hgs/place/list">추천장소</a>
		</div>
	</div>
	
	<div class="nav_user-container">
		<div class="cntr">
			<div class="cntr-innr">
			 	<label class="search" for="inpt_search">
					<input id="inpt_search" type="text" />
				</label>
			</div>
		</div>
<!-- 		<img class="mypage" src="/hgs/images/user-solid.svg" > -->
		<div onclick="showMypage()"><img class="mypage" src="/hgs/images/user-solid.svg" ></div>
		<div onclick="logout()"><img src="/hgs/images/right-from-bracket-solid.svg" ></div>
<!-- 		<a href="#"><img src="/hgs/images/right-from-bracket-solid.svg" ></a> -->
	</div>
</nav>
<hr>
