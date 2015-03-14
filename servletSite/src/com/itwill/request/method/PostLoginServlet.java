package com.itwill.request.method;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLoginServlet
 */
@WebServlet("/postLogin.action")
public class PostLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetLoginServlet :"+request.getMethod());
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();
		/*
		 * 1.��û�����۵Ǵ� ����Ÿ�б�
		 	<< Ŭ���̾�ƮHTML>>
		 	���̵�:<input type="text" name="id"><br/>
			�п���:<input type="password" name="pass"><br/><br/>
			<< ��ûURL >>
			http://192.168.2.1/servletSite/getLogin.itwill?id=guard&pass=1111
			
		 * 
		 */
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		
		/*
		 * 2.DB�� �����ؼ� �α���
		 * 
		 * id  : guard
		 * pass: 1111
		 */
		/*
		 * 3.Ŭ���̾�Ʈ�� ���䵥��Ÿ����
		 */
		 out.println("<h1>�α��ΰ��[GET]</h1>");
		 if(id.equals("guard")&& pass.equals("1111")){
			 //�α��μ���
			 out.println(id+" �� �α��μ���<br/>");
			 out.println("<a href='05-01.login_get.html'>����[POST]</a>");
		 }else{
			 //�α��ν���
			 out.println(id+" �� �ʹ�������<br/>");
			 out.println("<a href='05-01.login_get.html'>�ٽ÷α���[POST]</a>");
		 }
		
		
	}

}
