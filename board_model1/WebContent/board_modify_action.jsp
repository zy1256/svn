<%@page import="com.itwill.board.BoardManager"%>
<%@page import="com.itwill.board.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%    
 //post ��û�� ��� ��û �����Ϳ� �ѱ� ���ڼ����� ����
if (request.getMethod().toLowerCase().equals("post")) {
	request.setCharacterEncoding("euc-kr");
}

//1. Board ��ü�� ����� ����ڰ� �Է��� �����͸� ����
Board board = new Board();
board.setBoardNo(
	Integer.parseInt(request.getParameter("boardno")));
board.setTitle(request.getParameter("title"));
board.setContent(request.getParameter("content"));

//2. �����ͺ��̽��� ����� ���� ����
BoardManager.instance().update(board);

String pageNo = "1";
if (request.getParameter("pageno") != null) {
	pageNo = request.getParameter("pageno");
}
//3. boardview.jsp�� �̵�
response.sendRedirect(
	String.format("board_view.jsp?boardno=%d&pageno=%s",
	board.getBoardNo(), pageNo));
%>
    
