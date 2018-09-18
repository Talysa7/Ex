<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="/JQueryEx/jquery-3.3.1.js"></script>

<h2> DBTest - JQuery Ajax - JSTL SQL </h2>

<script type="text/javascript">
	//<!--
	$(document).ready(
		function() {
			$('input[name=id]').on( 
				'keyup',
				function( event ) {
					var id = $('input[name=id]').val();
					if( id ) {
						$.ajax( {
								type : "POST",
								data : {
									id : id									
								},
								url : 'idcheck.jsp',
								dataType : 'xml',
								success : function( data ) {									
									$('.idresult').text( $(data).find('message').text() );	
								}, 
								error : function( e ) {									
									$('.idresult').text( e );	
								}								
							}
						);					
					}
				}
			);
			
			$('input[name=passwd]').on(
				'keyup',
				function( event ) {
					var passwd = $('input[name=passwd]').val();
					if( passwd ) {
						if( isNaN( passwd ) ) {
							$('.passwdresult').text( '사용할수 있습니다.' );
						} else {
							$('.passwdresult').text( '사용할수 없습니다.' );
						}
					}
				}
			);
			
			// 비밀번호가 같으면 사용할 수 있다
			// 다르면 사용할 수 없다
			
			// 전화번호 - 없이 입력하도록
			
			// 입력처리
			$('input:button[value=가입]').on(
				'click',
				function( event ) {
					if( $('.idresult').text().indexOf('없') != -1 ) {
						$('#result').text( '다른 아이디를 선택해주세요' );
					} else {	
						var msg = '';
						$.ajax( {
								type : 'POST',
								url : 'insert.jsp',
								data : $('form').serialize(),
								dataType : 'xml',
								success : function( data ) {
									var code = $(data).find('code').text().trim();
									if( code == 'success' ) {
										var user = eval( "(" + $(data).find('message').text() + ")" );
										msg += "아이디 : " + user.id + "<br>"
											+ "비밀번호 : " + user.passwd + "<br>"
											+ "이름 : " + user.name + "<br>"
											+ "전화번호 : " + user.tel + "<br><br>";
										$('#result').html( msg );	
									} else if( code == 'error' ) {
										msg += $(data).find('message').text();
										$('#result').html( msg );	
									}								
								},
								error : function( e ) {
									$('#result').html( e );
								}
							}							
						);
					}
				}
			);
			
			// 리스트 출력
			$('input:button[value=검색]').on(
				'click',
				function( event ) {
					$('#t').html('');
					$.ajax( {
							type : 'POST',
							url : 'select.jsp',
							data : {
								id : $('input:text[name=search]').val()
							},
							dataType : 'xml',
							success : function( data ) {
								var code = $(data).find('code').text().trim();
								if( code == 'success' ) {									
									var members = eval( "(" + $(data).find('members').text() + ")" );								
									for( var i=0; i<members.member.length; i++ ) {		
										var html =
											'<tr>' + 
												'<td>' + members.member[i].id+ '</td>' +	
												'<td>' + members.member[i].passwd+ '</td>' +
												'<td>' + members.member[i].name+ '</td>' +
												'<td>' + members.member[i].tel+ '</td>' +
												'<td>' + members.member[i].logtime+ '</td>'
											+ '</tr>';
										$(html).appendTo('#t');	
									}										
								}							
							},
							error : function( e ) {
								$('#result').text( e );
							}
						}
					);
				}
			);
			
			
			
		}		
	);	
	//-->
</script>
<form>
	<table border="1">
		<tr>
			<th> 아이디 </th>
			<td> 
				<input type="text" name="id">				
			</td>
			<td width ="300" class="idresult">아이디를 입력하세요</td>
		</tr>
		<tr>
			<th rowspan="2"> 비밀번호 </th>
			<td> <input type="password" name="passwd"> </td>
			<td class="passwdresult">비밀번호를 입력하세요</td>
		</tr>
		<tr>
			<td> <input type="password" name="repasswd"> </td>
			<td class="repasswdresult">같은 비밀번호를 입력하세요</td>
		</tr>
		<tr>
			<th> 이름 </th>
			<td> <input type="text" name="name"> </td>
			<td class="nameresult"> &nbsp;</td>
		</tr>
		<tr>
			<th> 전화번호 </th>
			<td> <input type="text" name="tel"> </td>
			<td class="telresult"> - 없이 입력하세요</td>
		</tr>		
		<tr>
			<th colspan="3">	
				<input type="button" value="가입">
				<input type="reset" value="취소">
			</th>
		</tr>
	</table>
</form>
<input type="text" name="search"> <input type="button" value="검색">
<br><br>
<table border="1">
	<tbody id="t">
	</tbody>
</table>

<div id="result"></div>









