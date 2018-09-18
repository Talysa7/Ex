<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Session Storage</h2>

<script type="text/javascript">
	function savemsg() {
		var result=document.getElementById("result");
		if(!window.sessionStorage) {
			result.innerHTML+="지원하지 않는 브라우저입니다.<br>";
			return;
		}
		var message=document.getElementById("ta").value;
		var msg=sessionStorage.getItem("msg");
		if(!message) {
			result.innerHTML+="메시지를 입력하세요.<br>";
		} else {
			if(!msg) {
				msg="";
				sessionStorage.setItem("msg", message);
				result.innerHTML+="메시지를 저장했습니다.<br>";	
			} else {
				sessionStorage.setItem("msg", msg+"<br>"+message);
				result.innerHTML+="메시지를 저장했습니다.<br>";				
			}
		}	
	}
	function loadmsg() {
		var result=document.getElementById("result");
		if(!window.sessionStorage) {
			result.innerHTML+="지원하지 않는 브라우저입니다.";
			return;
		}
		var msg=sessionStorage.getItem("msg");
		if(!msg) {
			result.innerHTML+="저장된 내용이 없습니다.<br>";
		} else {
			result.innerHTML+=sessionStorage.getItem("msg")+"<br>";
		}
	}
	function deletemsg() {
		var result=document.getElementById("result");
		if(!window.sessionStorage) {
			result.innerHTML+="지원하지 않는 브라우저입니다.<br>";
			return;
		}
		sessionStorage.removeItem("msg");
		result.innerHTML+="메시지를 삭제했습니다.<br>";
	}
</script>

<form>
	<table border="1">
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="50" id="ta" autofocus placeholder="입력하셈"></textarea></td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" value="저장하기" onclick="savemsg()">
				<input type="button" value="불러오기" onclick="loadmsg()">
				<input type="button" value="삭제하기" onclick="deletemsg()">
			</th>
		</tr>
	</table>
</form>
<br>
<div id="result"></div>