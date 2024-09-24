package com.servletsjava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.study.entity.Student;

public class ServletSeProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletSeProgram() {
        super();
       
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		System.out.println(name+" "+email+" "+mobile+" "+password);
				
		
		try {
			
			Configuration configuration = new Configuration();
			configuration.configure("configuration_File/hibernate.cfg.xml");
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
		   Student student = new Student(0, name, email, mobile, password);
			session.save(student);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
