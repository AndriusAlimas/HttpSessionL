package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
		// set content type with response:
		response.setContentType("text/html");
		// get PrintWriter using response object method getWriter() NOT getPrintWriter():
        PrintWriter out = response.getWriter();
        out.println("<html><title>HttpServletListener</title>");
        // using request we get parameter from form(Query String):
        String userName = request.getParameter("userName");
        out.println("<body>Welcome <h4>" + userName + " </h4>");
        
        // HttpServletRequest interface has method to get session object:
        HttpSession httpSession = request.getSession();
        // invoking from session scope setAttribute from session:
        httpSession.setAttribute("userName", userName);
        
        // simple hyperlink to another servlet:
        out.println("<br><a href='logout.do'>logout</a>");
        out.println("</body></html>");
        out.close();
	}
}
