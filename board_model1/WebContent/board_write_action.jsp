<%@page import="com.itwill.board.BoardManager"%>
<%@page import="com.itwill.board.BoardDao"%>
<%@page import="com.itwill.board.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

//post 요청인 경우 요청 데이터에 한글 문자셋으로 설정
if (request.getMethod().toLowerCase().equals("post")) {
	request.setCharacterEncoding("euc-kr");
}

//1. Board객체를 생성하고 브라우저에서 전송된 사용자 입력 데이터를 객체에 저장
Board board = new Board();
board.setTitle(request.getParameter("title"));
board.setWriter(request.getParameter("writer"));
board.setContent(request.getParameter("content"));

//2. Board 객체에 저장된 데이터를 데이터베이스에 저장
//   BoardDao 클래스를 통해서 수행
BoardManager.instance().create(board);


//3. 목록페이지(boardlist.jsp)로 이동
response.sendRedirect("board_list.jsp");
%>