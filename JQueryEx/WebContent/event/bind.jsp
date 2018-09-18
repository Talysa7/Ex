<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	.reverse {
		color:white;
		background:black;
	}
</style>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>event - bind</h2>
<script type="text/javascript">
	$(document).ready(
		function() {
			//$(selector).bind(eventname, function(event) {})
			$('h5').bind(
				'click',
				function(event) {
					$(this).text($(this).text()+"좋아");	
				}
			);
			//$(selector).bind(object)
			$('h5').bind(
				{
					'mouseover':function(event) {
						$(this).addClass('reverse');
					},
					'mouseout':function(event) {
						$(this).remove('reverse');
					},
					'dblclick':function(event) {
						$(this).css('font-size', ++size);
					}
				}
			);
			
			//unbind
			setTimeout(
				function(event) {
					$('h5').unbind('click');
				}, 3000
			);
			//one
			$('h5').one(
				'click', 
				function(event) {
					alert('click');
				}
			);
			s
		}		
	);
</script>
<h5>짜장면</h5>
<h5></h5>
<h5></h5>
<h5></h5>