<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
	.message {
		border : solid blue 1px;
		width : 150px;
		height : 150px;
		float : left;
		margin : 10px;
	}
	#result {
		clear : left;
	}
</style>
<script type="text/javascript">
	//<!--
	var channel = null;
	function channelstart() {
		var result = document.getElementById( "result" );
		if( ! window.MessageChannel ) {
			result.innerHTML = "지원하지 않는 브라우저입니다<br>";
			return;
		}
		
		channel = new MessageChannel();
		channel.port1.start();		// 송신용
		channel.port2.start();		// 수신용			
		result.innerHTML += "채널 시작<br>";					
	}
	
	function addchannel() {
		var ch = document.getElementById( "ch" );
		var newdiv = document.createElement( "div" );
		newdiv.className = "message";
		ch.appendChild( newdiv );
	
		var result = document.getElementById( "result" );
		result.innerHTML += "채널을 추가했습니다<br>";
		
		channel.port2.addEventListener(
			"message",
			function( evt ) {
				newdiv.innerHTML += "받은메시지 : " + evt.data + "<br>"; 
			}
		);
	}
	
	function sendmsg() {
		var msg = inputform.msg.value;
		var result = document.getElementById( "result" );
		if( ! msg ) {
			result.innerHTML += "메세지를 입력하세요<br>";
			return;
		}
		result.innerHTML += "보낸 메시지 : " + msg + "<br>";
		inputform.msg.value = "";
		
		channel.port1.postMessage( msg );				
	}
	
	//-->
</script>		
<body onload="channelstart()">
	<h2> Channel Messaging </h2>
	<form name="inputform">
		<table border="1">
			<tr>
				<th> 보낼 메세지 </th>
				<td> <input type="text" name="msg"> </td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" value="전송" onclick="sendmsg()">
					<input type="button" value="추가" onclick="addchannel()">
				</th>
			</tr>			
		</table>		
	</form>
	<br><br>
	<div id="ch"></div>
	<br><br>
	<div id="result"></div>			
</body>