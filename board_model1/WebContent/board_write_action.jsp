<%@page import="com.itwill.board.BoardManager"%>
<%@page import="com.itwill.board.BoardDao"%>
<%@page import="com.itwill.board.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

//post ��û�� ��� ��û �����Ϳ� �ѱ� ���ڼ����� ����
if (request.getMethod().toLowerCase().equals("post")) {
	request.setCharacterEncoding("euc-kr");
}

//1. Board��ü�� �����ϰ� ���������� ���۵� ����� �Է� �����͸� ��ü�� ����
Board board = new Board();
board.setTitle(request.getParameter("title"));
board.setWriter(request.getParameter("writer"));
board.setContent(request.getParameter("content"));

//2. Board ��ü�� ����� �����͸� �����ͺ��̽��� ����
//   BoardDao Ŭ������ ���ؼ� ����
BoardManager.instance().create(board);


//3. ���������(boardlist.jsp)�� �̵�
response.sendRedirect("board_list.jsp");
%>