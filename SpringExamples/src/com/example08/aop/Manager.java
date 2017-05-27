package com.example08.aop;

import java.lang.reflect.Proxy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example08.aop.impl.AOPServiceImpl;


@Configuration
@ComponentScan("com.example08")
//@EnableAspectJAutoProxy
public class Manager {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Manager.class)) {
			
			AOPService aopService = (AOPService)context.getBean("AOPServiceImpl",Proxy.class);
			aopService.get();
			System.out.println(aopService.getClass());
			
			/*AOPServiceImpl aopServiceImpl = context.getBean(AOPServiceImpl.class);
			aopServiceImpl.get();
			System.out.println(aopServiceImpl.getClass());*/
		}
	}

}
