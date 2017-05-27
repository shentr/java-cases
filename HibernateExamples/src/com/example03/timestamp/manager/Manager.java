package com.example03.timestamp.manager;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example03.timestamp.entity.User;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			User user = session.get(User.class, 1);
			user.setName("BO");
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, 1985);
			calendar.set(Calendar.MONTH, 0);
			calendar.set(Calendar.DATE, 1);
			user.setBirthday(calendar);
			user.setInsertTime(new Date());
			session.persist(user);
			session.getTransaction().commit();
		}
	}

}
