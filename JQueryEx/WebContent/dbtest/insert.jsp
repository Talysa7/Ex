<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:update var="result" dataSource="jdbc/encore">
	insert into dbtest values( ?, ?, ?, ?, sysdate )
	<sql:param value="${param.id}"/>
	<sql:param value="${param.passwd}"/>
	<sql:param value="${param.name}"/>
	<sql:param value="${param.tel}"/>
</sql:update>
<c:if test="${result eq 0}">
	<result>
		<code>error</code>
		<message>잠시 후 다시시도하세요</message>
	</result>
</c:if>    
<c:if test="${result ne 0}">
	<result>
		<code>success</code>
		<message><![CDATA[
			{
				id : '${param.id}',
				passwd : '${param.passwd}',
				name : '${param.name}',
				tel : '${param.tel}'				
			}
		]]>
		</message>
	</result>
</c:if>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    