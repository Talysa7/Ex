<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mb/setting.jsp"%>
<link rel="stylesheet" type="text/css" href="${project}style_board.css">
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Sunflower:300">
<script src="${projectBoard}/script.js"></script>
<h2>${page_list}(${str_count}:${count})</h2>
<table>
	<tr>
		<th colspan="6" align="right">
			<a href="writeForm.do">${str_write}&nbsp;&nbsp;&nbsp;</a>
		</th>
	</tr>	
	<tr>
		<th style="width :5%">${str_num}</th>
		<th style="width :35%">${str_subject}</th>
		<th style="width :10%">${str_writer}</th>
		<th style="width :15%">${str_reg_date}</th>
		<th style="width :5%">${str_readcount}</th>
		<th style="width :5%">${str_ip}</th>
	</tr>	
<c:if test="${count eq 0}">
	<tr>
		<td colspan = "6" align="center">${msg_list_x}</td>
	</tr>
</c:if>
<c:if test="${count ne 0}">
	<c:forEach var="i" items="${articles}">
			<tr>
				<td align="center">
				${number}
				<c:set var="number" value="${number-1}"/>
				</td>			
				<td>
					<c:if test="${i.re_level gt 1}">
						<c:set var="wid" value="${(i.re_level-1)*10}"/>
						<img src="${projectBoard}/images/level.gif" border="0" width="${wid}" height="15">
					</c:if>
					<c:if test="${i.re_level gt 0}">
						<img src="${projectBoard}/images/re.gif" border="0" width="20" height="15">
					</c:if>
					<a href ="content.do?num=${i.num}&pageNum=${pageNum}&number=${number+1}">
					${i.subject}
					</a>
					<c:if test="${i.readcount ge 20}">
						<img src="${projectBoard}/images/hot.gif" border="0" width="20" height="15">
					</c:if>					
				</td>				
				<td align="center">${i.writer}</td>				
				<td align="center">
					<fmt:formatDate value="${i.reg_date}" pattern="yyyy-MM-dd HH:mm"/>
				<td align="center">${i.readcount}</td>
				<td align="center">${i.ip}</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<br>
<c:if test="${count gt 0 }">
	<c:if test="${startPage gt pageBlock}">
			<a href="list.do">[◀◀] </a>
			<a href="list.do?pageNum=${startPage-pageBlock}">[◀] </a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<c:if test="${i eq currentPage}">
			<b>[${i}]</b>
		</c:if>
		<c:if test="${i ne currentPage }">
				<a href="list.do?pageNum=${i}">[${i}] </a>
		</c:if>
	</c:forEach>
	<c:if test="${pageCount gt endPage}">
		<a href ="list.do?pageNum=${startPage+pageBlock}">[▶]</a>
		<a href ="list.do?pageNum=${pageCount}">[▶▶]</a>
	</c:if>
</c:if>