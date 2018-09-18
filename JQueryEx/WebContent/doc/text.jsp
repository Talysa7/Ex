<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>text / html / remove / empty</h2>
<script type="text/javascript">
	function show() {
		
		var a=document.getElementById("a");
		a.innerHTML="<b>innerHTML</b>";
		$('span:eq(1)').text("<b>innerHTML</b>");
		$('span:eq(2)').html("<b>innerHTML</b>");
		var result=document.getElementById("result");
		var msg="";
		
		//$(selector).text()
		//$(selector).html()
		$('#result').text("text : "+$('span:eq(1)').text()+"<br>");
		$('#result').html("html : "+$('span:eq(2)').html()+"<br><br>");
		/* msg+="text : "+$('span:eq(1)').text()+"<br>"
				+"html : "+$('span:eq(2)').html()+"<br>"; */
		//result.innerHTML=msg;
				
		//$(selector).text(function(index, text){})
		//$(selector).html(function(index, html){})
		$('a:even').text(
			function(index, text) {
				return index+" : "+text;
			}	
		);
		$('a:odd').html(
				function(index, html) {
					return index+" : "+html;
				}	
			);
		//remove
		$('span:first').remove();
		$('span:last').remove();
	}
</script>
<div id="result"></div><br>
<span id="a"></span><br>
<span></span><br>
<span></span><br>
확인 : <input type="button" value="확인" onclick="show()"><br>
<br>
<a><b>A</b></a><br>
<a><b>B</b></a><br>
<a><b>C</b></a><br>
<a><b>D</b></a><br>