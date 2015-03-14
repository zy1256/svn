package com.itwill.join;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet.action")
public class JoinServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			response.sendRedirect("05.form.html");
			return;
		}
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		/*
		 * 1.�Ķ��Ÿ�ٳ�
		 * 2.DB CRUD
		 * 3.�������
		 */
		request.setCharacterEncoding("euc-kr");
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String gender=request.getParameter("gender");
		String job=request.getParameter("job");
		String[] hobbies=request.getParameterValues("hobby");
		
		
		/*
		 * ����(table)
		 */
		/*out.println("<ol>");
		out.println("<li>" + id + "</li>");
		out.println("<li> " + pass + "</li>");
		out.println("<li>" + name + "</li>");
		out.println("<li>" + addr + "</li>");
		out.println("<li>" + gender + "</li>");
		out.println("<li>" + job + "</li>");
		out.println("<li>" + hobbies + "</li>");
		out.println("</ol>");*/
		out.println("<h1>ȸ������</h1>");
		out.println("<table style='border:1px solid #eee'>");
		out.println("<tr><th style='border-right:1px solid #eee;border-bottom:1px solid #eee;background:#f9f9f9'>���̵�</th><td style='border-bottom:1px solid #eee'>"+id+"</td></tr>");
		out.println("<tr><th style='border-right:1px solid #eee;border-bottom:1px solid #eee;background:#f9f9f9'>��й�ȣ</th><td style='border-bottom:1px solid #eee'>"+pass+"</td></tr>");
		out.println("<tr><th style='border-right:1px solid #eee;border-bottom:1px solid #eee;background:#f9f9f9'>�̸�</th><td style='border-bottom:1px solid #eee'>"+name+"</td></tr>");
		out.println("<tr><th style='border-right:1px solid #eee;border-bottom:1px solid #eee;background:#f9f9f9'>�ּ�</th><td style='border-bottom:1px solid #eee'>"+addr+"</td></tr>");
		out.println("<tr><th style='border-right:1px solid #eee;border-bottom:1px solid #eee;background:#f9f9f9'>����</th><td style='border-bottom:1px solid #eee'>"+gender+"</td></tr>");
		out.println("<tr><th style='border-right:1px solid #eee;border-bottom:1px solid #eee;background:#f9f9f9'>����</th><td style='border-bottom:1px solid #eee'>"+job+"</td></tr>");

		if(hobbies ==null){
			out.println("<tr><td colspan='2'>��̾����ϴ�.</td></tr>");
		}
		if(hobbies != null){
			int hobbiesCount = hobbies.length;
			boolean flag = true;
			for (String string : hobbies) {
			out.println("<tr>");
				if(flag==true){
					out.println("<th rowspan='"+ hobbiesCount +"' style='border-right:1px solid #eee;background:#f9f9f9'>���</th>");
					flag=false;
				}
			out.println("<td>"+string +"</td>");
			out.println("</tr>");
			}
		}
		out.println("</table>");
		
	}

}
