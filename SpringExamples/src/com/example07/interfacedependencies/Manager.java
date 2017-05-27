package com.example07.interfacedependencies;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example07")
public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(Manager.class)) {
			UserService userService = context.getBean(UserService.class);
			System.out.println(userService.getNameByHibernate());
			System.out.println(userService.getNameByMyBatis());
		}
	}

}
