<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>배열/$.each()</h2>
<script type="text/javascript">
	$(document).ready(
		function() {
			var result=document.getElementById("result");
			var m=["사과", "딸기", "바나나", "수박"];
			var msg="";
			
			//javascript
			for(var i=0; i<m.length; i++) {
				msg+=m[i]+"&nbsp";
			}
			msg+="<br>";
			var w=new Array(10, 20, 30, 40, 50);
			for(var i=0; i<w.length; i++) {
				msg+=w[i]+"&nbsp";
			}
			msg+="<br>";
			
			//JQuery
			//$.each(object, function(index, item){})
			//$(selector).each(function(index, item){})
			
			$.each(
				m, function(index, item){
					msg+=index+" : "+item+"&nbsp"
				}
			);
			msg+="<br>";
			$.each(
				m, function(index, item){
					msg+=index+" : "+m[index]+"&nbsp"
				}
			);
			msg+="<br>";
			$.each(
				m, function(index, item){
					msg+=index+" : "+this+"&nbsp"
				}
			);
			msg+="<br>";
			$('h4').each(
				function(index, item) {
					//msg+=index+" : "+item+"<br>";
					if(index%2==0) $(item).css('background', 'pink');
					else $(item).css('background', 'skyblue');
				}	
			);
			msg+="<br>";
			$('h4').each(
				function(index, item) {
					msg+=$(this).text()+"&nbsp";
				}
			);
			msg+="<br>";
			var color=['red', 'blue', 'green', 'yellow'];
			$('h4').each(
				function(index, item) {
					$(this).css('color', color[index]);
				}
			);
			msg+="<br>";
			$('h4').text(
				function(index, item) {
					msg+=item+"&nbsp";
				}
			);
			msg+="<br>"+"End";
			
			result.innerHTML=msg;
		}	
	)
</script>
<h4>축구</h4>
<h4>야구</h4>
<h4>농구</h4>
<h4>배구</h4>
<div id="result"></div>