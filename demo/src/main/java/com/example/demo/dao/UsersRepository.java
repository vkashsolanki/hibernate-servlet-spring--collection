package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.User;

//pass here Entity class type(User) and id Entity class of variable datatype like integer,long,short etc
public interface UsersRepository extends CrudRepository<User, Integer>{

}
