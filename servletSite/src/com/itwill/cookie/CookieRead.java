package com.itwill.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieRead
 */
@WebServlet("/CookieRead")
public class CookieRead extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		
		Cookie[] cookies=request.getCookies();
		if(cookies==null){
			out.println("<script>");
			out.println("alert('쿠키설정해라친구야..');");
			out.println("window.location.href='07.cookie_create.html';");
			out.println("</script>");
		}
		String talent="";
		String time="";
		for (int i = 0; i < cookies.length; i++) {
			String name=cookies[i].getName();
			if(name.equals("talent")){
				talent=cookies[i].getValue();
			}
			if(name.equals("time")){
				time = cookies[i].getValue();
			}
		}
		out.println("<h1>읽은쿠키정보</h1>");
		out.println("time cookie  value(memory):"+time+"<br/>");
		out.println("talent cookie  value(file):"+talent+"<br/>");
		out.println("<a href='CookieDelete'>쿠키삭제</a>");
		
	}

}
