package com.example06.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private com.example06.dependencies.dao.UserDao userDao2;
	
	public String getName() {
		return userDao.getName();
	}
	public String getName2() {
		return userDao2.getName();
	}
}
