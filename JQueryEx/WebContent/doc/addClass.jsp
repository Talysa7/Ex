<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>addClass / removeClass</h2>
<style type="text/css">
	.point {
		color:red;
	}
	.strong {
		color:blue;	
	}
</style>
<script type="text/javascript">
	$(document).ready (
		function() {
			//addClass
			$('h4').filter(':first').addClass('point');
			$('h4').each(
				function(index, item) {
					$(item).addClass('strong');
				}	
			);
			//removeClass
			//$('h4:contains(순대)').removeClass('strong');
			$('h4').each(
				function(index, item) {
					if($(item).is('.strong')) {
						$(item).removeClass('strong');
					}
				}	
			);
			$('h4').first().removeClass('point');
		}
	);
</script>
<h4>떡볶이</h4>
<h4>순대</h4>
<h4>튀김</h4>
<h4>어묵</h4>