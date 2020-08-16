package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started...");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//Creating Student
		Student s1 =new Student();
		s1.setId(102);
		s1.setName("Omkar");
		s1.setCity("Lucknow");
		
		//Creating object of address
		Address ad = new Address();
		ad.setStreet("street1");
		ad.setCity("DELHI");
		ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.456);
        
      //Reading image
    	FileInputStream fis = new FileInputStream("src/main/java/c.png");
    	byte[] data = new byte[fis.available()];
    	fis.read(data);
    	ad.setImage(data);
        
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s1);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done");
		
		System.out.println("---session factory---"+factory);
	}
}
