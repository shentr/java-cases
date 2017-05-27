package com.example10.transaction.service;

import java.sql.SQLException;

import com.example10.transaction.entity.User;

public interface UserService {
	public void add(User user) throws SQLException;
	public User findByUserName(String userName);
}
