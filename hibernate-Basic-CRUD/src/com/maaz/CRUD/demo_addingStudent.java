package com.maaz.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maaz.entityClass.Student;

public class demo_addingStudent {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Student.class).
								buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			Student tempStudent1= new Student("Maaz","Khan","maaz@gmail.com"); // first student
			Student tempStudent2= new Student("Anupam","khair","Anupam@gmail.com"); // second student
			
			session.beginTransaction();
			session.save(tempStudent1);// first student is added to the session but not added to database. Only after commit it will be added. 
			session.save(tempStudent2);// same as above
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
