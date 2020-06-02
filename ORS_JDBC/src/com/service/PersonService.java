package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonService {
	Connection con = null;
	Statement st = null;

	public static void main(String[] args) {
		PersonService service = new PersonService();
		service.PersonService();
	}

	public void PersonService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			st = con.createStatement();
			con.setAutoCommit(true);
			int a = st.executeUpdate("Insert into person values(104, 'Virendra', 'Kashyap', 'Indore')");
			System.out.println("First record inserted");
			Thread.sleep(30000);
			
			int b = st.executeUpdate("Insert into person values(104, 'Mohan', 'Nayak dsfdsfsadfsd', 'Khandwa')");
			System.out.println("Second record inserted");
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
