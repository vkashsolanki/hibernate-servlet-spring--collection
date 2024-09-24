package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
try {
	
    Configuration configuration = new Configuration();
    configuration.configure("com/hibernate/hibernate.cfg.xml");
    SessionFactory factory = configuration.buildSessionFactory();
    Session session = factory.openSession();
    System.out.println(session);
    Transaction transaction = session.beginTransaction();
    
    Employee employee =new Employee(0, "Solanki", "Solanki2023@gmail.com");
    
    session.save(employee);
    transaction.commit();
	
} catch (Exception e) {
	System.out.println(e);
}
    }
}
