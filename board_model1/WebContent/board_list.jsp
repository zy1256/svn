<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@page import="com.itwill.util.ListResultBean"%>
<%@page import="com.itwill.util.ListPageConfigBean"%>
<%@page import="com.itwill.board.BoardManager"%>
<%@page import="com.itwill.board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.board.BoardDao"%>
<%@page contentType="text/html;charset=euc-kr"%>
<%! //선언문 : 메서드나 변수를 선언하는 스크립트 영역
String getTitleString(Board board) {	
	StringBuilder title = new StringBuilder(128);
	
	String t = board.getTitle();
	//제목이 너무 길면 말줄임표 표시
	if (t.length() > 15) {
		t = String.format("%s...", t.substring(0, 10));
	}	
	//들여쓰기 깊이 만큼 공백 삽입
	for (int i = 0; i < board.getDepth(); i++) {
		title.append("&nbsp;&nbsp;");
	}
	//들여쓰기 이미지 삽입
	if (board.getDepth() > 0) {
		title.append("<img border='0' src='image/re.gif'/>");
	}
	title.append(t.replaceAll(" ", "&nbsp;"));
	return title.toString();
}
%>
<%
	String pageno = request.getParameter("pageno");//요청페이지번호
	if (pageno == null || pageno.equals(""))
		pageno = "1";

	int rows = 10; //한 페이지에 표시할 데이터 건수
	int pageCount = 5; //한 번에 보여줄 페이지 번호 갯수

	// 페이지 설정
	ListPageConfigBean pageConfig = new ListPageConfigBean(rows,
			pageCount, pageno, "", "");
	//데이터베이스에서 게시물 목록 조회
	ListResultBean boardListPage = BoardManager.instance().findBoardList(pageConfig);
	List<Board> boardList = boardListPage.getList();
	
%>



<html>
<head>
<title>게시판</title>
<link rel=stylesheet href="./css/board.css" type="text/css">
<script language="JavaScript">
	function boardCreate() {
		location.href="board_write.jsp";
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<br>
	<table width=780 border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td width="20"></td>
			<td>
				<!--contents-->
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>게시판-리스트</b>
						</td>
					</tr>
					<tr bgcolor="#FFFFFF" valign="middle">
						<td height="20" class="t1" align="right" valign="bottom">♠ 총
							<font color="#FF0000"><%=boardListPage.getRowCount()%></font> 건 | 현재페이지( <font
							color="#FF0000"><%=boardListPage.getSelectPageNo()%></font> / <font
							color="#0000FF"><%=boardListPage.getPageCount()%></font> )
						</td>
					</tr>
				</table> <br> <!-- list -->
				<table border="0" cellpadding="0" cellspacing="1" width="590"
					bgcolor="BBBBBB">

					<tr>
						<td width=280 align=center bgcolor="E6ECDE">제목</td>
						<td width=120 align=center bgcolor="E6ECDE">글쓴이</td>
						<td width=120 align=center bgcolor="E6ECDE">글쓴날</td>
						<td width=70 align=center bgcolor="E6ECDE">본횟수</td>
					</tr>
					<%
						for (int i = 0; i < boardList.size(); i++) {
							Board board = boardList.get(i);
					%>
					<tr>
						<td width=280 bgcolor="ffffff" style="padding-left: 10"><a
							href='board_view.jsp?boardno=<%=board.getBoardNo()%>&pageno=<%=pageno%>'><%=getTitleString(board)%></a>
						</td>
						<td width=120 align=center bgcolor="ffffff"><%=board.getWriter()%>
						</td>
						<td width=120 bgcolor="ffffff" style="padding-left: 10"><%=board.getRegDate()%>
						</td>
						<td width=70 align=center bgcolor="ffffff"><%=board.getReadCount()%>
						</td>
					</tr>
					<%
						}
					%>

				</table> <!-- /list --> <br>
				<table border="0" cellpadding="0" cellspacing="1" width="590">
					<tr>
						<td align="center">

<%
	if(boardListPage.isShowFirst()){
%>		
		<a href="./board_list.jsp?pageno=1">◀◀</a>&nbsp;&nbsp;
<%
	}
	if(boardListPage.isShowPreviousGroup()){
		
%><a href="./board_list.jsp?pageno=<%=boardListPage.getPreviousGroupStartPageNo()%>">◀</a>&nbsp;&nbsp;<%		
	}
 	for (int i = boardListPage.getStartPageNo();i<=boardListPage.getEndPageNo() ; i++) {

	if(boardListPage.getSelectPageNo()==i){
%>		
		<font color='red'><strong><%=i%></strong></font>&nbsp;&nbsp;
<%	
	}else{
%>
		<a href="./board_list.jsp?pageno=<%=i%>"><strong><%=i%></strong></a>&nbsp;&nbsp;
<%
	}
	}
if(boardListPage.isShowNextGroup()){
 %>
 <a href="./board_list.jsp?pageno=<%=boardListPage.getNextGroupStartPageNo()%>">▶&nbsp;&nbsp;</a>
 <%
}
if(boardListPage.isShowLast()){
%>		
	<a href="./board_list.jsp?pageno=<%=boardListPage.getPageCount()%>">▶▶</a>&nbsp;&nbsp;
<%
}
%>
						</td>
					</tr>
				</table> <br> <!-- button -->
				<table border="0" cellpadding="0" cellspacing="1" width="590">
					<tr>
						<td align="right"><input type="button" value="게시물 생성" onclick="boardCreate();"/></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>