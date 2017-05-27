package com.example07.inheritance.singletable.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example07.inheritance.singletable.entity.Person;
import com.example07.inheritance.singletable.entity.Student;
import com.example07.inheritance.singletable.entity.Teacher;
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
