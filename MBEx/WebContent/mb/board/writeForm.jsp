<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/mb/setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_board.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${projectBoard}/script.js"></script>
<h2>${page_write}</h2>
<body onload="writefocus()">
	<form method="post" action="writePro.do" name="writeform" onsubmit="return writecheck()" >
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="ref" value="${ref}">
		<input type="hidden" name="re_step" value="${re_step}">
		<input type="hidden" name="re_level" value="${re_level}">
		<table>
			<tr>
				<th colspan="2" align="right">
					<a href="list.do">${str_list}&nbsp;&nbsp;&nbsp;</a>
				</th>
			</tr>
			<tr>
				<th>${str_writer}</th>
				<td> <input class="input" type="text" name="writer" maxlength="10"> </td>
			</tr>
			<tr>
				<th>${str_email}</th>
				<td> <input class="input" type="text" name="email" maxlength="30"></td>
			</tr>
			
			<tr>
				<th>${str_subject}</th>
				<td> <input class="input" type="text" name="subject" maxlength="50"></td>
			</tr>
			<tr>
				<th>${str_content}</th>
				<td>
					<textarea name="content" rows="10" cols="41"></textarea>
				</td>
			</tr>
			<tr>
				<th>${str_passwd}</th>
				<td>
					<input class="input" type="password" name="passwd" maxlength="12"></td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_write}">
					<input class="inputbutton" type="reset" value="${btn_cancel}">
					<input class="inputbutton" type="button" value="${btn_list}" onclick="location='list.do'">
				</th>
			</tr>
		</table>
	</form>
</body>
