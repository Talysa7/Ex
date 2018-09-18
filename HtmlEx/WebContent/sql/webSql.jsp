<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Web SQL Database</h2>
<script src="/HtmlEx/jquery-3.3.1.js"></script>
<script type="text/javascript">
	var db=null;
	$(document).ready(
		function() {
			function check() {
				if(!window.openDatabase) {
					$('#result').html('지원하지 않는 브라우저입니다.<br>');
					return false;
				} else {
					$('#result').html('지원하는 브라우저입니다.<br>');
					return true;
				}
			}
			if(check()) {
				db=openDatabase("mydb", "1.0", "회원관리", 1024*1024*5);
				db.transaction(
					function(tx) {
						tx.executeSql(
							"create table member("
							+	"name varchar2(30) not null,"
							+	"age number(3) not null,"
							+	"tel varchar2(50),"
							+	"address varchar2(100)"
							+	")"
						);
					},
					function(error) {
						$('#result').html('데이터베이스 생성에 실패했습니다.<br>'+error.message);
					},
					function() {
						$('#result').html('데이터베이스 생성에 성공했습니다.<br>');
					}
				);
			}
			$('input:button[value=가입]').on(
				'click',
				function(event) {
					var name=$('input[name=name]').val();
					var age=$('input[name=age]').val();
					var tel=$('input[name=tel]').val();
					var address=$('input[name=address]').val();
					if(!name||!age) {
						$('#result').html("이름과 나이를 입력하세요.<br>");
					} else {
						$('#result').html("");
						db.transaction(
							function(tx) {
								tx.executeSql(
									"insert into member values(?, ?, ?, ?)",
									[name, age, tel, address]
								);
							},
							function(error) {
								$('#result').html('가입에 실패했습니다.<br>'+error.message+'<br>');
							},
							function() {
								$('#result').html('가입에 성공했습니다.<br>');
							}
						);
					}
				}
			);
			$('input:button[value=보기]').on(
				'click',
				function(event) {
					var name=$('input[name=name]').val();
					var age=$('input[name=age]').val();
					var tel=$('input[name=tel]').val();
					var address=$('input[name=address]').val();
					db.transaction(
						function(tx) {
							if(name) {
								tx.executeSql(
									"select * from member where name=?",
									[name],
									show
								);
							} else {
								tx.executeSql(
									"select * from member",
									[],
									show
								);
							}
						},
						function(error) {
							$('#result').html('회원 정보 보기에 실패했습니다.<br>'+error.message+'<br>');
						},
						function() {
							$('#result').html('회원 정보 보기에 성공했습니다.<br>');
						}
					);
				}
			);
			$('input:button[value=삭제]').on(
				'click',
				function(event) {
					var name=$('input[name=name]').val();
					if(name) {
						db.transaction(
							function(tx) {
								tx.executeSql(
									"delete from member where name=?",
									[name]
								);
							},
							function(error) {
								$('#result').html('회원 삭제에 실패했습니다.<br>'+error.message+'<br>');
							},
							function() {
								$('#result').html('회원 삭제에 성공했습니다.<br>');
							}
						);
					} else {
						$('#result').html('이름을 입력하세요.<br>');
					}
				}
			);
			$('input:button[value=수정]').on(
					'click',
					function(event) {
						var name=$('input[name=name]').val();
						var age=$('input[name=age]').val();
						var tel=$('input[name=tel]').val();
						var address=$('input[name=address]').val();
						if(name&&age) {
							db.transaction(
								function(tx) {
									tx.executeSql(
										"select * from member where name=?",
										[name],
										function(tx,rs) {
											if(rs.rows.length==0) {
												$('#result').html('입력하신 이름이 없습니다.<br>');
											} else {
												tx.executeSql(
													"update member set age=?, tel=?, address=? where name=?",
													[age, tel, address, name]
												);
												$('#result').html('회원 정보를 수정했습니다.<br>');
											}
										}
									);
								},
								function(error) {
									$('#result').html('회원 수정에 실패했습니다.<br>'+error.message+'<br>');
								},
								function() {
								}
							);
						} else {
							$('#result').html('이름과 나이를 입력하세요.<br>');
						}
					}
				);
			function show(tx, rs) {
				if(rs.rows&&rs.rows.length) {
					var t=document.getElementById("t");
					t.innerHTML="";
					for(var i=0; i<rs.rows.length; i++) {
						var row=t.insertRow();
						var col1=row.insertCell();
						var col2=row.insertCell();
						var col3=row.insertCell();
						var col4=row.insertCell();
						col1.innerHTML=rs.rows.item(i).name;
						col2.innerHTML=rs.rows.item(i).age;
						col3.innerHTML=rs.rows.item(i).tel;
						col4.innerHTML=rs.rows.item(i).address;
					}
				}
			}
		}	
	);	
</script>

<table border="1">
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" autofocus placeholder="필수 입력"></td>
	</tr>
	<tr>
		<th>나이</th>
		<td><input type="number" name="age" placeholder="필수 입력"></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td><input type="tel" name="tel"></td>
	</tr>
		<tr>
		<th>주소</th>
		<td><input type="text" name="address"></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="button" value="가입">
			<input type="button" value="보기">
			<input type="button" value="수정">
			<input type="button" value="삭제">
			<input type="reset" value="취소">
		</th>
	</tr>
</table>
<table border="1">
	<tr>
		<th>이름</th>
		<th>나이</th>
		<th>전화번호</th>
		<th>이름</th>
	</tr>
		<tbody id="t">
		</tbody>
</table>
<div id="result">
</div>