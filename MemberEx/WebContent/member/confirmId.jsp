<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${project}script.js"></script>
<h2>${page_confirm}</h2>
<c:if test="${result eq 0}">
		<table>
			<tr>
				<th>
					<span>${id}</span>${msg_confirm_o}
				</th>
			</tr>
			<tr>
				<th>
					<input class="inputbutton" type="button" value="${btn_ok}" onclick="setid('${id}')">
				</th>
			</tr>
		</table>
</c:if>
<c:if test="${result ne 0}">
<body onload="confirmfocus()">
	<form method="post" name="confirmform" action="confirmid.do" onsubmit="return confirmcheck()">
		<table>
			<tr>
				<th colspan="2">
					<span>${id}${msg_confirm_x}</span>
			</tr>
			<tr>
				<th>${str_id}</th>
				<td><input class="input" type="text" name="id" maxlength="15"></td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_confirm}">
					<input class="inputbutton" type="button" value="${btn_confirm_cancle}" onclick="setcancle()">
				</th>
			</tr>
		</table>
	</form>
</body>
</c:if>