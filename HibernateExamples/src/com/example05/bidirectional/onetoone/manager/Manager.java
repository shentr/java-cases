package com.example05.bidirectional.onetoone.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example05.bidirectional.onetoone.entity.Address;
import com.example05.bidirectional.onetoone.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			User user = new User();
			user.setName("BO");
			session.persist(user);
			
			Address address = new Address();
			address.setDetail("925");
			address.setUser(user);
			session.persist(address);
			
			session.getTransaction().commit();
		}
	}

}
