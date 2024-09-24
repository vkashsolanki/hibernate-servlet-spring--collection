package com.androjava.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import com.androjava.conncect.ConnectionProvider;
import com.androjava.dto.Users;
import com.androjava.util.SendEmail; 

public class UserDaoImpl implements UserDao
{

	UUID uuid = UUID.randomUUID();
	
	@Override
	public String registerUser(Users model) 
	{
		Connection connection =ConnectionProvider.getConnection();
		try {
			
			PreparedStatement preparedStatement1=connection.prepareStatement("select * from users where email = ? or mobile =?");
			preparedStatement1.setString(1,model.getEmail());
			preparedStatement1.setString(2,model.getMobile());
			
			ResultSet resultSet=preparedStatement1.executeQuery();
			if(resultSet.next())
			{
			return "Mobile or Email Already Exist";	
			}
			
			else
		    {
			PreparedStatement preparedStatement=connection.prepareStatement("insert into users(name,email,mobile,pass) values(?,?,?,?)");
			preparedStatement.setString(1, model.getName());
			preparedStatement.setString(2, model.getEmail());
			preparedStatement.setString(3, model.getMobile());
			preparedStatement.setString(4, model.getPass());
			int i=preparedStatement.executeUpdate();
		    if(i>0) 
			return "sucess";
			else
			return "fail";
		}
		}
	
       catch (Exception e1)
		{
    	     e1.printStackTrace();
	}
		return null;
	
	}

	@Override
	public String loginUser(Users model) {
		 
		Connection connection =ConnectionProvider.getConnection();
		try {
			
			PreparedStatement preparedStatement1=connection.prepareStatement("select * from users where email=? and pass=?");
			preparedStatement1.setString(1,model.getEmail());
			preparedStatement1.setString(2,model.getPass());
			
			ResultSet resultSet=preparedStatement1.executeQuery();
			if(resultSet.next())
			{
			return "sucess";
			}
		
			else
		    {
			return "fail";

		    }
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String forgetPassword(Users model) 
	{
	
		Connection connection =ConnectionProvider.getConnection();
		try {
			
			PreparedStatement preparedStatement1=connection.prepareStatement("select * from users where email = ?");
			preparedStatement1.setString(1,model.getEmail());
			 
			
			ResultSet resultSet=preparedStatement1.executeQuery();
			if(resultSet.next())
			{
			String pass=resultSet.getString("pass");
			if(SendEmail.sendEmailLink(model.getEmail(), pass,uuid))
			{
				PreparedStatement preparedStatement=connection.prepareStatement("update users set uuid =?");
				preparedStatement.setString(1, String.valueOf(uuid));
				preparedStatement.executeUpdate();
				return "pass";
			}
		    
			
			}
				
			else
			{
			return "Email Does not exist.."	;
			
			}
		
		 

		}
		catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
		}
}
