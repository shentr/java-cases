package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AddressDao;
import com.dao.UserDao;
import com.entity.User;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AddressDao addressDao;
	
	public User getUser(String userName, String password) {
		return userDao.find(userName, password);
	}
}
