package com.example05.lifecyclecallbacks;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class UserService {
	public UserService() {
		System.out.println("UserService");
	}
	@PostConstruct
	private void init() {
		System.out.println("init");
	}
	@PreDestroy
	private void destory() {
		System.out.println("destory");
	}
}
