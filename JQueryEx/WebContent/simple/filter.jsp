<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>필터 선택자</h2>
<script type="text/javascript">
	$(document).ready(
		function() {
			$('th:odd').css('background', 'lightgray');
			$('th:even').css('color', 'red');
			$('th:odd:even').css('background', 'gray');
			$('th:even:odd').css('background', 'pink');
			$('th:first').css('color', 'green');
			$('th:last').css('color', 'green');
			$('th:odd:first, th:even:last').css('color', 'green');
			$('th, tr').css({'color':'black', 'background':'white'});
			$('th, tr').css({'color':'black', 'background':'white'});
			$('th:contains(5)').css('background', 'gray');
			$('th:eq(49)').css('background', 'red');
			$('th:ne(40)').css('background', 'yellow');
			$('th:gt(60)').css('background', 'pink');
			$('th:nth-child(3n+2)').css('color', 'blue');
		}
	);
</script>
<table border="1">
	<%
		int cnt=0;
		for(int i=0; i<10; i++) {
			%>
			<tr>
			<%
				for(int j=0; j<10; j++) {
					%>
					<th width="50" height="50"><%=cnt++%></th>
					<%
				}
			%>
			</tr>
		<%
		}
	%>
</table>