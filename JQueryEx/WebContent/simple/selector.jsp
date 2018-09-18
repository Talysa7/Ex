<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>선택자</h2>
<script type="text/javascript">
$(document).ready(
	function() {
		//전체 선택자
		$('*').css('color', 'red');
		//태그 선택자
		$('h4').css('color', 'blue');
		$('h4,h5').css('background', 'lightgray');
		//후손 선택자
		$('div h4').css('font-style', 'italic');
		$('div h4, div h5').css('text-decoration', 'underline');
		//자식 선택자
		$('div>h4').css('font-style', 'normal');
		$('div>h4, div>h5').css('text-decoration', 'line-through');
		//클래스 선택자
		$('.strong').css('color', 'green');
		$('.kingkong').css('color', 'pink');
		$('h4.strong').css('color', 'yellow');
		$('h5.strong').css('color', 'yellow');
		//아이디 선택자
		$('#point').css('color', 'skyblue');
		$('h4#point').css('color', 'magenta');
		$('h5.strong#point').css('color', 'cyan')
		$('.strong.kingkong').css('background', 'darkgray');
	}
);
</script>
<br>
<h4 id="point">축구</h4>
<h4 class="strong">야구</h4>
<div><h4>농구</h4></div>
<div><a><h4>배구</h4></a></div>
<h5 id="point" class="strong">독서</h5>
<h5 class="strong kingkong">등산</h5>
<div><h5>운동</h5></div>
<div><a><h5>게임</h5></a></div>