package com.example12.fetch.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example12.fetch.entity.Address;
import com.example12.fetch.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// persist();
		getAddresses();
		// getUser();
		
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
	private static void getAddresses() {
		try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			session.getTransaction().commit();
			System.out.println(user.getName());
			for (Address a : user.getAddresses()) {
				System.out.println(a.getDetail());
			}
		}
	}
	
	private static void getUser() {
		try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Address address = session.get(Address.class, 1);
			session.getTransaction().commit();
			System.out.println(address.getDetail());
			System.out.println(address.getUser().getName());
		}
	}
}
