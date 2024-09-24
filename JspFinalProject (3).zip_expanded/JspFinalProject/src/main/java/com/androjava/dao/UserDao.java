package com.androjava.dao;

import com.androjava.dto.Users;

public interface UserDao {
	
public String registerUser(Users model);
public String loginUser(Users model);
public String forgetPassword(Users email);
 



}
