package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.AccountDTO;
import com.dto.UserDTO;

public class AccountService {
	Connection con = null;
	PreparedStatement ps = null;

	public AccountService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(AccountDTO dto) {
		try {
			ps = con.prepareStatement("INSERT INTO account VALUES(?, ?, ?, ?)");
			ps.setInt(1, dto.getId());
			ps.setString(2, dto.getUserName());
			ps.setString(3, dto.getAccountNo());
			ps.setInt(4, dto.getBalance());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public AccountDTO getAccountDetails(String accountId) {
		AccountDTO dto = null;
		try {
			String sql = "Select * from account where AccountNumber = ?";
			ps = con.prepareStatement(sql);	
			ps.setString(1, accountId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setUserName(rs.getString(2));
				dto.setAccountNo(rs.getString(3));
				dto.setBalance(rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;

	}

	public void update(AccountDTO dto) {
		try {
			String sql = "UPDATE account SET UserName = ?, Balance = ? where AccountNumber = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getUserName());
			ps.setString(3, dto.getAccountNo());
			ps.setInt(2, dto.getBalance());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
