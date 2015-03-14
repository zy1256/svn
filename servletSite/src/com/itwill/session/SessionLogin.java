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
 * Servlet implementation class SessionLogin
 */
@WebServlet("/SessionLogin")
public class SessionLogin extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			response.sendRedirect("07.session_login.html");
			return;
		}
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		//1.파라메타바끼
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		//2.DB CRUD
		
		/*
		 * id  : guard,xxxx
		 * pass: 1111 ,2222
		 */
		
		boolean isMember1 = id.equals("guard")&& pass.equals("1111");
		boolean isMember2 = id.equals("xxxx")&& pass.equals("2222");
		
		
		if(!(isMember1 || isMember2)){
			out.println("<script>");
			out.println("alert('로그인실패 다시로그인해바바요');");
			out.println("window.location.href='07.session_login.html';");
			out.println("</script>");
			return;
		}
		
		//로그인성공한사람
		HttpSession session=request.getSession();
		session.setAttribute("id", id);
		
		out.println("<h1>로그인성공</h1><hr/>");
		out.println("<h3>"+id+"님 로그인중<h3>");
		out.println("<a href='SessionDelete'>로그아웃</a>");
		out.println("<a href='SessionUse'>회원전용페이지보기</a>");
		
		
	}
	

}
