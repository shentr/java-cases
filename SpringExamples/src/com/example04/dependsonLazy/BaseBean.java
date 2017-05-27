package com.example04.dependsonLazy;

import org.springframework.stereotype.Component;

@Component
public class BaseBean {
	public BaseBean() {
		System.out.println("BaseBean");
	}
	
}
