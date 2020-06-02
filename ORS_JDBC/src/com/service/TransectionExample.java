package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransectionExample {
	Connection con = null;
	Statement st = null;

	public static void main(String[] args) {
		TransectionExample service = new TransectionExample();
		service.TransectionService();
	}

	public void TransectionService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			con.setAutoCommit(false);
			st = con.createStatement();
			int i = st.executeUpdate(
					"INSERT INTO useraccount(Id, AccountName, Balance) Values(2, 'Rahul Chaudhary', 10000)");
			int ib = st
					.executeUpdate("INSERT INTO useraccount(Id, AccountName, Balance) Values(4, 'Mala Yadav', 20000)");
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
			}

		}
	}

}
