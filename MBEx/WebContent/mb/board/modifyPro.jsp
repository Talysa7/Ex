<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<script src="${projectBoard}/script.js"></script>
<h2>${page_modify}</h2>
<c:if test="${result eq 0}">
	<script type="text/javascript">
		alert(modifyerror);
	</script>
	<meta http-equiv="refresh" content="0; url=list.do?pageNum=${pageNum}">
</c:if>
<c:if test="${result ne 0}">
	<c:redirect url="list.do?pageNum=${pageNum}"/>
</c:if>