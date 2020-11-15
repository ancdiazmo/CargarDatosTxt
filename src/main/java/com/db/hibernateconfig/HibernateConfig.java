package com.db.hibernateconfig;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.db.domain.PersonaCargaDatos;
import com.utiles.ManejadorDeProperties;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	
	private HibernateConfig () {}
	
	public static Session getSession () {
		
		if (sessionFactory == null) {
			
			try {
				
				ManejadorDeProperties manejadorDeProperties = new ManejadorDeProperties ();
				Properties properties = manejadorDeProperties.obtenerProperties();
				Configuration configuration = new Configuration ();
				configuration.setProperties(properties);
				
				//TODO colocar aqui todas las entities que pertenescan al modelo
				configuration.addAnnotatedClass(PersonaCargaDatos.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder ()
						.applySettings(properties).build();
				//Cuando se llama el metodo buildSessionFactory, es cuando se crea las tablas y 
				//se inicia Hibernate
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory.openSession();
				
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
		else {
			return sessionFactory.openSession();
		}
	}
}
