package com.example06.dependencies;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example06")
public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(Manager.class)) {
			UserService userService = context.getBean(UserService.class);
			System.out.println(userService.getName());
			System.out.println(userService.getName2());
			MyBean myBean = context.getBean(MyBean.class);
			myBean.get();
		}
	}

	@Bean
	private static MyBean getMyBean() {
		return new MyBean();
	}
}
