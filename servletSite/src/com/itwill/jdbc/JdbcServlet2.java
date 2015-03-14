package com.itwill.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcServlet1
 */
@WebServlet("/JdbcServlet2")
public class JdbcServlet2 extends HttpServlet {

	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1.JdbcServlet2.service() start----->");
		PhoneBookDao phoneBookDao = new PhoneBookDao();
		List<PhoneBook> phoneBookList = null;
		try {
			phoneBookList = phoneBookDao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			//response.sendRedirect("error/error.html");
			//return;
		}
		System.out.println("4.JdbcServlet2.service() continue----->");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/com.css\">");

		out.println("</head>");
		out.println("<body>");
		out.println("<br>");
		out.println("<p align=center><font size=5 color=#0000FF>◈◈ JDBC 테스트 2◈◈</font><br>");
		out.println("<table width=80% align=center border=1 cellspacing=0 bordercolordark=white bordercolorlight=#ADADAD>");
		out.println("<tr bgcolor=#000000 class=t1>");
		out.println("<td align=center height=20 width=25%><font color=#FFFFFF>이름</font></td>");
		out.println("<td align=center height=20 width=25%><font color=#FFFFFF>전화번호</font></td>");
		out.println("<td align=center height=20 width=50%><font color=#FFFFFF>주소</font></td>");
		for (PhoneBook phoneBook : phoneBookList) {
			out.println("</tr>");
			out.println("<tr class=t1>");
			out.println("<td align=center width=25% height=20>"
					+ phoneBook.getName() + "</td>");
			out.println("<td align=center width=25% height=20>"
					+ phoneBook.getPhone() + "</td>");
			out.println("<td align=center width=50% height=20>"
					+ phoneBook.getAddress() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html> ");
	}

}
