<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<script src="${project}script.js"></script>
<h2>${page_login}</h2>
<c:if test="${result eq 0}">
	<script type="text/javascript">
		erroralert(loginiderror);
	</script>
</c:if>
<c:if test="${result eq -1}">
	<script type="text/javascript">
		erroralert(loginpasswderror);
	</script>
</c:if>
<c:if test="${result eq 1}">
	${sessionScope.memid=id}
	<c:redirect url="main.do"/>
</c:if>