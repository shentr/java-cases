package com.example10.transaction.dao;


import java.sql.SQLException;

import com.example10.transaction.entity.User;

public interface UserDao {
	public void persist(User user) throws SQLException;
	public void persistError(User user) throws SQLException;
	public User findByUserName(String userName);
}
