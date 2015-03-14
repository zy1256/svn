<%@page import="com.itwill.board.Board"%>
<%@page import="com.itwill.board.BoardManager"%>
<%@page contentType="text/html;charset=euc-kr"%>
        <%
        //댓글의 대상 글번호를 읽어서 변수에 저장
		//(대상 글번호는 boardview.jsp에서 전송된 데이터)
		if (request.getParameter("boardno") == null) {
			response.sendRedirect("board_list.jsp");
			return;
		}
		int boardno = Integer.parseInt(
			request.getParameter("boardno"));
		//댓글  대상글의 번호로 데이터베이스에서 조회
		BoardManager boardManager = BoardManager.instance();
		Board board = boardManager.findBoard(boardno);
		//조회 실패하면 목록으로 이동
		if (board == null) {
			response.sendRedirect("board_list.jsp");
			return;			
		}
		String pageno = "1";
		if (request.getParameter("pageno") != null)
			pageno = request.getParameter("pageno");
		%>
<html>
<head>
<title>게시판답글달기</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/board.css" type="text/css">
<script language="JavaScript">
	function boardReplayCreate() {
		if (f.title.value == "") {
			alert("제목을 입력하십시요.");
			f.title.focus();
			return false;
		}
		if (f.writer.value == "") {
			alert("작성자를 입력하십시요.");
			f.writer.focus();
			return false;
		}
		if (f.content.value == "") {
			alert("내용을 입력하십시요.");
			f.content.focus();
			return false;
		}
		f.action = "board_reply_write_action.jsp";
		f.submit();
	}

	function boardList() {
		f.action = "board_list.jsp";
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
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>게시판 - 게시판 답글
								쓰기</b></td>
					</tr>
				</table> <br> <!-- write Form  -->
				<form name="f" method="post">
				<input type="hidden" name="pageno" 
		        	value="<%=pageno%>" />
		        <%-- 댓글을 작성할 대상글의 글번호를 저장 / submit 할 때 서버로 전송 --%>
		        <input type="hidden" name="boardno" 
		        	value="<%=board.getBoardNo()%>"/>
		        	
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10">
							<input
								value="[RE]<%= board.getTitle() %>" 
								type="text" style="width: 150" name="title"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">작성자</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10">
							<input
								value="<%= board.getWriter()%>"
								type="text" style="width: 150" name="writer"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10">
							<textarea
									name="content" style="width:480" rows="15">>><%=board.getContent().replace("\n",">>").trim()%></textarea>
							</td>
						</tr>
						
						
					</table>
				</form> <br>

				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center><input type="button" value="게시판 답글 쓰기"
							onClick="boardReplayCreate()"> &nbsp; <input type="button"
							value="게시판 목록" onClick="boardList()"></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

</body>
</html>
