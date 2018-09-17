<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${projectMember}/script.js"></script>
<h2>${page_main}</h2>
<body onload="mainfocus()">
<c:if test="${sessionScope.memid eq null}">
	<form name="mainform" method="post" action="loginPro.do"
		onsubmit="return maincheck()">
		<table>
			<tr>
				<th colspan="2">${msg_main}</th>
			</tr>
			<tr>
				<th>${str_id}</th>
				<td><input class="input" type="text" name="id" maxlength="15"></td>
			</tr>
			<tr>
				<th>${str_passwd}</th>
				<td><input class="input" type="password" name="passwd"
					maxlength="15"></td>
			</tr>
			<tr>
				<th colspan="2">
				<input class="inputbutton" type="submit" value="${btn_login}" onclick=action.do>
				<input class="inputbutton" type="reset" value="${btn_cancel}">
				<input class="inputbutton" type="button" value="${btn_join}" onclick="location='inputForm.do'">
				</th>
			</tr>
		</table>
	</form>
</c:if>
<c:if test="${sessionScope.memid ne null}">
	<table>
		<tr>
			<td><span>${sessionScope.memid}</span>${msg_main_login}</td>
		</tr>
		<tr>
			<th>
				<input class="inputbutton" type="button" value="${btn_modify}" onclick="location='modifyForm.do'"> 
				<input class="inputbutton" type="button" value="${btn_drg}" onclick="location='deleteForm.do'">
				<input class="inputbutton" type="button" value="${btn_logout}" onclick="location='logout.do'">
			</th>
		</tr>
	</table> 
</c:if>
</body>