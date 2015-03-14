package com.itwill.hello;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//#1. javax.servlet.http.HttpServlet Ŭ������ ��� �޾ƾ��Ѵ�.
public class HelloServlet extends HttpServlet{
	@Override
	//#2. HttpServlet doGet() �޽�带 �������̵� �ؾ��Ѵ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//#2-1.  Ŭ���̾�Ʈ�� ������ ����Ÿ�� Ÿ��(����)���� 
		response.setContentType("text/html;charset=euc-kr");
		//#2-2.  Ŭ���̾�Ʈ������Ÿ�� �����ϱ����� ��½�Ʈ�� ����
		PrintWriter out = response.getWriter();
		//#2-3. Ŭ���̾�Ʈ�� ����Ÿ(HTML) ����
		out.println("<html>");
		out.println("<body>");
		for (int i = 0; i < 1000; i++) {
			out.println("<h1>Hello Servlet!!"+ (i+1) +"</h1>");
			out.println("<hr />");
		}
		out.println("</body>");
		out.println("</html>");

	}
}
