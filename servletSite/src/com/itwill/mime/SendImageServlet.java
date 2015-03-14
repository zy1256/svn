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
@WebServlet("/SendImageServlet.action")
public class SendImageServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		
		//image file path
		
		ServletContext context=getServletContext();
		String realPath=context.getRealPath("/images/album.jpg");
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
