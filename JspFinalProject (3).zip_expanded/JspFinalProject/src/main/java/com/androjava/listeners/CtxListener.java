package com.androjava.listeners;
import java.io.InputStream;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

import com.androjava.util.DBInitializer;

@WebListener
public class CtxListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent c) {
		
	}

	public void contextInitialized(ServletContextEvent c) {
		ServletContext ctx=c.getServletContext();
		String param=ctx.getInitParameter("createTables");
		if (param.equals("yes"))
		{
			System.out.println("creating tables...");		 
		    InputStream p = this.getClass().getClassLoader().getResourceAsStream("table.sql");
			DBInitializer db=new DBInitializer();
			db.createTables(p);
		 
		}
	}

}
