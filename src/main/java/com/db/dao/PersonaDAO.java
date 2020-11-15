package com.db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.domain.PersonaCargaDatos;
import com.db.hibernateconfig.HibernateConfig;

public class PersonaDAO {
	
	public void save (PersonaCargaDatos persona) {
		
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(persona);
		transaction.commit();
		session.close();
	}
	
	public void update (PersonaCargaDatos persona) {
		
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(persona);
		transaction.commit();
		session.close();
	}
	
	public void delete (PersonaCargaDatos persona) {
		
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(persona);
		transaction.commit();
		session.close();
	}
	
	public List<PersonaCargaDatos> get (String query) {
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		Query queryHibernate = session.createQuery(query);
		List<PersonaCargaDatos> personas = queryHibernate.list();
		transaction.commit();
		session.close();
		
		return personas;
	}
	
	public void deleteAll () {
		
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		Query queryHibernate = session.createQuery("DELETE FROM PersonaCargaDatos");
		queryHibernate.executeUpdate();
		transaction.commit();
		session.close();
	}
}
