package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dto.TransectionDTO;

public class TransectionService {
	Connection con = null;
	PreparedStatement ps = null;

	public void transectionOpen() throws SQLException {
		con.setAutoCommit(false);
	}

	public void transectionClose() throws SQLException {
		con.commit();
	}

	public void transectionRollback() throws SQLException {
		con.rollback();
	}

	public void closeConnection() throws SQLException {
		con.close();
	}

	public TransectionService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(TransectionDTO dto) {
		try {
			ps = con.prepareStatement("Insert Into account_transection values(?, ?, ?, ?)");
			ps.setInt(1, dto.getId());
			ps.setString(2, dto.getAccountId());
			ps.setInt(3, dto.getTransection());
			ps.setString(4, dto.getTransectionType());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
