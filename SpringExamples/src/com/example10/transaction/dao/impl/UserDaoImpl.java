package com.example10.transaction.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import com.example10.transaction.entity.User;
import com.example10.transaction.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private DataSource dataSource;

	@Override
	public void persist(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into user(username, password) values(?, ?)";
		Connection connection = null;
		/*
		 * 必须使用DataSourceUtils类中的getConnection()静态方法获得Connection
		 * 这样获得的Connection才会注册到Spring的事务中 直接通过注入的dataSource获取的Connection无法回滚
		 * (=@__@=) Connection无需手动关闭
		 */

		connection = DataSourceUtils.getConnection(dataSource);
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public void persistError(User user) throws SQLException {
		// TODO Auto-generated method stub
		// 错误语句
		String sql = "insert into user(name, password) values(?, ?)";
		Connection connection = null;
		connection = DataSourceUtils.getConnection(dataSource);
		PreparedStatement ps;
		ps = connection.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ps.executeUpdate();
		ps.close();
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
