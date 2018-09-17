<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<script src="${projectBoard}/script.js"></script>
<h2>${page_delete}</h2>
<c:if test="${resultCheck eq 0}">
	<script type="text/javascript">
		erroralert(passerror);
	</script>
</c:if>
<c:if test="${resultCheck ne 0}">
	<c:if test="${result eq 0}">
		<script type="text/javascript">
			alert(deleteerror);	
		</script>
		<meta http-equiv="refresh" content="0; url=list.do?pageNum=${pageNum}">
	</c:if>
	<c:if test="${result eq -1}">
		<script type="text/javascript">
			alert( replyerror );	
		</script>
		<meta http-equiv="refresh" content="0; url=list.do?pageNum=${pageNum}">
	</c:if>
	<c:if test="${result ne 0 and result ne -1}">
		<c:redirect url="list.do"/>
	</c:if>
</c:if>