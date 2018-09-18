<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>mouse event</h2>
<style>
	.outer {
		width:200px;
		height:200px;
		background:lightgray;
		padding:50px;
	}
	.inner {
		width:100px;
		height:100px;
		background:pink;
		margin:50px;
	}
</style>
<script type="text/javascript">
	$(document).ready(
		function() {
			var result=document.getElementById("result");
			var msg="";
			$('.outer').mouseover(
				function() {
					msg+="쥐다! ";
					$('#result').html(msg);
				}
			).mouseout(
				function() {
					msg+="휴! 갔다!<br>";
					$('#result').html(msg);
				}	
			);
			$('.inner').mouseover(
				function() {
					msg='';
					$('#result').html(msg);
				}	
			).mousedown(
				function() {
					$('.inner').css('background', 'white');
				}	
			).mouseup(
				function() {
					$('.inner').css('background', 'pink');
				}	
			);
		}	
	);
</script>
<div class="outer">
	<div class="inner">
	</div>
</div>
<div id="result">
</div>