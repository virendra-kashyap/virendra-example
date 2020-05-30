package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.AccountDTO;
import com.dto.UserDTO;

public class AccountService {
	Connection con = null;
	PreparedStatement ps = null;

	public AccountService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ors", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(AccountDTO dto) {
		try {
			ps = con.prepareStatement(
					"insert into account(AccountNo, UserName, EmailId, Password, Balance) values(?, ?, ?, ?, ?)");
			ps.setString(1, dto.getAccountNo());
			ps.setString(2, dto.getUserName());
			ps.setString(3, dto.getEmailId());
			ps.setString(4, dto.getPassword());
			ps.setInt(5, dto.getBalance());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			String sql = "delete from account where Id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(AccountDTO dto) {
		try {
			String sql = "update account set AccountNo=?, UserName=?, EmailId=?, Password=?, Balance=? where Id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAccountNo());
			ps.setString(2, dto.getUserName());
			ps.setString(3, dto.getEmailId());
			ps.setString(4, dto.getPassword());
			ps.setInt(5, dto.getBalance());
			ps.setInt(6, dto.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList list() {
		ArrayList list = new ArrayList<>();
		AccountDTO dto = null;
		try {
			String sql = "select * from account";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setUserName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setBalance(rs.getInt(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public AccountDTO authenticate(String emailId, String password) {
		AccountDTO dto = null;
		try {
			String sql = "select * from account where EmailId=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, emailId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setUserName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setBalance(rs.getInt(6));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;

	}

	public ArrayList searchByName(String name) {
		ArrayList list = new ArrayList();

		try {
			String sql = "SELECT * FROM account WHERE UserName LIKE  '%" + name + "%' ";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountDTO dto = null;
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setUserName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setBalance(rs.getInt(6));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public AccountDTO getById(int id) {
		AccountDTO dto = null;
		try {

			String sql = "select * from account where Id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setUserName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setBalance(rs.getInt(6));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public ArrayList listByPage(int pageIndex, int pageSize) {
		ArrayList list = new ArrayList();
		try {
			String sql = "select * from account limit " + pageIndex + "," + pageSize + "";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			AccountDTO dto = null;
			while (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setUserName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setBalance(rs.getInt(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	public AccountDTO getByEmailId(String emailId) {
		AccountDTO dto = null;
		try {
			String sql = "select * from account where EmailId=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setUserName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setBalance(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public AccountDTO getByAccountNo(String accountNo) {
		AccountDTO dto = null;
		try {
			String sql = "select * from account where AccountNo=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, accountNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setUserName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setBalance(rs.getInt(6));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
