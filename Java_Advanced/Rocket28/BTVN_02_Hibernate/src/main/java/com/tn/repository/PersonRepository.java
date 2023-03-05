package com.tn.repository;

import com.tn.entity.Person;
import com.tn.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PersonRepository {

	private HibernateUtils hibernateUtils;

	public PersonRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public List<Person> getlistPerson(){
		Session session = null;
		try {
		session = hibernateUtils.openSession();

		Query<Person> query =  session.createQuery("from Person");
		List<Person> personList = query.list();
		System.out.println("Create success!");
		return personList;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
