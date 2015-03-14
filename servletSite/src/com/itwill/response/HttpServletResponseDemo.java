package com.itwill.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HttpServletResponseDemo.action")
public class HttpServletResponseDemo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("HttpServletResponseDemo.doGet()..");
		String cmd = request.getParameter("cmd");
		if(cmd==null){
			response.sendRedirect("error/error.htm");
			return;
		}
		if(cmd.equals("1")){
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<h1>HttpsServletRespnse</h1>");
			out.println("<hr />");
			out.println("<p>정상응답</p>");
		}else if (cmd.equals("2")){
			//error응답
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		}else if(cmd.equals("3")){
			//redirection(응답해더)
			response.sendRedirect("04.HttpServletResponse.html");
		}
		
	}


}
