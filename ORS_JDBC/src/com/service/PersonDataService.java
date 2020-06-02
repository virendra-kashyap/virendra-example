package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class PersonDataService {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Id, FirstName, LastName, Address from person");
			ResultSetMetaData rsmt = rs.getMetaData();
			System.out.println("Catelog Name : " + rsmt.getCatalogName(1));
			System.out.println("Table Name : " + rsmt.getTableName(1) );
			int columnCount = rsmt.getColumnCount();
			System.out.println("Total Columns : " + columnCount);
			
			for (int i = 1; i <= columnCount; i++) {
				System.out.println("Column : " + (i));
				System.out.println("Lable : " + rsmt.getColumnLabel(i));
				System.out.println("Name : " + rsmt.getColumnName(i));
				System.out.println("Type : " + rsmt.getColumnType(i));
				System.out.println("Size : " + rsmt.getColumnDisplaySize(i));
				System.out.println("Precision : " + rsmt.getPrecision(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
