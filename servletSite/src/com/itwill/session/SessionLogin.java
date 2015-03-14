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
		//1.�Ķ��Ÿ�ٳ�
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
			out.println("alert('�α��ν��� �ٽ÷α����عٹٿ�');");
			out.println("window.location.href='07.session_login.html';");
			out.println("</script>");
			return;
		}
		
		//�α��μ����ѻ��
		HttpSession session=request.getSession();
		session.setAttribute("id", id);
		
		out.println("<h1>�α��μ���</h1><hr/>");
		out.println("<h3>"+id+"�� �α�����<h3>");
		out.println("<a href='SessionDelete'>�α׾ƿ�</a>");
		out.println("<a href='SessionUse'>ȸ����������������</a>");
		
		
	}
	

}
