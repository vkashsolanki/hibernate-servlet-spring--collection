package com.corespring.SpringCollection;

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
        Vehicle bean = (Vehicle) applicationContext.getBean("vehicle");
        System.out.println(bean);
    }
}
