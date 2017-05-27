package com.example06.bidirectional.manytomany2.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example06.bidirectional.manytomany2.entity.Address;
import com.example06.bidirectional.manytomany2.entity.User;
import com.example06.bidirectional.manytomany2.entity.UserAddress;
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
			
			Address address = new Address();
			address.setDetail("925");
			session.persist(address);
			
			UserAddress userAddress = new UserAddress();
			userAddress.setComment("labs");
			userAddress.setUser(user);
			userAddress.setAddress(address);
			session.persist(userAddress);
			
			session.getTransaction().commit();
		}
	}

}
