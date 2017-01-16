package com.example.listener;
import javax.servlet.ServletContext;
import javax.servlet.http.*;

public class MyHttpSessionListener implements HttpSessionListener {
	// default variable:
	ServletContext ctx = null;
	// static counter variables, we use for counting:
    static int totalUserCount = 0;
    static int currentUserCount = 0;
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("\n*************************");
        System.out.println("********** sessionCreated method run ***************");
        // ofcourse from http session event we can get session object:
        HttpSession httpSession = event.getSession();
        System.out.println("We get HttpSession " + httpSession + " object, from event reference ");
        
  // String getId() returns a string containing the unique identifier assigned to this session.
  // The identifier is assigned by the servlet container and is implementation dependent.
  // int getMaxInactiveInterval() returns the maximum time interval, in seconds, that the
  // servlet container will keep this session open between client accesses. After this
  // interval, the servlet container will invalidate the session. The maximum time interval 
  // can be set with the setMaxInactiveInterval method. A return value of zero or less
  // indicates that the session will never timeout: 
        System.out.println("ID = " + httpSession.getId() + " , MaxInactiveInterval = " + httpSession.getMaxInactiveInterval());
        // we can reach from http session event to servlet context :
        ctx = httpSession.getServletContext();
        System.out.println("********** from session we getting context object ***************");
        System.out.println("********** we setting attributes in context scope ***************");
        ctx.setAttribute("totalUsers", ++totalUserCount);
        // dont do any bad if you ask from this. When we logging we increment current user per session: 
        this.ctx.setAttribute("currentUsers", ++currentUserCount);
        System.out.println("method complete, before creating session ");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("\n*************************");
        System.out.println("********** sessionDestroyed() method run ***************");
        HttpSession httpSession = event.getSession();
        System.out.println("We get HttpSession " + httpSession + " object, from event reference ");
        System.out.println("ID = " + httpSession.getId() + " , MaxInactiveInterval = " + httpSession.getMaxInactiveInterval());
        // when session done, close, we just decrement current user:
        ctx.setAttribute("currentUsers", --currentUserCount);
        System.out.println("method complete, before destroying session ");
		
	}
}
