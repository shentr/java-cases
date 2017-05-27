package com.example09.aopadvanced.impl;

import org.springframework.stereotype.Component;

import com.example09.aopadvanced.AOPService;
import com.example09.aopadvanced.MyAuthority;
import com.example09.aopadvanced.MyAuthority.MyAuthorityType;

@Component
@MyAuthority
public class AOPServiceImpl 
			implements AOPService {

	@Override
	@MyAuthority(MyAuthorityType.ADMIN)
	public String get(String name) {
		// TODO Auto-generated method stub
		return "input: " + name;
	}
	
}
