package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entity.User;


@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	public void addUser(User user) {
		userDao.persist(user);
	}
	public User getUser(int id) {
		return userDao.find(id);
	}
}
