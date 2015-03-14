package com.itwill.hello;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//#1. javax.servlet.http.HttpServlet 클래스를 상속 받아야한다.
public class HelloServlet extends HttpServlet{
	@Override
	//#2. HttpServlet doGet() 메쏘드를 오버라이딩 해야한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//#2-1.  클라이언트에 전송할 데이타의 타입(종류)설정 
		response.setContentType("text/html;charset=euc-kr");
		//#2-2.  클라이언트에데이타를 전송하기위한 출력스트림 생성
		PrintWriter out = response.getWriter();
		//#2-3. 클라이언트로 데이타(HTML) 전송
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
