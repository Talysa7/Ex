<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${project}script.js"></script>
<h2>${page_login}</h2>
<body onload="loginfocus()">
	<form method="post" action="loginPro.do" name="loginform" onsubmit="return logincheck()">
		<table>
			<tr>
				<th colspan="2">
					${msg_login}
				</th>
			</tr>
			<tr>
				<th>${str_id}</th>
				<td><input class="input" type="text" name="id" maxlength="15"></td>
			</tr>
			<tr>
				<th>${str_passwd}</th>
				<td><input class="input" type="password" name="passwd" maxlength="15"></td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_login}">
					<input class="inputbutton" type="reset" value="${btn_cancle}">
				</th>
			</tr>
		</table>
	</form>
</body>