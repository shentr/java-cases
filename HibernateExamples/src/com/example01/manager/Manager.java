package com.example01.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.example01.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 在Java SE环境中Sessionfactory必须关闭释放资源
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			// 开启事务
			Transaction transaction = session.beginTransaction();
			
			User user = new User();
			user.setName("BO");
			user.setAddress("925");
			user.setAge(18);
			
			session.persist(user);
			// 提交事务
			transaction.commit();
		}
	}
}
