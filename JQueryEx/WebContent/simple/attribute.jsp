<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(
		function() {
			//inputform.id.value='아이디를 입력하세요';
			$('input[name=id]').val('아이디를 입력하세요');
			$('input:text').css('background', 'lightgray');
			$('input[name=passwd]').val('비밀번호를 입력하세요');
			$('input:button').css('background', 'red');
			$('input[value=확인]').css('color', 'white');
			$('input:reset').css('background', 'blue');
			$('input[type=reset]').css('color', 'white');
			$('input:password').css('background', 'lightgray');
		}
	);
	function delid() {
		//$('input:text:focus').val('').css('background', 'white');
		$('input[name=id]').val('').css('background', 'white');
	}
	function delpw() {
		$('input[name=passwd]').val('').css('background', 'white');
	}
	function show() {
		var result=document.getElementById("result");
		var msg="";
		//DOM
		msg+="아이디 : "+inputform.id.value+"<br>"
			+"비밀번호 : "+inputform.passwd.value+"<br>"
			+"성별 : "+(inputform.gender[0].checked?"남자":"여자")+"<br>"
			+"취미 : "+inputform.hobby.options[inputform.hobby.selectedIndex].value+"<br><br>";
		//JQuery
		msg+="아이디"+$('input[name=id]').val()+"<br>"
			+"비밀번호"+$('input[name=passwd]').val()+"<br>"
			+"성별"+$('input[name=gender]').val()+"<br>"
			+"취미"+$('select[name=hobby] option:selected').val()+"<br>";
		
		result.innerHTML=msg;
	}
</script>
<form name="inputform">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" onclick="delid()"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="passwd" onclick="delpw()"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="남자" checked>남자
				<input type="radio" name="gender" value="여자">여자
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<select name="hobby">
					<option value="독서">독서</option>
					<option value="등산">등산</option>
					<option value="운동">운동</option>
					<option value="게임">게임</option>
				</select>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" value="확인" onclick="show()">
				<input type="reset" value="취소" onclick="show()">
			</th>
		</tr>
	</table>
</form>
<br><br>
<div id="result"></div>