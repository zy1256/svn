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
		
		System.out.println(">>��ûIP-->"+request.getRemoteAddr()+":"+sessionID);
		System.out.println(">>��ûIP-->"+request.getRemoteAddr()+":"+session);
		/********************/
		Integer countInt=(Integer)session.getAttribute("count");
		int count=0;
		if(countInt==null){
			//���ʿ�û(????)
			count=0;
		}else{
			//2��°����
			count=countInt.intValue();
		}
		count++;
		session.setAttribute("count", new Integer(count));
		/*********************/
		out.println("<h1>Session Count</h1>");
		out.println("<hr/>");
		out.println("<ol>");
		out.println("<li>���ǻ�������:"+isNew+"</li>");
		out.println("<li>����ID:"+sessionID+"</li>");
		out.println("<li>������ȿ�Ⱓ:"+sessionInterval+"</li>");
		out.println("<li>���ǻ����ð�:"+creationTime+"</li>");
		out.println("<li>���Ǹ��������ε��ð�:"+lastAccessTime+"</li>");
		out.println("<li>"+count+"��° �湮�̽ñ���!!!��������<li>");
		out.println("<ol>");
		out.println("<a href='SessionCookieRead'>������Ű�б�</a>");
		
	}

}
