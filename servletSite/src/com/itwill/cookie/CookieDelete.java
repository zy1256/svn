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
 * Servlet implementation class CookieDelete
 */
@WebServlet("/CookieDelete")
public class CookieDelete extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		
		Cookie[] cookies=request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			cookies[i].setMaxAge(0);
			cookies[i].setValue("");
			response.addCookie(cookies[i]);
		}
		out.println("<script>");
		out.println("alert('ƒÌ≈∞ªË¡¶');");
		out.println("location.href='07.cookie_create.html';");
		out.println("</script>");
	}

}
