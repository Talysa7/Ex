<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${project}script.js"></script>
<h2>${page_input}</h2>
<body onload="inputfocus()">
	<form name="inputform" method="post" action="inputPro.do" onsubmit="return inputcheck()">
	<input type="hidden" name="confirm" value="0">
		<table>
			<tr>
				<th colspan="2">${msg_input}</th>
			</tr>
			<tr>
				<th>* ${str_id}</th>
				<td>
					<input class="input" type="text" name="id" maxlength="15">
					<input class='inputbutton' type="button" value="${btn_confirm}" onclick="confirmid()">
				</td>
			</tr>
			<tr>
				<th rowspan="2">* ${str_passwd}</th>
				<td><input class="input" type="password" name="passwd" maxlength="15"></td>
			</tr>
			<tr>
				<td><input class="input" type="password" name="repasswd" maxlength="15"></td>
			</tr>
			<tr>
				<th>* ${str_name}</th>
				<td><input class="input" type="text" name="name" maxlength="20"></td>
			</tr>
			<tr>
				<th>* ${str_jumin}</th>
				<td>
					<input class="input" type="text" name="jumin1" maxlength="6" style="width:45px" onkeyup="nextjumin2()">
					- <input class="input" type="text" name="jumin2" maxlength="7" style="width:50px" onkeyup="nexttel1()">
				</td>
			</tr>
			<tr>
				<th>${str_tel}</th>
				<td>
					<input class="input" type="text" name="tel1" maxlength="3" style="width:27px" onkeyup="nexttel2()">
					<input class="input" type="text" name="tel2" maxlength="4" style="width:30px" onkeyup="nexttel3()">
					<input class="input" type="text" name="tel3" maxlength="4" style="width:30px" onkeyup="nextemail1()">
				</td>
			</tr>
			<tr>
				<th>${str_email}</th>
				<td>
					<input class="input" type="text" name="email1" maxlength="15" style="width:80px">
					@<select name="email2">
						<option value="0">${str_manual}</option>
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="nate.com">nate.com</option>
						<option value="google.com">gmail.com</option>
					</select>	
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_join}" onclick="inputcheck()">
					<input class="inputbutton" type="reset" value="${btn_cancle}">
					<input class="inputbutton" type="button" value="${btn_join_cancle}" onclick="location='main.do'">
				</th>
			</tr>
		</table>
	</form>
</body>