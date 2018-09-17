<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<script src="${projectMember}/script.js"></script>
<h2>${page_delete}</h2>
<c:if test="${result eq 1}">
	<c:if test="${result eq 0}">
		<script type="text/javascript">
			alert(deleteerror);
		</script>
		<meta http-equiv="refresh" content="0; url='main.do'">
	</c:if>
	<c:if test="${result ne 0}">
			${sessionScope.memid=id}
			<c:redirect url="main.do"/>
	</c:if>
</c:if>
<c:if test="${result ne 1}">
	<script type="text/javascript">
		erroralert(loginpasswderror);
	</script>
</c:if>