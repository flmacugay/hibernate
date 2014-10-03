package com.mac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mac.dto.Vehicle;

public class HibernateCache {

	public static void main(String[] args) {

		/* First level cache */
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Vehicle vehicle=(Vehicle) session.get(Vehicle.class, 3);
		vehicle.setType("road2");
		
		/* retrieve from first level cache */
		Vehicle vehicle2=(Vehicle) session.get(Vehicle.class, 3);
		
		session.getTransaction().commit();
		session.close();
		
		
		/* 2nd level cache */
		session=sessionFactory.openSession();
		session.beginTransaction();
		
		/* retrieve from second level cache */
		vehicle=(Vehicle) session.get(Vehicle.class, 3);
		vehicle.setType("road2");
		
		System.out.println("vehicle : "+vehicle.getId());
		
		session.getTransaction().commit();
		session.close();
		
		
		HibernateUtil.getSessionFactory().close();
		
	}

}
