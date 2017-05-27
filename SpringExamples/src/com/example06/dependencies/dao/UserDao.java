package com.example06.dependencies.dao;
import org.springframework.stereotype.Repository;
@Repository("dao.userdao")
public class UserDao {
	public String getName() {
		return "SUN";
	}
	public UserDao() {
		System.out.println("dao.userdao");
	}
}
