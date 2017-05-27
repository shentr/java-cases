package com;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.User;
import com.service.UserService;

public class Manager {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml")) {
			UserService userService = context.getBean(UserService.class);
			User user = new User();
			user.setName("BO");
			user.setAddress("925");
			user.setAge(18);
			userService.addUser(user);
		}
	}
}
