package com.mac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mac.dto.Vehicle;

public class HibernateCache {

	public static void main(String[] args) {

		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Vehicle vehicle=(Vehicle) session.get(Vehicle.class, 3);
		vehicle.setType("road2");
		
		Vehicle vehicle2=(Vehicle) session.get(Vehicle.class, 3);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
		
		System.out.println(vehicle2.getType());
		
		
	}

}
