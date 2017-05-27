package com.example10.transaction.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example10.transaction.dao.UserDao;
import com.example10.transaction.entity.User;
import com.example10.transaction.service.UserService;

@Service
@Transactional(rollbackFor = SQLException.class)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public void add(User user) throws SQLException {
		// TODO Auto-generated method stub
			userDao.persist(user);
			userDao.persistError(user);
	}
	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
