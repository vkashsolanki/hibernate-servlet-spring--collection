package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDao {
	
	
	public UserDao()
	{
		super();
	}
	
	//1. configure jdbc driver 2. load driver 3.get connection 4. write whole method insert,update,delete, data
	
	// configuration Driver
	private String URL = "jdbc:mysql://localhost:3306/usermanagement?useSSL=false"; 
	//private String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String USER = "root";
	private String PASSWORD = "root";
	
	// Query return 
	
	private static final String INSERT_USER  = "insert into users(name, email, country) values (?,?,?)";
	
	private static final String SELECT_ALL_USER = "select * form users";
	private static final String SELECT_USER = "select id, name , email, country form users where id=?";
	private static final String DELETE_USER =  "delete from users where id=?";
	private static final String UPDATE_USER =  "update users set name=?, email=?, country=?, where id =?";
	

	
	
	
	
	// seprated method Connection
	
	
	protected Connection getConnection() {		
		Connection connection = null;		
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL,USER,PASSWORD);	
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}				
		//return object for connection
		return connection;		
	}
	
	// INSERT User
	public void insertUser(User user)
	{
		System.out.println(INSERT_USER);
		
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			preparedStatement.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	//USer by id
	public User selectUSer(int id)
	{
		User user = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// process resultSet object 
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String country = resultSet.getString("country");
				
				user = new User(id, name,email,country);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
		
	}
		
		// select all user 
		
		

	public List<User> selectAllUser()
	{
		
		List<User> users = new ArrayList();
		
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER)){
		    ResultSet resultSet = preparedStatement.executeQuery();
		    
		    while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String country = resultSet.getString("country");
				
				users.add(new User(id,name,email,country));
				
				
			}
				
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return users;
		
	}
	
	
	// update user
	
	public boolean updateUser(User user) throws Exception
	{
	    boolean updated;
	    
	    try (Connection connection = getConnection();
	    		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)){
	    	System.out.println("UpdateUser"+preparedStatement);
	    	preparedStatement.setString(1, user.getName());
	    	preparedStatement.setString(2, user.getEmail());
	    	preparedStatement.setString(3, user.getCountry());
	    	preparedStatement.setInt(4, user.getId());
	    	updated = preparedStatement.executeUpdate() > 0;
	    		
	    	
	    }
		return updated;

	}
	
	
	
	// delete user
	
	public boolean deleteUser(int id)throws Exception
	{
	    boolean delete;
	    
	    try (Connection connection = getConnection();
	    	PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){

	    	preparedStatement.setInt(1, id);
	    	delete = preparedStatement.executeUpdate() > 0;
	    		
	    	
	    }
		return delete;

	}
		
		
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


