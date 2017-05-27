package com.example07.interfacedependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	@Qualifier("userDaoImplMyBatis")
	private UserDao userDao2;
	
	public String getNameByHibernate() {
		return userDao.getName();
	}
	public String getNameByMyBatis() {
		return userDao2.getName();
	}
}
