<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/JQueryEx/jquery-3.3.1.js"></script>
<h2>$.extend()</h2>
<script type="text/javascript">
	$(document).ready(
		function() {
			var result=document.getElementById("result");
			var msg="";
			//javascript
			var hong=new Object;
			hong.name='홍길동';
			hong.age=30;
			hong.tel='1111-2222';
			hong.getName=function() {return this.name};
			hong.getAge=function() {return this.age};
			hong.getTel=function() {return this.tel};
			msg+="이름 : "+hong.getName()+"<br>"
					+"나이 : "+hong.getAge()+"<br>"
					+"전화번호 : "+hong.getTel()+"<br><br>";
			var lee=new Object();
			$.extend(
				lee,
				{name:'이순신'},
				{age:30},
				{tel:'1111-3333'},
				{getName:function() {return this.name}},
				{getAge:function() {return this.age}},
				{getTel:function() {return this.tel}}
			);
			msg+="이름 : "+lee.getName()+"<br>"
					+"나이 : "+lee.getAge()+"<br>"
					+"전화번호 : "+lee.getTel()+"<br><br>";
			var kim=new Object();
			$.extend(
				kim,
				{
					name:'김유신', 
					age:30, 
					tel:'2222-3333', 
					getName:function() {return this.name}, 
					getAge:function() {return this.age}, 
					getTel:function() {return this.tel}
				}
			);
			msg+="이름 : "+kim.getName()+"<br>"
			+"나이 : "+kim.getAge()+"<br>"
			+"전화번호 : "+kim.getTel()+"<br><br>";
			
			result.innerHTML=msg;
		}
	)
</script>
<div id="result"></div>