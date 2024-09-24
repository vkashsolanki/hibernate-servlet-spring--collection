package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

/**
 * Servlet implementation class BlServlet
 */
public class BlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		
		System.out.println(name+" "+email+" "+mobile+" "+password);
		
		
		try
		{
			Configuration configuration=new Configuration();
			configuration.configure("configurations/hibernate.cfg.xml");
			SessionFactory sessionFactory=configuration.buildSessionFactory();
			Session session=sessionFactory.openSession();
			System.out.println(session);
			
			Transaction transaction=session.beginTransaction();
			Employee st=new Employee(1,name,email,mobile,password);
			session.save(st);
			transaction.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
