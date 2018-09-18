<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>attr</h2>
<script type="text/javascript">
	$(document).ready(
		function() {
			var result=document.getElementById("result");
			var msg="";
			//DOM
			var first=document.getElementById("first");
			first.setAttribute('src', '/JQueryEx/images/cat.jpg');
			first.setAttribute('width', '500px');
			first.setAttribute('height', '300px');
			msg+="src : " + first.getAttribute('src')+"<br>";
			// JQuery
			// $(selector).attr( name, value )
			$('#second').attr('src', '/JQueryEx/images/cat2.jpg');
			//$(selector).attr(object);
			$('#second').attr({
				width:'500px',
				height:'300px'
			});
			//$(selector).attr(name, function(index, attr));
			$('img').attr(
				'border',
				function(index, attr) {
					return index*10;
				}
			);
			
			//$(selector).attr(name);
			msg+="src : "+$('#second').attr('src')+"<br>";
			
			var align=['left', 'right'];
			$('img').attr(
				'align',
				function(index, attr) {
					return align[index];
				}
			);
			$('img').attr({
				width:function(index, attr) {
					return (index+1)*100;
				},
				height:function(index, attr) {
					return (index+1)*100;
				}
			});
			$('#first').removeAttr('width');
			$('#first').removeAttr('height');
			
			result.innerHTML=msg;
		}
	);
</script>
<img id="result"><br><br>
<img id="first"><br><br>
<img id="second"><br><br>