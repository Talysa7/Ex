<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>find() - JSON</h2>
<script type="text/javascript">
	var xml="<books>"
		+"<![CDATA["
			+"{"
				+"book:["
					+"{"
						+"title:'Java 프로그래밍',"
						+"author:'홍길동',"
						+"price:30000"
					+"},"
					+"{"
						+"title:'JSP 웹프로그래밍',"
						+"author:'이순신',"
						+"price:40000"
					+"},"
					+"{"
						+"title:'Spring 프레임워크',"
						+"author:'김유신',"
						+"price:30000"
					+"}"
				+"]"
			+"}"
		+"]]>"
	+"</books>"
	$(document).ready(
		function() {
			var xmldoc=$.parseXML(xml);
			var result=document.getElementById("result");
			var msg="";
			
			//DOM
			var books=eval("("+xmldoc.getElementsByTagName("books").item(0).firstChild.nodeValue+")");
			for(var i=0; i<books.book.length; i++) {
				msg+="제목 : "+books.book[i].title+"<br>"
						+"저자 : "+books.book[i].author+"<br>"
						+"가격 : "+books.book[i].price+"<br><br>";
			}
			//JQuery
			var bs=eval("("+$(xmldoc).find('books').text()+")");
			for(var i=0; i<bs.book.length;i++) {
				msg+="제목 : "+bs.book[i].title+"<br>"
							+"저자 : "+bs.book[i].author+"<br>"
							+"가격 : "+bs.book[i].price+"<br><br>"
			}
			$.each(
				bs.book,
				function(index, item) {
					msg+="제목 : "+item.title+"<br>"
					+"저자 : "+item.author+"<br>"
					+"가격 : "+item.price+"<br><br>"
				}
			);
			
			result.innerHTML=msg;
		}
	);
</script>
<div id="result"></div>