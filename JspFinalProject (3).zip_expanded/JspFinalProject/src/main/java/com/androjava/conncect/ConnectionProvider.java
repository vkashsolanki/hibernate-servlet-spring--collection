package com.androjava.conncect;

import java.sql.Connection;
import java.sql.DriverManager;

import com.androjava.util.PropertyReader;


public final class ConnectionProvider 
{
	static Connection connection=null;
	
	private ConnectionProvider()
	{	
	}
	synchronized static public Connection getConnection()
	{
     if(connection==null)
     {   try
     {
    	 Class.forName(PropertyReader.readProperty("DB_DRIVER"));
    	 connection=DriverManager.getConnection(PropertyReader.readProperty("DB_URL"),PropertyReader.readProperty("DB_USER"),PropertyReader.readProperty("DB_PASS"));
    	 return connection;
     }
     catch (Exception e) { 
    	 e.printStackTrace();
	}
     }
     else
     {
    	 return connection;
     }
	return connection;
 
		
	}
	
}
