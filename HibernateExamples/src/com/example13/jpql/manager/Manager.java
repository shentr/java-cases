package com.example13.jpql.manager;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example13.jpql.entity.Address;
import com.example13.jpql.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			 persist(session);
			// from(session);
			// select(session);
			// select2(session);
			//select3(session);
			// select4(session);
			// select5(session);
			// select6(session);
			// select7(session);
			// query(session);
			// query2(session);
			
			
			session.getTransaction().commit();
		}
	}

	private static void persist(Session session) {

		User user = new User();
		user.setName("BO");
		session.persist(user);
		User user2 = new User();
		user2.setName("SUN");
		session.persist(user2);

		Address address = new Address();
		address.setDetail("925");
		address.setUser(user);
		session.persist(address);
		Address address2 = new Address();
		address2.setDetail("956");
		address2.setUser(user);
		session.persist(address2);

		Address address3 = new Address();
		address3.setDetail("1201");
		address3.setUser(user2);
		session.persist(address3);

	}

	@SuppressWarnings("unchecked")
	private static void from(Session session) {
		String jpql = "FROM User";
		Query query = session.createQuery(jpql);
		List<User> users = query.getResultList();
		for (User u : users) {
			System.out.println(u.getName());
		}
	}
	@SuppressWarnings("unchecked")
	private static void select(Session session) {
		String jpql = " SELECT u.id, u.name FROM User u";
		List<Object[]> results = session.createQuery(jpql).getResultList();
		for (Object[] result : results) {
			System.out.println(result[0]);
			System.out.println(result[1]);
		}
	}
	@SuppressWarnings("unchecked")
	private static void select2(Session session) {
		String jpql = "FROM Address a WHERE a.user.name='BO'";
		List<Address> addresses = session.createQuery(jpql).getResultList();
		System.out.println(addresses.size());
		for (Address address : addresses) {
			System.out.println(address.getDetail());
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void select3(Session session) {
		String jpql = "SELECT u.addresses FROM User u WHERE u.name='BO'";
		List<Address> addresses = session.createQuery(jpql).getResultList();
		for (Address address : addresses) {
			System.out.println(address.getDetail());
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void select4(Session session) {
		String jpql = "SELECT a.user FROM Address a WHERE a.detail='925'";
		List<User> users = session.createQuery(jpql).getResultList();
		System.out.println(users.size());
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
	/**
	 * 排序，size()函数
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	private static void select5(Session session) {
		String jpql = "FROM User u ORDER BY SIZE(u.addresses) DESC";
		List<User> users = session.createQuery(jpql).getResultList();
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
	/**
	 * 关联查询
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	private static void select6(Session session) {
		// String jpql = "FROM Address a WHERE a.user.name='BO'";
		String jpql = "SELECT u.addresses FROM User u WHERE u.name='BO'";
		List<Address> addresses = session.createQuery(jpql).getResultList();
		
		for (Address address : addresses) {
			System.out.println(address.getDetail());
		}
	}
	
	/**
	 * 位置参数
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	private static void query(Session session) {
		String jpql = "SELECT u.addresses FROM User u WHERE u.name=?1";
		Query query = session.createQuery(jpql);
		query.setParameter(1, "BO");
		List<Address> addresses = query.getResultList();
		for (Address address : addresses) {
			System.out.println(address.getDetail());
		}
	}
	/**
	 * 名称参数
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	private static void query2(Session session) {
		String jpql = "SELECT a.user FROM Address a WHERE a.detail=:detail";
		Query query = session.createQuery(jpql);
		List<User> users = query.setParameter("detail", "925").getResultList();
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
}
