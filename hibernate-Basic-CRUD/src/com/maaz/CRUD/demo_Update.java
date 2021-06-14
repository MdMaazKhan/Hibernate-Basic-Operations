package com.maaz.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maaz.entityClass.Student;

public class demo_Update {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Student.class).
								buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.createQuery
			("update Student s set email='family@gmail.com' where s.fname='Maaz' or s.fname='Raza'").executeUpdate();
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
