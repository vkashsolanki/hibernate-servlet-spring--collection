package com.hibernates;

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
    Employee employee = new Employee(4, "Ram", "ram@gmail.com");
    System.out.println(employee);
    //employee.setId(2);
    //employee.setName("Vikash Solanki");
   // employee.setEmail("volashsolanki@gmail.com");
    Configuration configuration = new Configuration();
    configuration.configure("com/hibernates/hibernate.cfg.xml");
    SessionFactory factory = configuration.buildSessionFactory();
    Session session = factory.openSession();
    Transaction transaction = session.beginTransaction();
    session.save(employee);
    transaction.commit();
    
    
    
} catch (Exception e) {
	e.printStackTrace();
}
        
        
        
        
    }
}
