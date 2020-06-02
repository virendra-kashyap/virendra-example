package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class SampleTest {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			CallableStatement call = con.prepareCall("CALL AddDepartment(?, ?, ?)");
			call.setString(1, "107");
			call.setString(2, "DS1006");
			call.setString(3, "Area Manager");
			call.execute();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
