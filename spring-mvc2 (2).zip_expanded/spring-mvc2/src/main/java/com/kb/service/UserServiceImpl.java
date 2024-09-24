package com.kb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.dao.UserDao;
import com.kb.model.UserModel;

@Service
public class UserServiceImpl implements UserService{

    @Autowired 
    UserDao dao; 
	
	
	public void addUser(UserModel usermodel) {
		dao.addUser(usermodel);

	}

	public void updateUser(UserModel usermodel) {
		// TODO Auto-generated method stub
		
	}

	public UserModel getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeEmployee(int id) {
		dao.removeEmployee(id);
		
	}

	public List<UserModel> listUser() {
		List<UserModel> listUser = dao.listUser();
		return listUser;
	}


	

}
