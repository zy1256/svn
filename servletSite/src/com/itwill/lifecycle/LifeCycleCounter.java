package com.itwill.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle.itwill")
public class LifeCycleCounter extends HttpServlet {
	public LifeCycleCounter() {
		System.out.println("01.LifeCycleCounter 생성자");
	}

	/*
	 * 객체생성시 생성자호출이후에 단한번실행 주로 객체초기화의 용도로사용
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("02.LifeCycleCounter.init()");
	}
	int count=0;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("03.LifeCycleCounter.doGet()...");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("<center>");
		
		count++;
		out.println("현재까지의 서블릿실행회수(페이지뷰수) <font color=#0000FF> "+count+" </font> 번입니다");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}

	/*
	 * 객체가 메모리에서 해제될때 단한번실행 주로 객체자원반납의 용도로사용
	 */
	@Override
	public void destroy() {
		System.out.println("04.LifeCycleCounter.destroy()...");
	}
}
