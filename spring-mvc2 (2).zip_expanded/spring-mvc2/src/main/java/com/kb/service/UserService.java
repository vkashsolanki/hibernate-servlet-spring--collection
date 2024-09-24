package com.kb.service;

import java.util.List;

import com.kb.model.UserModel;

public interface UserService {


	public void addUser(UserModel usermodel);
	
	public void updateUser(UserModel usermodel);
	
	public UserModel getUser(int id);
	
	public void removeEmployee(int id);
	
	public List<UserModel> listUser();

}
