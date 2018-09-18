<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Simple JQuery</h2>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(
		function () {
			var result=document.getElementById("result");
			result.innerHTML="Hallo"+"<br>";
			window.onload=function() {
				var result=document.getElementById("result");
				result.innerHTML="Hallo"+"<br>";
			}
		}
);
</script>
<div id="result">
</div>