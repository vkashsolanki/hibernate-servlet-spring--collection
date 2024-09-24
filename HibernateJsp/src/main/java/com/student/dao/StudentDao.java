package com.student.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sessionfactory.SessionFactoryProvider;
import com.student.bean.Student;

public class StudentDao {	

	public String getRegister(Student student)
	{
	
       try {
      	   
   		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
   		Session session = factory.openSession();
   		System.out.println(session);
   		Transaction transaction = session.beginTransaction();
   		session.save(student);
   		transaction.commit();
     		
   		if(student != null) {
   			return "success";
   			
   		}else
   		{
   			return "fail";
   			
   		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		return null;
				
	}

}
