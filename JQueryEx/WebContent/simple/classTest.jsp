<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>JSON Class Test</h2>
<script type="text/javascript">
	function Member(name, age, tel) {
		this.name=name;
		this.age=age;
		this.tel=tel;
	}
	Member.prototype.getName=function() {
		return this.name;
	}
	Member.prototype.getAge=function() {
		return this.age;
	}
	Member.prototype.getTel=function() {
		return this.tel;
	}
	function User(name, age, tel) {
		this.name=name;
		this.age=age;
		this.tel=tel;
	}
	User.prototype={
			getName:function() {return this.name},
			getAge:function() {return this.age},
			getTel:function() {return this.tel}
	};
	window.onload=function() {
		var result=document.getElementById("result");
		var msg="";
		var hong=new Member('홍길동', 30, '1111-2222');
		msg+="Name : "+hong.getName()+"<br>"
			+"Age : "+hong.getAge()+"<br>"
			+"Tel : "+hong.getTel()+"<br><br>";
		var kim=new User('김유신', 20, '2222-2222');
		msg+="Name : "+kim.getName()+"<br>"
			+"Age : "+kim.getAge()+"<br>"
			+"Tel : "+kim.getTel()+"<br><br>";
		result.innerHTML=msg;
	}
</script>
<div id="result"></div>