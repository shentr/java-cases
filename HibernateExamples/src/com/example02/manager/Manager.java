package com.example02.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example02.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setName("BO");
			user.setAddress("925");
			session.persist(user);
			session.getTransaction().commit();
		}
	}
}
