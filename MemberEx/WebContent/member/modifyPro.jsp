<%@page import="member.LogonDataBean"%>
<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<script src="${project}script.js"></script>
<h2>${page_mod}</h2>
<c:if test="${result eq 0}">
	if(result==0) {
		%>
		<script type="text/javascript">
			alert(modifyerror);
		</script>
		<meta http-equiv="refresh" content="0; url=main.do">
</c:if>
<c:if test="${result ne 0}">
	<c:redirect url="main.do"/>
</c:if>