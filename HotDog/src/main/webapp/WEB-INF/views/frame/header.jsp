<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg fixed-top navbar-light bg-light">

  <a class="navbar-brand mr-auto mr-lg-0" href="${pageContext.request.contextPath}">핫 개 수</a>
  
  <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="navbar-collapse offcanvas-collapse ml-4" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
    	
	    <li class="nav-item">
	    	<a class="nav-link" href="${pageContext.request.contextPath}/member/reg">회원 가입</a>
	    </li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/member/manager/list">회원 리스트</a></li>
		<li class="nav-item">
		
		
		<c:if test="${empty logger}">
		<li class="nav-item">
		<a class="nav-link" href="${pageContext.request.contextPath}/member/login">로그인</a></li>
		</c:if>
		
		<c:if test="${not empty logger}">
		<li class="nav-item">
		<a class="nav-link" href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
		</c:if>
	    
    
      <!-- <li class="nav-item active">
        <a class="nav-link" href="#">Dashboard <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Notifications</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Profile</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Switch account</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-expanded="false">Settings</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li> -->
    </ul>
    
    <div>
    <c:if test="${empty logger}">
			<a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/member/login">login</a>
		</c:if>

		<c:if test="${not empty logger}">
			<table>
				<tr>
					<td><img class="rounded" src="${pageContext.request.contextPath}/uploadfile/${logger.profile}" style="height:25px;width:25px;"></td>
					<td>
					<span  class="text-warning">${logger.name}(${logger.email})</span> 
					<a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/member/logout">logout</a>
					</td>
				</tr>
			</table>


		</c:if>
    </div>
    
    <!-- <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form> -->
    
  </div>
</nav>
