<%@page import="com.itwill.board.Board"%>
<%@page import="com.itwill.board.BoardManager"%>
<%@page contentType="text/html; charset=euc-kr"%>
<%
	//목록 페이지에서 선택한 글의 번호를 읽어서 변수에 저장
	Integer boardno = null;
    int pageno = 1;
	try {
		boardno = Integer.valueOf(request.getParameter("boardno"));
		pageno = Integer.valueOf(request.getParameter("pageno"));
	} catch (Exception ex) {
	}
	//글번호가 없다면
	if (boardno == null) {
		//목록으로 이동
		response.sendRedirect("board_list.jsp?pageno="+pageno);
		return;
	}
	Board board  = BoardManager.instance().findBoard(boardno);
	if (board == null) {//조회된 글이 없다면
		//목록으로 이동
		response.sendRedirect("board_list.jsp?pageno="+pageno);
		return;
	}
	BoardManager.instance().updateHitCount(boardno);
%>

<html>
<head>
<title>게시물 내용보기</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="./css/board.css" type="text/css">
<script language="JavaScript">
	function boardCreate() {
		f.action = "board_write.jsp";
		f.submit();
	}
	function boardReplyCreate() {
		f.action = "board_reply_write.jsp";
		f.submit();
	}
	function boardUpdate() {
		f.action = "board_modify.jsp";
		f.submit();
	}
	function boardRemove() {
		if (confirm("정말 삭제하시겠습니까?")) {
			f.action = "board_remove_action.jsp";
			f.submit();
		}
	}
	function boardList() {
		f.action = "board_list.jsp?pageno="+<%=pageno%>;
		f.submit();
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
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b> 게시물
								내용보기 </b>
						</td>
					</tr>
				</table> <br> <!-- view Form  -->
				<form name="f" method="post">
					<input type="hidden" name="boardno" value="<%=boardno%>">
					<input type="hidden" name="pageno" value="<%=pageno%>">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">글쓴이</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10"><%=board.getWriter()%></td>
						</tr>

						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10"><%=board.getTitle()%></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10"><%=board.getContent()%></td>
						</tr>
						
					</table>
					
				</form> <br>
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center>
						<input type="button" value="글쓰기"
							onClick="boardCreate()"> &nbsp;
							<input type="button" value="답글쓰기"
							onClick="boardReplyCreate()"> &nbsp;
							 
						<input type="button" value="수정"
							onClick="boardUpdate()"> &nbsp; <input type="button"
							value="삭제" onClick="boardRemove()"> &nbsp; <input
							type="button" value="리스트" onClick="boardList()"></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>
</body>
</html>