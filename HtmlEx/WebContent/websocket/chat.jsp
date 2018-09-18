<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/HtmlEx/websocket/style.css">
<script src="/HtmlEx/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(
		function() {
			var ws=null;
			if(!window.WebSocket) {
				$('#result').html('지원하지 않는 브라우저입니다.<br>');
				return ;
			} else {
				ws=new WebSocket("ws://192.168.0.83:8080/HtmlEx/websocket/chat");
				if(!ws) {
					$('#result').html('서버 연결 실패<br>');
				} else {
					ws.onopen=function() {
						$('#result').html('서버 연결 성공<br>');
					}
					ws.onclose=function() {
						$('#result').html('서버 연결 종료<br>');
					}
					ws.onmessage=function(event) {
						$('#msg').val($('#msg').val()+event.data+"\n");
						$('#result').html('메시지 수신<br>');
					}
				}
			}
			$('input:button[value=전송]').on(
				"click",
				function(event) {
					var id=$('input[name=id]').val();
					var message=$('input[name=message]').val();
					if(id&&message) {
						var msg=id+" : "+message;
						$('input[name=message]').val('').focus();
						ws.send(msg);
						$('#result').html('메시지 전송<br>');
					} else {
						$('#result').html('메시지를 입력하세요.<br>');
					}
				}
			);
		}
	);
</script>
<h2>Web Socket Chatting</h2>
<table border="1">
	<tr>
		<th>메시지</th>
		<th><input class="inputId" type="text" name="id" placeholder="대화명"></th>
		<td><input class="inputChat" type="text" name="message" placeholder="대화내용"></td>
		<th><input class="inputbutton" type="button" value="전송"></th>
	</tr>
	<tr>
		<th colspan="4">
			<textarea id="msg" name="msg" rows="30" cols="100"></textarea>
		</th>
	</tr>
</table>
<div id="result"></div>