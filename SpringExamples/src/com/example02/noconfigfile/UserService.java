package com.example02.noconfigfile;

import org.springframework.stereotype.Component;

@Component
public class UserService {
	public void hello() {
		System.out.println("UserService");
	}
}
