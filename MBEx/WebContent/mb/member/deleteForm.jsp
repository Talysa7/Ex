<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${projectMember}/script.js"></script>
<h2>${page_delete}</h2>
<body onload="passwdfocus()" onsubmit="passwdcheck()">
	<form method="post" name="passwdform" action="deletePro.do">
		<table>
			<tr>
				<th colspan="2">
					${msg_passwdform}
				</th>
			</tr>
			<tr>
				<th>${str_passwd}</th>
				<td>
					<input class="input" type="password" name="passwd" maxlength="15">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_drg}">
					<input class="inputbutton" type="button" value="${btn_drg_cancle}" onclick="location='main.do'">
				</th>
			</tr>
		</table>
	</form>
</body>