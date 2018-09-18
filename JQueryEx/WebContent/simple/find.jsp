<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<script type="text/javascript">
	var xml="<books>"
		+"<book>"
			+"<title>Java 프로그래밍</title>"
			+"<author>홍길동</author>"
			+"<price>25000</price>"
		+"</book>"
		+"<book>"
			+"<title>JSP 웹프로그래밍</title>"
			+"<author>이순신</author>"
			+"<price>40000</price>"
		+"</book>"
		+"<book>"
			+"<title>Jquery Ajax</title>"
			+"<author>김유신</author>"
			+"<price>30000</price>"
		+"</book>"
	+"</books>";
	
	$(document).ready(
		function() {
			var xmldoc=$.parseXML(xml);
			var result=document.getElementById("result");
			var msg="";
			
			//DOM
			var booklist=xmldoc.getElementsByTagName("book");
			var titlelist=xmldoc.getElementsByTagName("title");
			var authorlist=xmldoc.getElementsByTagName("author");
			var pricelist=xmldoc.getElementsByTagName("price");
			for(var i=0; i<booklist.length; i++) {
				msg+="제목 : "+titlelist.item(i).firstChild.nodeValue+"<br>"
						+"저자 : "+authorlist.item(i).firstChild.nodeValue+"<br>"
						+"가격 : "+pricelist.item(i).firstChild.nodeValue+"<br><br>";
			}
			//JQuery
			$(xmldoc).find('book').each(
				function(index, item) {
					msg+=$(item).find('title').text()+"<br>"
							+$(item).find('author').text()+"<br>"
							+$(item).find('price').text()+"<br><br>";
				}
			)
			
			result.innerHTML=msg;
		}	
	);
</script>
<div id="result"></div>