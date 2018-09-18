<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(
		function() {
			//bind
			/* $('h5').bind(
				'click',
				function(event) {
					$('<h5>').text($(this).text()).appendTo('#result');
				}
			); */
			//on - bind $(selector).on(eventname, eventhandler)
			/* $('h5').on(
					'click',
					function(event) {
						$('<h5>').text($(this).text()).appendTo('#result');
					}
				); */
			//on - live $(selector).on(eventname, selector, eventhandler)
			$('div').on(
				'click',
				'h5',
				function(event) {
					$('<h5>').text($(this).text()).appendTo('#result');
				}
			);
			setTimeout(
				function() {
					$('div').off('click');
				}, 5000
			);	
			
		}
	);
</script>
<div id="result">
	<h5>짜장면</h5>
	<h5>짬뽕</h5>
	<h5>볶음밥</h5>
	<h5>탕수육</h5>
	<hr size="3" color="red" align="left">
</div>
