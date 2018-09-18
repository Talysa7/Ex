<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<c:if test="${param.id eq null or param.id eq ''}">
	<sql:query var="rs" dataSource="jdbc/encore">
		select * from dbtest
	</sql:query>	
</c:if>
<c:if test="${param.id ne null and param.id ne ''}">
	<sql:query var="rs" dataSource="jdbc/encore">
		select * from dbtest where id='${param.id}'
	</sql:query>
</c:if>

<result>
	<code>success</code>
	<members> { 
		member : [
			<c:forEach var="row" items="${rs.rows}">
				{
					id : '${row.id}',
					passwd : '${row.passwd}',
					name : '${row.name}',
					tel : '${row.tel}',
					logtime : '${row.logtime}'
				},
			</c:forEach>
		]
	} </members>	
</result>
















    