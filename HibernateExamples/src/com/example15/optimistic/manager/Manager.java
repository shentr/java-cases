package com.example15.optimistic.manager;

import javax.persistence.LockModeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example15.optimistic.entity.Address;
import com.example15.optimistic.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// persist();
		// update();
		
	}

	private static void persist() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			User user = new User();
			user.setName("BO");
			session.persist(user);

			Address address = new Address();
			address.setDetail("925");
			session.persist(address);

			session.getTransaction().commit();
		}
	}

	private static void update() throws InterruptedException {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			// 模拟用户1更新操作
			Runnable runUser1 = () -> {
				Session session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				User user = session.get(User.class, 1);
				user.setName("user1");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.getTransaction().commit();
			};
			new Thread(runUser1).start();
			// 模拟用户2更新操作
			Runnable runUser2 = () -> {
				Session session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				User user = session.get(User.class, 1);
				user.setName("user2");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.getTransaction().commit();
			};
			new Thread(runUser2).start();
			
			// 主线程等待2个线程执行完后关闭sessionfactory
			Thread.sleep(2000);
		}
	}
}
