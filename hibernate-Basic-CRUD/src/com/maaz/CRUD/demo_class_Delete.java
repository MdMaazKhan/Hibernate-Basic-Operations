package com.maaz.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maaz.entityClass.Student;

public class demo_class_Delete {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Student.class).
								buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.createQuery
			("delete from Student s where s.lname='Khan'").executeUpdate();  // deleting a record on the given condition
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
