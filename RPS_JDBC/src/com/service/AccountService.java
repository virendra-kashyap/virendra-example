package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.AccountDTO;

public class AccountService {
	Connection con = null;
	PreparedStatement ps = null;

	public AccountService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterdemo", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addAccount(AccountDTO dto) {
		try {
			ps = con.prepareStatement("Insert into account values(?, ?, ?, ?)");
			ps.setInt(1, dto.getId());
			ps.setString(2, dto.getAccountNo());
			ps.setString(3, dto.getUserName());
			ps.setInt(4, dto.getBalance());

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAccount(AccountDTO dto) {
		try {

			String sql = "Update account Set UserName = ?, Balance = ? Where AccountNo = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getUserName());
			ps.setInt(2, dto.getBalance());

			ps.setString(3, dto.getAccountNo());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public AccountDTO getAccount(String accountNo) {
		AccountDTO dto = null;
		try {
			String sql = "Select * from account where accountNo = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, accountNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setUserName(rs.getString(3));
				dto.setBalance(rs.getInt(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;

	}
}
