package com.spring.FirstProgramm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        // we neet to object of Employee which means depency injection
        
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
       System.out.println(applicationContext);
       Employee st =(Employee) applicationContext.getBean("employee");
       System.out.println(st);
       
       
        
        
        
    }
}
