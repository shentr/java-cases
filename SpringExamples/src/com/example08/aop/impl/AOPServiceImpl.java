package com.example08.aop.impl;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.example08.aop.AOPService;

@Component
@EnableAspectJAutoProxy
public class AOPServiceImpl 
			implements AOPService {
	@Override
	public void get() {
		// TODO Auto-generated method stub
		System.out.println("Hello AOP");
	}
}
