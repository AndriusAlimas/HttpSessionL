package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LogoutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        out.println("<html><title>HttpServletListener</title>");
	        HttpSession httpSession = request.getSession(false);
	        httpSession.invalidate();
	        out.println("<body><h4>You are succesfully logout</h4>");
	        out.println("</body></html>");
	        
	        out.close();
	}
}
