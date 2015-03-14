package com.itwill.mime;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendImageServlet
 */
@WebServlet("/SendMP3Servlet.action")
public class SendMP3Servlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("audio/x-mpeg");
		OutputStream out = response.getOutputStream();
		
		//image file path
		ServletContext context=getServletContext();
		String realPath=context.getRealPath("/images/test.mp3");
		System.out.println("realPath:"+realPath);
		//image file loading
		FileInputStream fis=new FileInputStream(realPath);
		
		while (true) {
			int readByte=fis.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		fis.close();
		out.flush();
	}

}
