package com.servlet;
import java.io.IOException;
import javax.servlet.*;



public abstract class FirstSErvlet implements Servlet{
	ServletConfig config;

// Life Cycle Method
	@Override
	public void init(ServletConfig config) {
		this.config = config;
		
		System.out.println("Init method to be started ");
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)  throws ServletException, IOException {
		System.out.println("Service method is started");
	}
	
	@Override
	public void destroy() {
		
		System.out.println("Destroy serlter object obejct method is started");
	}

	// Non - Live Life Servlet method
	
	@Override
	public ServletConfig getServletConfig()
	{
		return this.config;
	}
	@Override
	public String getServletInfo()
	{
		return "This servlet is created by solanki";
		
	}
	
	
}
