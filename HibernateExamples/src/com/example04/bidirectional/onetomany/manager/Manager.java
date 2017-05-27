package com.example04.bidirectional.onetomany.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example04.bidirectional.onetomany.entity.Address;
import com.example04.bidirectional.onetomany.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			// 先存在user对象
			User user = new User();
			user.setName("BO");
			session.persist(user);

			// 再存在user与address的关系
			Address address = new Address();
			address.setDetail("956");
			address.setUser(user);
			session.persist(address);

			Address address2 = new Address();
			address2.setDetail("925");
			address2.setUser(user);
			session.persist(address2);

			session.getTransaction().commit();
		}
	}

}
