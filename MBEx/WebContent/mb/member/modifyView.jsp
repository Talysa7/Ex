<%@page import="java.text.SimpleDateFormat"%>
<%@page import="member.LogonDataBean"%>
<%@page import="member.LogonDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_member.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${projectMember}/script.js"></script>
<h2>${page_mod}</h2>
<c:if test="${result eq 1}">
	<form method="post" action="modifyPro.do" name="modifyform" onsubmit="return modifycheck()">
		<table>
			<tr>
				<th colspan="2">
					${msg_modify}
				</th>
			</tr>
			<tr>
				<th>${str_id}</th>
				<td>${memberDto.id}</td>
			</tr>
			<tr>
				<th rowspan="2">${str_passwd}</th>
				<td><input class="input" type="password" name="passwd" value="${memberDto.passwd}"maxlength="15"></td>
			</tr>
			<tr>
				<td><input class="input" type="password" name="repasswd" value="${memberDto.passwd}" maxlength="15"></td>
			</tr>
			<tr>
				<th>${str_name}</th>
				<td>${memberDto.name}</td>
			</tr>
			<tr>
			<th>${str_jumin}</th>
			<td>${memberDto.jumin1}-${memberDto.jumin2}</td>
		</tr>
			<tr>
				<th>${str_tel}</th>
				<td>
					<c:if test="${memberDto.tel eq null or memberDto.tel eq ''}">
							<input class="input" type="text" name="tel1" maxlength="3" style="width:27px">
							<input class="input" type="text" name="tel2" maxlength="4" style="width:30px">
							<input class="input" type="text" name="tel3" maxlength="4" style="width:30px">
					</c:if>
					<c:if test="${memberDto.tel ne null and memberDto.tel ne ''}">
						<c:set var="t" value="${fnc:split(memberDto.tel, '-')}"/>
							<input class="input" type="text" name="tel1" maxlength="3" value="${t[0]}" style="width:27px">
							<input class="input" type="text" name="tel2" maxlength="4" value="${t[1]}" style="width:30px">
							<input class="input" type="text" name="tel3" maxlength="4" value="${t[2]}" style="width:30px">
					</c:if>
				</td>
			</tr>
			<tr>
				<th>${str_email}</th>
				<td>
					<c:if test="${memberDto.email eq null or memberDto.email eq ''}">
								<input class="input" type="text" name="email1" maxlength="15" style="width:100px">
								@<input class="input" type="text" name="email2" maxlength="15" style="width:100px">
					</c:if>
					<c:if test="${memberDto.email ne null and memberDto.email ne ''}">
						<c:set var="e" value="${fnc:split(memberDto.email, '@')}"/>
							<input class="input" type="text" name="email1" value="${e[0]}" maxlength="15" style="width:100px">
							@<input class="input" type="text" name="email2" value="${e[1]}" maxlength="15" style="width:100px">
					</c:if>
				</td>
			</tr>
			<tr>
				<th>${str_reg_date}</th>
				<td>
					<fmt:formatDate value="${memberDto.reg_date}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input class="inputbutton" type="submit" value="${btn_mod}">
					<input class="inputbutton" type="reset" value="${btn_cancle}">
					<input class="inputbutton" type="button" value="${btn_mod_cancel}" onclick="location='main.do'">
				</th>
			</tr>
		</table>
	</form>
</c:if>
<c:if test="${result eq -1}">
	<script type="text/javascript">
		erroralert(loginpasswderror);
	</script>
</c:if>