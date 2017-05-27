package com.example04.dependsonLazy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.example04")
public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(Manager.class)) {
			
		}
	}

}
