<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(
		function() {
			$('h5').bind(
				'click',
				function(event) {
					$(this).text($(this).text()+'마시쪙! ');
				}
			);
			var cnt=0;
			setInterval(
				function() {
					$('h5:eq('+parseInt(Math.random()*4)+')').trigger('click');	
					cnt++;
				}, 500
			);
			$('h4').bind(
				'click',
				function(event, data1, data2) {
					$(this).text($(this).text()+data1+data2);
				}
			);
			setInterval(
				function() {
					$('h4').trigger('click', [' 주세요', ' 배고파']);	
				}, 1000
			);
			
			//preventDefault/stopPropagation
			$('a').bind(
				'click',
				function(event) {
					$(this).css('color', 'red');
					//event.preventDefault();
					//event.stopPropagation();
					return false;
				}
			);
			$('h3').bind(
				'click',
				function(event) {
					$(this).css('background', 'gray');
				}
			);
		}	
	);
</script>
<h3><a href="http://www.daum.net">다음</a></h3>
<h3><a href="http://www.naver.com">네이버</a></h3>
<br><br>
<h4>김치찌개</h4>
<h4>된장찌개</h4>
<h4>순두부</h4>
<h4>부대찌개</h4>
<br><br>
<h5>짜장면</h5>
<h5>짬뽕</h5>
<h5>볶음밥</h5>
<h5>탕수육</h5>