package com.example02.noconfigfile;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
			// 基于Spring容器获取对象
			UserService userService = context.getBean(UserService.class);
			userService.hello();
		}
	}

}