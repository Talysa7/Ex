<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	var request=null;
	function show() {
		if(window.ActiveXObject) {
			//IE
			try {	
				request=new ActiveXObject("Msxml2.XMLHTTP");
			} catch(e) {
				request=new ActiveXObject("Microsoft.XMLHTTP");
			}
		} else {
			request=new XMLHttpRequest();
		}
		var params="?name="+encodeURI(inputform.name.value)+"&age="+inputform.age.value;
		request.onreadystatechange=showresult;
		request.open("GET", "simpleData.jsp"+params, true);
		request.send(params);
	}
	var str="";
	var request=null;
	function showresult() {
		str+="state : "+request.readyState+"<br>";
		var state=document.getElementById("state");
		if(request.readyState==4) {
			if(request.status==200) {
				str+="정상종료<br>";
				var result=document.getElementById("result");
				result.innerHTML=request.responseText;
			} else {
				str+="에러발생<br>";
			}
		} else {
			str+="통신 중<br>"
		}

		state.innerHTML=str;
	}
</script>
<br>
<form name="inputform">
	이름 : <input type="text" name="name"><br>
	나이 : <input type="text" name="age"><br>
</form>
확인 : <input type="button" value="확인" onclick="show()">
<div id="result"></div>
<div id="state"></div>