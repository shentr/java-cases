package com.example03.scope;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.example03")
public class Manager {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(Manager.class)) {
			SingletonBean sBean = context.getBean(SingletonBean.class);
			SingletonBean sBean2 = context.getBean(SingletonBean.class);
			System.out.println(sBean == sBean2);
			PrototypeBean pBean = context.getBean(PrototypeBean.class);
			PrototypeBean pBean2 = context.getBean(PrototypeBean.class);
			System.out.println(pBean == pBean2);
		}
	}

}
