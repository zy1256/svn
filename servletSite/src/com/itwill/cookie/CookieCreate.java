package com.itwill.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCreate
 */
@WebServlet("/CookieCreate")
public class CookieCreate extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		/*
		 * ��ûURL-->
		 * http://192.168.2.1/servletSite/CookieCreate?talent=ses
		 */
		String talent =request.getParameter("talent");
		if(talent==null){
			//response.sendRedirect("07.cookie_create.html");
			out.println("<script>");
			out.println("alert('�߸��������Դϴ�..');");
			out.println("window.location.href='07.cookie_create.html';");
			out.println("</script>");
			return;
		}
		Cookie tCookie=new Cookie("talent", talent);
		String timeStr=new Date().toString();
		Cookie timeCookie=new Cookie("time",timeStr);
		/*
		 * ������ ���Ϸ�����
		 */
		tCookie.setMaxAge(60*60*24);
		
		response.addCookie(tCookie);
		response.addCookie(timeCookie);
		
		out.println("<h1>Cookie ����</h1>");
		out.println("<hr/>");
		out.println("<h2>�Ͼȿ� ��Ű�ִ�</h2>");
		out.println("<a href='CookieRead'>��Ű�б�</a>");
		
	}

}
