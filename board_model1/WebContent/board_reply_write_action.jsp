<%@page import="com.itwill.board.BoardManager"%>
<%@page import="com.itwill.board.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setCharacterEncoding("euc-kr");
//2. Board ��ü�� �����ϰ� �Էµ� �����͸� �о ��ü�� ����
Board board = new Board();
board.setBoardNo(
Integer.parseInt(request.getParameter("boardno")));
board.setTitle(request.getParameter("title"));
board.setWriter(request.getParameter("writer"));
board.setContent(request.getParameter("content"));

//3. �����ͺ��̽��� ���� ���� ����
BoardManager boardManager =BoardManager.instance();
boardManager.createReply(board);

//4. boardview.jsp �̵�
String pageno = "1";
if (request.getParameter("pageno") != null)
	pageno = request.getParameter("pageno");

response.sendRedirect(
		String.format("board_list.jsp?pageno=%s",pageno));
%>

