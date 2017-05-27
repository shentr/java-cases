package com.example14.criteriaquery.manager;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example14.criteriaquery.entity.Address;
import com.example14.criteriaquery.entity.Address_;
import com.example14.criteriaquery.entity.User_;
import com.util.HibernateUtil;

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jpql = "SELECT a.user.name FROM Address a WHERE a.detail='925'";

		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			// 基于Session/EntityManager创建CriteriaBuilder对象
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			// 基于CriteriaBuilder对象创建类型安全标准查询
			CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
			// 基于CriteriaQuery对象创建查询根对象，即FORM语句
			Root<Address> address = criteriaQuery.from(Address.class);
			// 基于CriteriaQuery对象指定查询返回实体类属性，即SELECT语句
			criteriaQuery.select(address.get(Address_.user).get(User_.name));
			// 基于CriteriaQuery对象指定查询限制条件，即WHERE语句
			criteriaQuery.where(criteriaBuilder.equal(address.get(Address_.detail), "925"));
			// 基于Session/Entitymanager创建预执行的标准查询
			TypedQuery<String> typedQuery = session.createQuery(criteriaQuery);
			// 执行查询并返回查询结果集
			List<String> names = typedQuery.getResultList();
			for (String name : names) {
				System.out.println(name);
			}
			session.getTransaction().commit();
		}
	}
}
