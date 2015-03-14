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
		System.out.println("01.LifeCycleCounter ������");
	}

	/*
	 * ��ü������ ������ȣ�����Ŀ� ���ѹ����� �ַ� ��ü�ʱ�ȭ�� �뵵�λ��
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
		out.println("��������� ��������ȸ��(���������) <font color=#0000FF> "+count+" </font> ���Դϴ�");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

	}

	/*
	 * ��ü�� �޸𸮿��� �����ɶ� ���ѹ����� �ַ� ��ü�ڿ��ݳ��� �뵵�λ��
	 */
	@Override
	public void destroy() {
		System.out.println("04.LifeCycleCounter.destroy()...");
	}
}
