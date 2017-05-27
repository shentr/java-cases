package com.example07.interfacedependencies;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImplMyBatis 
					implements UserDao {
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "MyBatis";
	}

}
