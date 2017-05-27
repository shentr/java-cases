package com.example09.aopadvanced;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;




@Configuration
@ComponentScan("com.example09")
// @EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy
public class Manager {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Manager.class)) {
			AOPService aopService = context.getBean(AOPService.class);
			System.out.println(aopService.get("BO"));
			System.out.println(aopService.getClass());
		}
	}

}
