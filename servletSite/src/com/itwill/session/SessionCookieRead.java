package com.itwill.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionCookieRead
 */
@WebServlet("/SessionCookieRead")
public class SessionCookieRead extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		
		Cookie[] cookies=request.getCookies();
		out.println("<h1>¸ðµçÄíÅ°Âï±â</h1><hr/>");
		out.println("<ol>");
		for (int i = 0; i < cookies.length; i++) {
			String name=cookies[i].getName();
			if(name.equals("JSESSIONID")){
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				Cookie newCookie=new Cookie("JSESSIONID-AAA","dssdsa");
				response.addCookie(newCookie);
			}
			String value=cookies[i].getValue();
			out.println("<li>"+name+":"+value+"</li>");
			
		}
		out.println("</ol>");
	}

}
