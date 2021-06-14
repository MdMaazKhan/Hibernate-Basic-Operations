package com.maaz.checkConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class hbJdbc {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/hb_student_tracker";
		String user="hbstudent";
		String pass="hbstudent";
		
		
		try {
			Connection con=DriverManager.getConnection(url,user,pass);
			
			System.out.println("success!!");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
