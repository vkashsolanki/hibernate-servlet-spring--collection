package com.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

	
	static SessionFactory factory = null;
	
public static SessionFactory  getSessionFactory() {
	
	if(factory == null) {
		try {
			
			Configuration configuration = new Configuration();
			configuration.configure("configurationsFile/hibernate.cfg.xml");
			factory=configuration.buildSessionFactory();
			return factory;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	else {
		return factory;
		
	}
	
	
	return null;
	
}
	
	
	
}
