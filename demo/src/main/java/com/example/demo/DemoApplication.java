package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.demo.dao.UsersRepository;
import com.example.demo.entity.User;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		UsersRepository userrepo=context.getBean(UsersRepository.class);
		System.out.println(userrepo);
		
		User user = new User ();
		
		user.setName("Vikash");
		user.setCity("delhi");
		user.setMobile("55252525552");
		
		User save1 = userrepo.save(user);
		System.out.println(save1);
		
				
	}

}
