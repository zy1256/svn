package com.itwill.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageCounterServlet
 */
@WebServlet("/ImageCounterServlet")
public class ImageCounterServlet extends HttpServlet {
	int count;
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("<center>");
		count++;
		
		String countStr=count+"";
		
		for(int i=0;i<countStr.length();i++){
			char numChar=countStr.charAt(i);
			out.println("<img src='images/"+numChar+".png'/>");
		}
		
		
		
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
