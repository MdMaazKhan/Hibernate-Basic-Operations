package com.maaz.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maaz.entityClass.Student;

public class demo_SelectingStudents_READ {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Student.class).
								buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			/*
			we are creating a select query according to some condition
			The resultSet is returned i.e. list of students
			*/
			List<Student> tempStudent=session.createQuery("from Student s where s.fname='Maaz' OR s.lname='khan'").list();
			for(Student s:tempStudent){
				System.out.println(s.toString());
			}
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
