package com.example06.dependencies;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	public String getName() {
		return "BO";
	}
	public UserDao() {
		System.out.println("userdao");
	}
}
