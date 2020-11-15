package com.db.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.domain.CarroCargaDatos;
import com.db.hibernateconfig.HibernateConfig;

public class CarroDAO {
	
	public void save (CarroCargaDatos carro) {
		
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(carro);
		transaction.commit();
		session.close();
	}
	
	public void update (CarroCargaDatos carro) {
		
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(carro);
		transaction.commit();
		session.close();
	}
	
	public void delete (CarroCargaDatos carro) {
		
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(carro);
		transaction.commit();
		session.close();
	}
	
	public List<CarroCargaDatos> get (String query) {
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		Query queryHibernate = session.createQuery(query);
		List<CarroCargaDatos> carros = queryHibernate.list();
		transaction.commit();
		session.close();
		
		return carros;
	}
	
	public void deleteAll () {
		
		Session session = HibernateConfig.getSession();
		Transaction transaction = session.beginTransaction();
		Query queryHibernate = session.createQuery("DELETE FROM CarroCargaDatos");
		queryHibernate.executeUpdate();
		transaction.commit();
		session.close();
	}
}
