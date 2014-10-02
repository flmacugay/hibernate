package com.mac;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mac.dto.Address;
import com.mac.dto.Bike;
import com.mac.dto.Bills;
import com.mac.dto.Car;
import com.mac.dto.Employment;
import com.mac.dto.Qualification;
import com.mac.dto.UserDetails;
import com.mac.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails userDetails=new UserDetails("Louie",new Date(),"baby");
		
		Employment employment=new Employment("developer", "ABC company");
		userDetails.setEmployment(employment);
		
		Qualification qualification=new Qualification("engineering", "MIT");
		userDetails.setQualification(qualification);
		qualification.setUserDetails(userDetails);
		
		Address addressMail=new Address("463","South Road","Melbourne","VIC","Australia",3024,"mailing");
		Address addressResd=new Address("463","South Road","Melbourne","VIC","Australia",3024,"residential");
		userDetails.getListOfAddress().add(addressMail);
		userDetails.getListOfAddress().add(addressResd);
		
		
		Vehicle suvCar=new Car("kia","sorrento","suv");
		Car wagonCar=new Car("mazda", "gt", "wagon");
		wagonCar.setSteeringWheel("steering wheel");
		Bike roadBike=new Bike("polygon", "helios", "road");
		roadBike.setSteeringHandle("handle bar");
		userDetails.getVehicles().add(suvCar);
		userDetails.getVehicles().add(wagonCar);
		userDetails.getVehicles().add(roadBike);
		
		suvCar.setUserDetails(userDetails);
		wagonCar.setUserDetails(userDetails);
		
		
		
		UserDetails userDetails2=new UserDetails("Spencer",new Date(),"kid");
		Bills waterBills=new Bills("water",60.2);
		Bills elecBills=new Bills("electricity", 100.50);
		Bills internetBills=new Bills("internet", 99.00);
		
		userDetails.getBills().add(waterBills);
		userDetails.getBills().add(internetBills);
		userDetails2.getBills().add(elecBills);
		
		roadBike.setUserDetails(userDetails2);
		
		waterBills.getUserDetails().add(userDetails);
		elecBills.getUserDetails().add(userDetails2);
		internetBills.getUserDetails().add(userDetails);
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.save(qualification);
		//session.save(suvCar);
		//session.save(wagonCar);
		
		session.save(userDetails2);
		session.save(waterBills);
		session.save(elecBills);
		session.save(internetBills);
		session.getTransaction().commit();
		session.close();
		
		
		userDetails=null;
		System.out.println("userdetails >> "+userDetails);
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		userDetails=(UserDetails) session.get(UserDetails.class,1);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
		
		System.out.println("userdetails >> "+userDetails);
		
	}

}
