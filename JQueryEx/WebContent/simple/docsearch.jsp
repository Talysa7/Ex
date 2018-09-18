<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>문서 객체 탐색</h2>
<script type="text/javascript">
	$(document).ready(
		function() {
			$('h4').each(function() {
				$(this).css(
					{
						color:'red',
						background:'gray'
					}
				);
				}
			);
			//filter
			//$(seletor).filter(selector)
			$('h5:first').css('color', 'red');
			$('h5:even').css('color', 'red');
			$('h5').filter(':first').css('color', 'blue');
			$('h5').filter(':eq(1)').css('color', 'blue');
			$('h5').filter(':odd').filter(':even').css('color', 'green');
			//$(selector).filter(function(index){})
			$('h4').filter(
					function(index, item) {
						return item;
					}
				).css('color', 'blue');
			//eq()
			$('h4').eq(1).css('color', 'pink');
			$('h4').first().css('color', 'pink');
			$('h4').last().css('color', 'pink');
			
			//end() add()
			/* $('h4').filter(':even').filter(':odd').css('background', 'yellow')
			.end().filter(':odd').filter(':even').css('background', 'red'); */
			$('h4').filter(':even').filter(':odd').css('background', 'yellow')
			.add('h4').filter(':odd').filter(':even').css('background', 'red');
			//is
			$('h4').each(
				function(index) {
					if($(index).is('.point')) {
						$(this).css('background', 'white');
					}
				}	
			)
		}
	);
</script>
<h4 class="point">독서</h4>
<h4>등산</h4>
<h4>운동</h4>
<h4>낚시</h4>
<br>
<h5>바나나</h5>
<h5>사과</h5>
<h5>딸기</h5>
<h5>복숭아</h5>