package com.example01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("com/example01/beans.xml")) {
			// 基于Spring容器获取对象
			UserService userService = context.getBean(UserService.class);
			userService.hello();
			UserService userService2 = context.getBean("userService", UserService.class);
			userService2.hello();
		}
	}
}
