<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="/JQueryEx/jquery-3.3.1.js"></script>

<h2> JQuery Ajax - JSON </h2> 

<script type="text/javascript">
	//<!--
	$(document).ready(
		function() {
			$.ajax( {
					type : 'POST',
					url : 'member.jsp',
					dataType : 'text',
					success : function( data ) {
						var msg = '';
						data = eval( "(" + data + ")" );
						for( var i=0; i<data.members.member.length; i++ ) {
							msg += "이름 : " + data.members.member[i].name + "<br>"
								+ "나이 : " + data.members.member[i].age + "<br>"
								+ "전화번호 : " + data.members.member[i].tel + "<br><br>";
						}						
						$('#result').html( msg );
					},
					error : function( e ) {
						$('#result').html( e );	
					}			
				}
			);
			
		}		
	);	
	//-->
</script>   
<div id="result"></div>









