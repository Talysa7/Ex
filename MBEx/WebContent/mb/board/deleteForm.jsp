<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_board.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${projectBoard}/script.js"></script>
<h2>${page_delete}</h2>
<body onload="passwdfocus()">
	<form method="post" action="deletePro.do" name="passwdform" onsubmit="return passwdcheck()">
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<table>
			<tr>
				<th colspan="2">
					${msg_passwd}
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
					<input class="inputbutton" type="submit" value="${btn_del}">
					<input class="inputbutton" type="button" value="${btn_del_cancel}"
						onclick="location='list.do?pageNum=${pageNum}'">
				</th>
			</tr>
		</table>
	</form>
</body>