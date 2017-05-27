package com.example10.objectstates.manager;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example10.objectstates.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// persist();
		// persist2();
		// persist3();
		// get();
		// getAndLoad2();
		// getAndLoad();
		// flush();
		// refresh();
		// refresh2();
		// refresh3();
		// flushAndRefresh();
		// update();
		// merge();
		// set();
	}

	/**
	 * 即使获得id值，也在事务控制下
	 */
	private static void persist() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setName("BO");
			session.persist(user);
			System.out.println(user.getId());
			// int a = 1 / 0;
			session.getTransaction().commit();
		}
	}

	/**
	 * 第二个persist()方法将被忽略
	 */
	private static void persist2() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setName("BO");
			session.persist(user);
			System.out.println(user.getName());
			user.setName("SUN");
			session.persist(user);
			System.out.println(user.getName());
			session.getTransaction().commit();
		}
	}

	/**
	 * persist()脱管状态对象，将抛出异常
	 */
	private static void persist3() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setName("BO");
			session.persist(user);
			// session关闭，user为脱管状态
			session.getTransaction().commit();
			Session session2 = sessionFactory.getCurrentSession();
			session2.beginTransaction();
			// 异常
			session2.persist(user);
			session2.getTransaction().commit();
		}
	}

	/**
	 * 先在session缓存中查询
	 */
	private static void get() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			User user2 = session.get(User.class, 1);
			System.out.println(user2.getName());
			System.out.println(user == user2);
			session.getTransaction().commit();
		}
	}

	/**
	 * load()方法基于CGLIB动态生成实体类的子类，作为代理对象返回，当调用代理对象方法获取数据是再加载数据
	 */
	private static void getAndLoad() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			System.out.println(user.getClass().getName());
			System.out.println(user.getName());
			User user2 = session.load(User.class, 2);
			System.out.println(user2.getClass().getName());
			System.out.println(user2.getName());
			session.getTransaction().commit();
		}
	}

	/**
	 * 
	 */
	private static void getAndLoad2() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			User user2 = session.load(User.class, 2);
			session.getTransaction().commit();
			System.out.println(user.getName());
			System.out.println(user2.getName());
		}
	}

	/**
	 * 
	 */
	private static void flush() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setName("BO");
			session.persist(user);
			System.out.println(user.getName());
			user.setName("SUN");
			session.flush();
			System.out.println(user.getName());
			// int a = 1 / 0;
			session.getTransaction().commit();
		}
	}

	private static void refresh() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			System.out.println(user.getName());
			user.setName("SUN");
			session.refresh(user);
			System.out.println(user.getName());
			session.getTransaction().commit();
		}
	}

	private static void refresh2() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setId(1);
			System.out.println(user.getName());
			session.refresh(user);
			System.out.println(user.getName());
			session.getTransaction().commit();
		}
	}

	/**
	 * 
	 */
	private static void refresh3() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setName("BO");
			session.persist(user);
			System.out.println(user.getId());
			System.out.println(user.getInsertTime());
			session.refresh(user);
			System.out.println(user.getInsertTime());
			session.getTransaction().commit();
		}
	}

	private static void flushAndRefresh() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			System.out.println(user.getName());
			user.setName("SUN");
			session.flush();
			session.refresh(user);
			System.out.println(user.getName());
			session.getTransaction().commit();
		}
	}

	private static void update() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			session.getTransaction().commit();
			user.setName("SUN");
			Session session2 = sessionFactory.getCurrentSession();
			session2.beginTransaction();
			session2.update(user);
			System.out.println(user.getName());
			session2.getTransaction().commit();
		}
	}

	private static void merge() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			session.getTransaction().commit();
			user.setName("BO");
			Session session2 = sessionFactory.getCurrentSession();
			session2.beginTransaction();
			User user2 = (User) session2.merge(user);
			System.out.println(user2.getName());
			System.out.println(session2.contains(user));
			System.out.println(session2.contains(user2));
			session2.getTransaction().commit();
		}
	}
	
	private static void set() {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = new User();
			user.setId(1);
			user.setAddress("925");
			session.update(user);
			session.getTransaction().commit();
			Session session2 = sessionFactory.getCurrentSession();
			session2.beginTransaction();
			User user2 = session2.find(User.class, 1);
			System.out.println(user2.getName());
			session2.getTransaction().commit();
		}
	}
}
