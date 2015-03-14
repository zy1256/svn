package com.itwill.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HttpServletRequestDemo")
public class HttpServletRequestDemo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html ;charset=euc-kr");
		PrintWriter out=response.getWriter();
		
		String address=request.getRemoteAddr();
		String requestURI = request.getRequestURI();
		int remotePort=request.getRemotePort();
		String ce=request.getCharacterEncoding();
		String ct=request.getContentType();
		String method=request.getMethod();
		
		out.println("<ul>");
		out.println("<li>address:"+address+"</li>");
		out.println("<li>requestURI:"+requestURI+"</li>");
		out.println("<li>remotePort:"+remotePort+"</li>");
		out.println("<li>character encoding : "+ce+"</li>");
		out.println("<li>content type:"+ct+"</li>");
		out.println("<li>request method:"+method+"</li>");
	
		out.println("<li>------ ฟไรป header ต้--------</li>");
		Enumeration<String> headerNames=request.getHeaderNames();
		
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.println("<li>"+headerName+":"
					+request.getHeader(headerName)+"</li>");
		}
		out.println("</ul>");
		
	}

}
