package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public class UserDao {
	@PersistenceContext
	private EntityManager entityManager;
	public void persist(User user) {
		entityManager.persist(user);
	}
	public User find(int id) {
		return entityManager.find(User.class, id);
	}
}
