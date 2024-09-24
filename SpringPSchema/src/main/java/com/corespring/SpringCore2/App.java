package com.corespring.SpringCore2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        Employee bean = (Employee) applicationContext.getBean("employee");
        System.out.println(bean);
        
    }
}
