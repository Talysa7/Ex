<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_board.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${projectBoard}/script.js"></script>
<h2>${page_content}</h2>
<table>
	<tr>
		<th>${str_number}</th>		
			<td align="center">${number}</td>
		<th>${str_readcount}</th>
			<td align ="center">${boardDto.readcount}</td>
	</tr>	
	<tr>
		<th>${str_writer}</th>
			<td align="center">${boardDto.writer} </td>
		<th> ${str_reg_date} </th>
			<td align="center">
				<fmt:formatDate value="${reg_date}" pattern="yyyy-MM-dd HH-mm"/>
			</td>
	</tr>
	<tr>
		<th>${str_subject}</th>
			<td colspan="3">${boardDto.subject}</td>
	</tr>	
	<tr>
		<th>${str_content}</th>
			<td colspan="3"> <pre>${boardDto.content}</pre></td>	
	</tr>	
	<tr>
		<th colspan="4">
			<input class="inputbutton" type="button" value="${btn_mod}" 
				onclick="location='modifyForm.do?num=${boardDto.num}&pageNum=${pageNum}'">
			<input class="inputbutton" type="button" value="${btn_delete}"
				onclick="location='deleteForm.do?num=${boardDto.num}&pageNum=${pageNum}'">
			<input class="inputbutton" type="button" value="${btn_reply}"
				onclick="location='writeForm.do?num=${boardDto.num}&ref=${boardDto.ref}&re_step=${boardDto.re_step}&re_level=${boardDto.re_level}'">
			<input class="inputbutton" type="button" value="${btn_list}"
				onclick="location = 'list.do?=pageNum=${pageNum}'">
		</th>
	</tr>		
</table>