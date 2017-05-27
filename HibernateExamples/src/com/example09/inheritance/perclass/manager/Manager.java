package com.example09.inheritance.perclass.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example09.inheritance.perclass.entity.Person;
import com.example09.inheritance.perclass.entity.Student;
import com.example09.inheritance.perclass.entity.Teacher;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory())  {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Person person = new Person();
			person.setName("ZHANG");
			session.persist(person);
			
			Teacher teacher = new Teacher();
			teacher.setName("BO");
			teacher.setTitle("lecturer");
			session.persist(teacher);
			
			Student student = new Student();
			student.setName("SUN");
			student.setGrade(3);
			session.persist(student);
			
			session.getTransaction().commit();
		}
	}

}
