package com.itwill.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
		responce.setContentType("text/html;charset=euc-kr");
		PrintWriter out = responce.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>방가워요 서블릿</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<center><H2>서블릿 잘났어 정말 별꼴이야!!!!!!!!!</H2><center>");
		out.println("<img src='tomcat.gif'/>");
		out.println("<img src='images/pug.gif'/>");

		out.println("<center><H2>서블릿 구구단</H2></center>");
		out.println("<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600 cellspacing=0>");
		for (int i = 0; i < 8; i++) {
			out.println("<tr>");
			for (int j = 0; j < 9; j++) {
				out.println("<td align=center>2*1=2</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<br/>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

}
