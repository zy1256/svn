package com.itwill.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class imgCountServlet
 */
@WebServlet("/imgCountServlet.itwill")
public class imgCountServlet extends HttpServlet {
    
	 int count;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<html>");
			out.println("<body style=font-size:9pt;line-height:140%;>");
			for (int i = 0; i < 8; i++) {
				out.println("<img src='html/images/hufs_icon0"+(i+1)+".png' />");
			}
			out.println("<hr />");
			count++;
			out.println("<img src='html/images/hufs_icon0"+count+".png' />");
			out.println("</body>");
			out.println("</html>");
		}

	

}
