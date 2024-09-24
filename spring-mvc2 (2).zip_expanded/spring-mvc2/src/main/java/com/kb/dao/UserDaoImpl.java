package com.kb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kb.model.UserModel;
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	 private SessionFactory sessionFactory;	
	
	public void addUser(UserModel usermodel) {
		 
		System.out.println(sessionFactory.openSession().save(usermodel));
		
	}

	public void updateUser(UserModel usermodel) {
		// TODO Auto-generated method stub
		
	}

	public UserModel getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		Session openSession = sessionFactory.openSession();
        String hql = "delete from UserModel where id = :id";
		openSession.createQuery(hql);
		
	}

	public List<UserModel> listUser() {
		Session openSession = sessionFactory.openSession();
		Query createQuery = openSession.createQuery("from UserModel");
		List<UserModel> list= createQuery.list();
		
		return list;
	}
	
	

}
