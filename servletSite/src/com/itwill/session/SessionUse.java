package com.itwill.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionUse
 */
@WebServlet("/SessionUse")
public class SessionUse extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		if(id==null){
			out.println("<script>");
			out.println("alert('로그인해주셔야 볼수있는페이지입니다.');");
			out.println("window.location.href='07.session_login.html';");
			out.println("</script>");
			return;
		}
		out.println("<h1>회원전용페이지</h1><hr/>");
		out.println("<h3>"+id+"님 로그인중<h3>");
		out.println("<a href='SessionDelete'>로그아웃</a>");
		out.println("<ol>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("<li>좋은그림</li>");
		out.println("</ol>");
		
		
		
	}


}
