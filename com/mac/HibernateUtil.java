package com.mac;

import org.hibernate.service.ServiceRegistry;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory=createSessionFactory();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory createSessionFactory() {
		Configuration configuration=new Configuration().configure();
		serviceRegistry=(ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void shutdown() {
		sessionFactory.close();
	}
	
}
