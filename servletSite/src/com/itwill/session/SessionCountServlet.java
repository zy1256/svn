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
 * Servlet implementation class SessionCountServlet
 */
@WebServlet("/SessionCountServlet")
public class SessionCountServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		boolean isNew  = session.isNew();
		String sessionID=session.getId();
		int sessionInterval=session.getMaxInactiveInterval();
		long creationTime=session.getCreationTime();
		long lastAccessTime=session.getLastAccessedTime();
		
		System.out.println(">>요청IP-->"+request.getRemoteAddr()+":"+sessionID);
		System.out.println(">>요청IP-->"+request.getRemoteAddr()+":"+session);
		/********************/
		Integer countInt=(Integer)session.getAttribute("count");
		int count=0;
		if(countInt==null){
			//최초요청(????)
			count=0;
		}else{
			//2번째이후
			count=countInt.intValue();
		}
		count++;
		session.setAttribute("count", new Integer(count));
		/*********************/
		out.println("<h1>Session Count</h1>");
		out.println("<hr/>");
		out.println("<ol>");
		out.println("<li>세션생성여부:"+isNew+"</li>");
		out.println("<li>세션ID:"+sessionID+"</li>");
		out.println("<li>세션유효기간:"+sessionInterval+"</li>");
		out.println("<li>세션생성시간:"+creationTime+"</li>");
		out.println("<li>세션마지막바인딩시간:"+lastAccessTime+"</li>");
		out.println("<li>"+count+"번째 방문이시군요!!!브라우져님<li>");
		out.println("<ol>");
		out.println("<a href='SessionCookieRead'>세션쿠키읽기</a>");
		
	}

}
