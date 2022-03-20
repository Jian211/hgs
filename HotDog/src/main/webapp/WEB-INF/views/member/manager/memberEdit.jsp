<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result eq 1}">
<script>
	alert('수정되었습니다.');
	location.href = '${pageContext.request.contextPath}/member/manager/memberList.do';
</script>
</c:if>

<c:if test="${result eq 0}">
<script>
	alert('수정이 실패했습니다. 다시 확인해주세요.');
	history.go(-1);
</script>
</c:if>
