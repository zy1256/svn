/**
 * 
 */
function checkForm() {
	if (isNull(document.join.id.value)) {
		alert("���̵� �Է��ϼ���");
		document.join.id.focus();
		return false;
	}
	if(!isId(document.join.id.value)) {
		alert("���̵� 3~8�ڸ� �����մϴ�.\n���̵� ù�ڴ� �������θ� �����մϴ�.\nƯ�����ڴ� _,-,* �� ��밡���մϴ�.");
		return false;
	}
	if (isNull(document.join.pass.value)) {
		alert("�о����带 �Է��ϼ���");
		document.join.pass.focus();
		return false;
	}
	if (isNull(document.join.repass.value)) {
		alert("�о�����Ȯ���� �Է��ϼ���");
		document.join.repass.focus();
		return false;
	}
	if (!isSame(document.join.pass.value, document.join.repass.value)) {
		alert("�о������ �о����� Ȯ���� ��ġ�ؾ��մϴ�");
		document.join.pass.focus();
		return false;
	}
	if (!isSelect(document.join.job.value)){
		alert("������ ������ �ּ���");
		return false;
	}

	return true;
}

function isId(idValue) {
	/*
	 * ���̵��� ���������� 
	 * 1.���̴� 3���̻� 8������ 
	 * 2.�������� �����Ͽ����Ѵ� 
	 * 3.Ư�����ڸ�����Ҽ�����.(����,����)
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