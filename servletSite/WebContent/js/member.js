/**
 * 
 */
function checkForm() {
	if (isNull(document.join.id.value)) {
		alert("아이디를 입력하세요");
		document.join.id.focus();
		return false;
	}
	if(!isId(document.join.id.value)) {
		alert("아이디를 3~8자만 가능합니다.\n아이디 첫자는 영문으로만 가능합니다.\n특수문자는 _,-,* 만 사용가능합니다.");
		return false;
	}
	if (isNull(document.join.pass.value)) {
		alert("패쓰워드를 입력하세요");
		document.join.pass.focus();
		return false;
	}
	if (isNull(document.join.repass.value)) {
		alert("패쓰워드확인을 입력하세요");
		document.join.repass.focus();
		return false;
	}
	if (!isSame(document.join.pass.value, document.join.repass.value)) {
		alert("패쓰워드와 패쓰워드 확인이 일치해야합니다");
		document.join.pass.focus();
		return false;
	}
	if (!isSelect(document.join.job.value)){
		alert("직업을 선택해 주세요");
		return false;
	}

	return true;
}

function isId(idValue) {
	/*
	 * 아이디의 적절성여부 
	 * 1.길이는 3자이상 8자이하 
	 * 2.영문으로 시작하여야한다 
	 * 3.특수문자를사용할수없다.(숫자,문자)
	 */

	for (i=0;i<idValue.length ;i++ ){
	 ch=idValue.charAt(i);
	  if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z') && !(ch>='A' && ch<='Z') && !(ch=='_') && !(ch=='-') && !(ch=='*')){
		  return false;
	  }
	}
	if (idValue.length<3 || idValue.length>8){
		return false;
	}
	ch0=idValue.charAt(0);
	if(!(ch0>='a' && ch0<='z') && !(ch0>='A' && ch0<='Z')){
		return false;
	}
	return true;
} 

function isSelect(jobValue){
	if(jobValue=='SELECTJOB'){
		return false;
	}
	return true;
}