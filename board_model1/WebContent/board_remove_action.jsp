<%@page import="com.itwill.board.BoardManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	//1. ������ �� ��ȣ �б� (���ų� �߸��� ��� �ڷ� ���� - ���� �������� ����)
	Integer boardno = null;
	try {
		boardno = Integer.valueOf(request.getParameter("boardno"));
	} catch (Exception ex) {
	}
	boolean result = true;
	//�۹�ȣ�� ���ٸ�
	if (boardno == null) {
		result = false;
	} else {
		//2. ���� ó�� (�����ͺ��̽��� ������ ����)
		BoardManager.instance().remove(boardno);
		
	}
%>
<script type="text/javascript">
	
<%if (result) {%>
	alert('�����߽��ϴ�.');
	location.href = 'board_list.jsp';
<%} else{%>
	alert('���� ����');
	//history.back();//���� �������� �̵��ϴ� �ڹٽ�ũ��Ʈ ���
	location.href = 'board_list.jsp';
<%}%>
	
</script>
