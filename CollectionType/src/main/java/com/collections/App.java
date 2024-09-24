package com.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        
        // we neet to object of Employee which means depency injection
        
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
       System.out.println(applicationContext);
       Employee st =(Employee) applicationContext.getBean("employee");
      // System.out.println(st);
       System.out.println(st.getName());
       System.out.println(st.getPhones());
       System.out.println(st.getAddress());
       System.out.println(st.getCourse());
       
       
       
        
        
        
    }
    }

