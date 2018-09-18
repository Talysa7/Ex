<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>append/appendTo</h2>
<script type="text/javascript">
	$(document).ready(
		function() {
			$('#result').append(
				'<br>',
				$('<img>').attr({src:'/JQueryEx/images/cat.jpg', width:'300px', height:'200px', border:'0'}),
				$('<img>').attr({src:'/JQueryEx/images/cat2.jpg', width:'300px', height:'200px', border:'0'}),
				$('<img>').attr({src:'/JQueryEx/images/kitty.jpg', width:'300px', height:'200px', border:'0'}),
			);
			setInterval(function() {
				$('#result').append($('img').first().clone());
			}, 1000);
		}		
	);
</script>
<div id="result">
</div>