<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>JSON</h2>
<script type="text/javascript">
	function show() {
		var result = document.getElementById("result");
		var msg = "";
		//number
		var m = {
			a : 10,
			b : 20,
			c : 30
		};
		msg += "a :" + m.a + "<br>" + "b :" + m.b + "<br>" + "c :" + m['c']
				+ "<br>"
		var str = {
			name : '홍길동',
			age : 30,
			tel : '1111-2222'
		};
		msg += "이름 :" + str.name + "<br>" + "나이 :" + str.age + "<br>"
				+ "전화번호 :" + str.tel + "<br>"
		msg += "<br>";
		//Array
		var v = {
			salary : [ 2000, 3000, 4000, 5000 ]
		};
		for (var i = 0; i < v.salary.length; i++) {
			msg += "연봉:" + v.salary[i] + "<br>"
		}
		msg += "<br>";
		//Object - JSON 객체
		var e = {
			employee : {
				name : '홍길동',
				age : 30
			}
		};
		msg += "이름 :" + e.employee.name + "<br>" + "나이 :" + e.employee.age
				+ "<br>"
		msg += "<br>";
		var es = {
			employees : [ {
				name : '홍길동',
				age : 30
			}, {
				name : '이순신',
				age : 40
			}, {
				name : '김유신',
				age : 50
			} ]
		}
		for (var i = 0; i < es.employees.length; i++) {
			msg += "이름 :" + es.employees[i].name + "<br>" + "나이 :"
					+ es.employees[i].age + "<br>"
		}
		msg += "<br>";
		var ee = [ {
			name : '홍길동',
			age : 30
		}, {
			name : '이순신',
			age : 40
		}, {
			name : '김유신',
			age : 50
		} ];
		for (var i = 0; i < ee.length; i++) {
			msg += "이름:" + ee[i].name + " " + "나이:" + ee[i].age + "<br>";
		}
		msg += "<br>";
		var ees = {
			hong : {
				name : '홍길동',
				age : 30
			},
			re : {
				name : '이순신',
				age : 40
			},
			kim : {
				name : '김유신',
				age : 50
			},
		};
		msg += "이름" + ees.hong.name + "<br>" + "나이 :" + ees.hong.age + "<br>"
				+ "이름" + ees.re.name + "<br>" + "나이 :" + ees.re.age + "<br>"
				+ "이름" + ees.kim.name + "<br>" + "나이 :" + ees.kim.age + "<br>"
		result.innerHTML = msg;
	}
//-->
</script>
<br>
<br>
<body onload="show()">
	<div id="result"></div>
</body>