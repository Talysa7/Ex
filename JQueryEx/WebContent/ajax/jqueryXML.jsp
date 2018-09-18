<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="/JQueryEx/jquery-3.3.1.js"></script>

<h2> JQuery Ajax - XML </h2>

<script type="text/javascript">
	// <!--
	$(document).ready(
		function() {
			$.ajax( {
					type : 'POST',
					url : 'member.xml',
					dataType : 'xml',
					success : function( data ) {
						var msg = '';
						$(data).find('member').each(
							function( index, item ) {
								msg += "이름 : " + $(item).find('name').text() + "<br>"
									+ "나이 : " + $(item).find('age').text() + "<br>"
									+ "전화번호 : " + $(item).find('tel').text() + "<br><br>";
							}							
						);	
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








