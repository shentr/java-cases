package com.example06.bidirectional.manytomany.manager;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example06.bidirectional.manytomany.entity.Address;
import com.example06.bidirectional.manytomany.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory())  {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			User user = new User();
			user.setName("BO");
			session.persist(user);
			
			User user2 = new User();
			user2.setName("SUN");
			session.persist(user2);
			
			Set<User> users = new HashSet<>();
			users.add(user);
			users.add(user2);
			
			Address address = new Address();
			address.setDetail("925");
			address.setUsers(users);
			session.persist(address);
			
			Address address2 = new Address();
			address2.setDetail("956");
			address2.setUsers(users);
			session.persist(address2);

			
			session.getTransaction().commit();
			
		}
	}

}
