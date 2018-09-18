<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>append / appendTo</h2>
<script type="text/javascript">
	$(document).ready(
		function() {
			//DOM
			var dom=document.getElementById("dom");
			var span=document.createElement("span");
			/* var spantext=document.createTextNode("DOM apped");
			span.appendChild(spantext); */
			var spanb=document.createElement("span");
			spanb.innerHTML="DOM before";
			dom.parentNode.insertBefore(spanb, dom);
			//JQuery
			//append
			$('#append').append('<span>append</span>')
			$('#append').prepend('<span>prepend</span>')
			$('#append').after('<span>after</span><br>')
			$('#append').before('<span>before1</span><br>')
			$('#append').before('<span>before2</span><br>')
			//appendTo
			$('<span>appendTo</span>').appendTo('#appendto');
			$('<span>prependTo</span>').prependTo('#appendto');
			$('<span>insertBefore</span><br>').insertBefore('#appendto');
			$('<span>insertAfter</span><br>').insertAfter('#appendto');
			//#(selector).append(content, content, ...)
			//appendTo는 이렇게 못 씀
			$('#img').append(
				'<br>',
				'<br>',
				$('<img>').attr({src:'/JQueryEx/images/cat.jpg', width:'300px', height:'200px', border:'0'})
			);
			//$("<img src='/JQueryEx/images/cat2.jpg'>").prependTo('#img')
			$('<img><br><br>').attr({src:'/JQueryEx/images/cat2.jpg', width:'300px', height:'200px', border:'0'}).prependTo('#img');
			//$(selector).append(function(index){})
			var emp=[
				{name:'홍길동', age:30},
				{name:'이순신', age:20},
				{name:'김유신', age:40}
			];
			$('h5').append(function(index) {
				return "이름 : "+emp[index].name+" "+"나이 : "+emp[index].age+"<br>";
			});
		}	
	);
</script>
<h5></h5>
<h5></h5>
<h5></h5>
<br><br>
<div id="img">
	<hr size="3" align="left" color="red">
</div>
<br><br><br>
<div id="dom">
	<hr size="3" align="left" color="red">
</div>
<div id="appendto">
	<hr size="3" align="left" color="red">
</div>
<div id="append">
	<hr size="3" align="left" color="red">
</div>