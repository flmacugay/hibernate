package com.mac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mac.dto.Car;
import com.mac.dto.Vehicle;
/*
 * you can only persist transient object
 * you cannot persist a detached object
 * session.persist() returns void
 * session.save() returns serializable object > primary key value
 * 
 * */
public class HibernateCRUD {

	public static void main(String[] args) {

		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		/* DELETE*/
		Vehicle vehicle=(Vehicle) session.get(Vehicle.class, 1);
		session.delete(vehicle);
		session.getTransaction().commit();
		session.close();
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		/* PERSIST */
		Vehicle suvCar=new Car("kia","med123","car");
		session.persist(suvCar);
		System.out.println("id of persist > "+suvCar.getId());
		/* SAVE */
		Vehicle suvCar2=new Car("kia","med123","car");
		session.save(suvCar2);
		System.out.println("id of save > "+suvCar2.getId());
		session.getTransaction().commit();
		session.close();
		
		suvCar.setType("medium3");
		session=sessionFactory.openSession();
		session.beginTransaction();
		/* UPDATE */
		session.update(suvCar);
		session.getTransaction().commit();
		session.close();
		
		HibernateUtil.getSessionFactory().close();
		
	}

}
