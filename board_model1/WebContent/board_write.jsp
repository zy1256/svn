<%@page contentType="text/html;charset=euc-kr"%>
<html>
<head>
<title>�Խ���</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/board.css" type="text/css">
<script type="text/javascript">
	function boardCreate() {
		if (f.title.value == "") {
			alert("������ �Է��Ͻʽÿ�.");
			f.title.focus();
			return false;
		}
		if (f.writer.value == "") {
			alert("�ۼ��ڸ� �Է��Ͻʽÿ�.");
			f.writer.focus();
			return false;
		}
		if (f.content.value == "") {
			alert("������ �Է��Ͻʽÿ�.");
			f.content.focus();
			return false;
		}

		f.action = "board_write_action.jsp";
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
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>�Խ��� - �Խ���
								����</b></td>
					</tr>
				</table> <br> <!-- write Form  -->
				<form name="f" method="post">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">����</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 150" name="title"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">�ۼ���</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10"><input
								type="text" style="width: 150" name="writer"></td>
						</tr>
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">����</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10">
							<textarea
									name="content" style="width:480" rows="15"></textarea>
							</td>
						</tr>
						<!-- 
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">����</td>
							<td width=490 bgcolor="ffffff" style="padding-left: 10"><input
								type="file" style="width: 450" name="file1"></td>
						</tr>
						 -->
					</table>
				</form> <br>

				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td align=center><input type="button" value="�Խ��� ����"
							onClick="boardCreate()"> &nbsp; <input type="button"
							value="�Խ��� ���" onClick="boardList()"></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

</body>
</html>
