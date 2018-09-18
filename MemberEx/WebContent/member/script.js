//회원관리
var iderror="아이디를 입력하세요.";
var passwderror="비밀번호를 입력하세요.";
var repasswderror="비밀번호가 다릅니다.";
var nameerror="이름을 입력하세요.";
var juminerror="주민등록번호를 입력하세요.";
var telerror="전화번호 형식이 맞지 않습니다.";
var inputerror="회원가입에 실패했습니다.\n잠시 후 다시 시도하세요.";
var emailerror="이메일을 입력하세요.";
var aterror="이메일 주소를 올바르게 입력해주세요.";
var iderror="아이디를 입력해주세요.";
var loginiderror="아이디가 없습니다.";
var loginpasswderror="비밀번호가 틀립니다.";
var confirmerror="아이디 중복확인을 해 주세요.";
var deleteerror="회원탈퇴에 실패했습니다.\n잠시 후 다시 시도하세요.";
var modifyerror="수정에 실패했습니다.\n잠시 후 다시 시도하세요.";

function erroralert(msg) {
	alert(msg);
	history.back();
}

//로그인 페이지
function loginfocus() {
	loginform.id.focus();
}
function logincheck() {
	if(!loginform.id.value) {
		alert(iderror);
		loginform.id.focus();
		return false;
	} else if(!loginform.passwd.value) {
		alert(passwderror);
		loginform.id.focus();
		return false;
	}
}

//중복 확인 페이지
function setid(id) {
	opener.document.inputform.id.value=id;
	opener.document.inputform.confirm.value=1;
	opener.document.inputform.passwd.focus();
	self.close();
}
function setcancle() {
	opener.document.inputform.id.focus();
	opener.document.inputform.id.value="";
	self.close();
}
function confirmfocus() {
	confirmform.id.focus();
}

function confirmcheck() {
	if(!confirmform.id.value) {
		alert(iderror);
		confirmform.id.focus();
		return false;
	}
}
function confirmid() {
	if(!inputform.id.value) {
		alert(iderror);
	} else {
		var url="confirmId.do?id="+inputform.id.value;
		open(url, "confirm window", "toolbar=no, scrollbar=no, status=no, menubar=no, width=500px height=300px");
	}
}

//가입페이지
function inputfocus() {
	inputform.id.focus();
}
function inputcheck() {
	if(!inputform.id.value) {
		alert(iderror);
		inputform.id.focus();
		return false;
	} else if(!inputform.passwd.value) {
		alert(passwderror);
		inputform.passwd.focus();
		return false;
	} else if(inputform.passwd.value!=inputform.repasswd.value) {
		alert(repasswderror);
		inputform.passwd.focus();
		return false;
	} else if(!inputform.name.value) {
		alert(nameerror);
		inputform.name.focus();
		return false;
	} else if(!inputform.jumin1.value||!inputform.jumin2.value) {
		alert(juminerror);
		inputform.jumin1.focus();
		return false;
	} else if(inputform.jumin1.value.length>6||inputform.jumin2.value.length>7) {
		alert(juminerror);
		inputform.jumin1.focus();
		return false;
	} else if(inputform.tel1.value||inputform.tel2.value||inputform.tel3.value) {
		if(inputform.tel1.value.length<3||inputform.tel2.value.length<3||inputform.tel3.value.length<4) {
			alert(telerror);
			return false;
		}
	}
	if(!inputform.email1.value&&inputform.email2.value!="0") {
		//1. null인 경우			이동 가능
		alert(emailerror);
		return false;
	} else if(inputform.email1.value&&inputform.email2.value=="0") {
		//2. 직접입력인 경우	email1란에 @가 없으면 경고
		if(inputform.email1.value.indexOf("@")==-1) {
			alert(aterror);
			return false;
		}
	} else if(inputform.email1.value&&inputform.email2.value!="0") {
		//3. 선택입력인 경우	email1란에 @가 있으면 경고
		if(inputform.email1.value.indexOf("@")!=-1) {
			alert(aterror);
			return false;
		}
	}
	if(inputform.confirm.value==0) {
		alert(confirmerror);
		inputform.confirm.focus();
		return false;
	}
}
function nextjumin2() {
	if(inputform.jumin1.value.length==6) {
		inputform.jumin2.focus();
	}
}
function nexttel1() {
	if(inputform.jumin2.value.length==7) {
		inputform.tel1.focus();
	}
}
function nexttel2() {
	if(inputform.tel1.value.length==3) {
		inputform.tel2.focus();
	}
}
function nexttel3() {
	if(inputform.tel2.value.length==4) {
		inputform.tel3.focus();
	}
}
function nextemail1() {
	if(inputform.tel3.value.length==4) {
		inputform.email1.focus();
	}
}

//메인페이지
function mainfocus() {
	mainform.id.focus();
}
function maincheck() {
	if(!mainform.id.value) {
		alert(iderror);
		mainform.id.focus();
		return false;
	} else if(!mainform.passwd.value) {
		alert(passwderror);
		mainform.passwd.focus();
		return false;
	}
}

//수정 페이지
function modifyfocus() {
	modifyform.passwd.focus();
}
function modifycheck() {
	if(!modifyform.passwd.value) {
		alert(passwderror);
		modifyform.passwd.focus();
		return false;
	} else if(modifyform.passwd.value!=modifyform.repasswd.value) {
		alert(repasswderror);
		modifyform.repasswd.focus();
		return false;
	} else if(modifyform.tel1.value||modifyform.tel2.value||modifyform.tel3.value) {
		if(modifyform.tel1.value<3||modifyform.tel2.value<3||modifyform.tel3.value<4) {
			alert(telerror);
			modifyform.tel1.focus();
			return false;
		}
	}
	if(modifyform.email1.value||modifyform.email2.value) {
		if((modifyform.email1.value&&!modifyform.email2.value)||(!modifyform.email1.value&&modifyform.email2.value)||(modifyform.email1.value.indexOf("@")!=-1||modifyform.email2.value.indexOf("@")!=-1)) {
			alert(emailerror);
			modifyform.email1.focus();
			return false;
		}
	}
}

//회원탈퇴
function passwdfocus() {
	passwdform.passwd.focus();
}
function passwdcheck() {
	if(!passwdform.passwd.value) {
		alert(passwderror);
		passwdform.passwd.focus();
		return false;
	}
}