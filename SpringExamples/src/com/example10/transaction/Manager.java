package com.example10.transaction;

import java.sql.SQLException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example10.transaction.entity.User;
import com.example10.transaction.service.UserService;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("com/example10/transaction/beans.xml")) {
			UserService userService = context.getBean(UserService.class);
			User user = new User();
			user.setUserName("BO");
			user.setPassword("123456");
			try {
				userService.add(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
