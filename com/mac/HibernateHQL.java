package com.mac;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mac.dto.Vehicle;

public class HibernateHQL {

	public static void main(String[] args) {

		/* QUERY */
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Vehicle where id>10");
		query.setFirstResult(2);
		query.setMaxResults(4);
		@SuppressWarnings(value = "unchecked") 
		List<Vehicle> vehicles=query.list();
		session.getTransaction().commit();
		session.close();
		
		for(Vehicle vehicle : vehicles) {
			System.out.println("vehicles : " + vehicle.getId() + " "+vehicle.getType());
		}
		

		/* QUERY NAMED PARAMETER */
		session = sessionFactory.openSession();
		session.beginTransaction();
		query=session.createQuery("select id, make, model from Vehicle where id>:id");
		query.setParameter("id", 10);
		List<Object[]> propsList=query.list();
		
		Iterator iterator=propsList.iterator();
		while(iterator.hasNext()) {
			Object o[] = (Object[])iterator.next();
			System.out.println(o[0]+" "+o[1]);
		}
				
		session.getTransaction().commit();
		session.close();
		
		
		/* CRITERIA */
		session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(Vehicle.class);
		criteria.add(Restrictions.eq("make", "kia"));
		criteria.addOrder(Order.asc("model"));

		List<Vehicle> vehiclesCriteria= criteria.list();
		
		for(Vehicle vehicle : vehiclesCriteria) {
			System.out.println("model : "+vehicle.getModel());
		}
				
		session.getTransaction().commit();
		session.close();
		
		
		/* CRITERIA with PROJECTIONS*/
		session = sessionFactory.openSession();
		session.beginTransaction();
		criteria=session.createCriteria(Vehicle.class);
		criteria.setProjection(Projections.count("id"));
		List<Long> count= criteria.list();
		System.out.println("count > "+count.get(0));
		session.getTransaction().commit();
		session.close();
		
		
		/* CRITERIA with EXAMPLE*/
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		criteria=session.createCriteria(Vehicle.class);
		criteria.add(Example.create(new Vehicle("%kia","sorrento","suv") {
			@Override
			public void steerVehicle() {
			}
		}).enableLike()); /* like enabled */
		

		List<Vehicle> vehiclesExample = criteria.list();
		for(Vehicle vehicle : vehiclesExample) {
			System.out.println("model :: "+vehicle.getModel());
		}
				
		session.getTransaction().commit();
		session.close();

		
		
		HibernateUtil.getSessionFactory().close();
		
	}

}
