package com.example11.casade.manager;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example11.casade.entity.Address;
import com.example11.casade.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// persist();
		// removeCasade();
		
	}
	private static void persist() {
		try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setName("BO");
			session.persist(user);
			Address address = new Address();
			address.setDetail("925");
			address.setUser(user);
			session.persist(address);
			Address address2 = new Address();
			address2.setDetail("956");
			address2.setUser(user);
			session.persist(address2);
			session.getTransaction().commit();
		}
	}
	private static void removeCasade() {
		try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			session.remove(user);
			
			session.getTransaction().commit();
		}
	}
}
