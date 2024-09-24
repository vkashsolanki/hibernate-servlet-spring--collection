package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.Employee;
import com.bean.Person;
import com.bean.Student;


public class MainClasss {
	
	public static void main(String[] args) {
		try {
			
			
			Configuration configuration = new Configuration();
			configuration.configure("Config/hibernate.cfg.xml");
			SessionFactory factory = configuration.buildSessionFactory();
			Session session = factory.openSession();
			
			Transaction transaction = session.beginTransaction();
			Person person = new Person(0, "Raaj");
			
		    Student student = new Student("java", "4512200");
		    
		    Employee employee = new Employee("Software Developer",4512200);
		    session.save(person);
		    session.save(employee);
		    session.save(student);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
