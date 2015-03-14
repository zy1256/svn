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
		 * 1.요청시전송되는 데이타읽기
		 	<< 클라이언트HTML>>
		 	아이디:<input type="text" name="id"><br/>
			패에쓰:<input type="password" name="pass"><br/><br/>
			<< 요청URL >>
			http://192.168.2.1/servletSite/getLogin.itwill?id=guard&pass=1111
			
		 * 
		 */
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		
		/*
		 * 2.DB에 접근해서 로그인
		 * 
		 * id  : guard
		 * pass: 1111
		 */
		/*
		 * 3.클라이언트에 응답데이타전송
		 */
		 out.println("<h1>로그인결과[GET]</h1>");
		 if(id.equals("guard")&& pass.equals("1111")){
			 //로그인성공
			 out.println(id+" 님 로그인성공<br/>");
			 out.println("<a href='05-01.login_get.html'>메인[POST]</a>");
		 }else{
			 //로그인실패
			 out.println(id+" 님 넌누구세요<br/>");
			 out.println("<a href='05-01.login_get.html'>다시로그인[POST]</a>");
		 }
		
		
	}

}
