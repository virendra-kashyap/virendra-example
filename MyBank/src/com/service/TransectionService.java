package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plus", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addTransection(TransectionDTO dto) {
		try {
			ps = con.prepareStatement(
					"insert into account_transection(AccountNo, TransectionType, Transection) value(?, ?, ?)");
			ps.setString(1, dto.getAccountNo());
			ps.setString(2, dto.getTransectionType());
			ps.setInt(3, dto.getTransection());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
