package com.example07.interfacedependencies;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UserDaoImplHibernate 
					implements UserDao {
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Hibernate";
	}
}
