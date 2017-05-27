package com.example16.pessimistic.manager;

import javax.persistence.LockModeType;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example16.pessimistic.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// persist();
		updateBalance();
	}

	private static void persist() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setName("BO");
			user.setBalance(100);
			session.persist(user);
			session.getTransaction().commit();
		}
		
	}
	
	private static void updateBalance() throws InterruptedException {
		int expense = 80;
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			// 模拟用户1更新操作
			Runnable runUser1 = () -> {
				Session session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				User user = session.find(User.class, 1, LockModeType.PESSIMISTIC_WRITE);
				int balance = user.getBalance();
				System.out.println("user1 before: " + balance);
				if (balance - expense >= 0) {
					user.setBalance(balance - expense);
					System.out.println("user1 after: " + (balance - expense));
				} else {
					System.out.println("insufficient balance!");
				}
				try {
					Thread.sleep(200);
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
				User user = session.find(User.class, 1, LockModeType.PESSIMISTIC_WRITE);
				int balance = user.getBalance();
				System.out.println("user2 before: " + balance);
				if (balance - expense >= 0) {
					user.setBalance(balance - expense);
					System.out.println("user2 after: " + (balance - expense));
				} else {
					System.out.println("insufficient balance!");
				}
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
