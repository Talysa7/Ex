<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>css</h2>
<script type="text/javascript">
	$(document).ready(
		function() {
			var result=document.getElementById("result");
			var msg="";
			
			//$(selector).css(name, value)
			$('h4').css('color', 'red');
			$('h4').each(
				function(index, item) {
					msg+=index+" : "+$(item).css('color')+" "
					+$(item).css('font-size')+"<br>";
				}
			);
			//$(selector).css()
			var color=['blue', 'red', 'yellow', 'green'];
			$('h4').css(
				'color',
				function(index, item) {
					return color[index];
				}
			);
			//$(selector).css(object)
			$('h4:odd').css({
				background:'gray',
				'font-style':'italic'
			});
			//$(selector).css(function(){})
			var size=[15, 20, 30, 40];
			var back=['silver', 'lightgray', 'gray', 'darkgray']
			$('h4').css({
				'font-size':function(index, style) {
					return size[index];
				},
				background:function(index, style) {
					return back[index];
				}
			})
			
			result.innerHTML=msg;
		}
	);
</script>
<h4>하나</h4>
<h4>둘</h4>
<h4>셋</h4>
<h4>넷</h4>
<div id="result"></div>