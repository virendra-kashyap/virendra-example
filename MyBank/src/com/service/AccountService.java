package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.AccountDTO;

public class AccountService {
	Connection con = null;
	PreparedStatement ps = null;

	public AccountService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plus", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(AccountDTO dto) {
		try {
			ps = con.prepareStatement(
					"insert into account(AccountNo, FirstName, LastName, EmailId, Password, ContactNo, Address, Balance) values(?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, dto.getAccountNo());
			ps.setString(2, dto.getFirstName());
			ps.setString(3, dto.getLastName());
			ps.setString(4, dto.getEmailId());
			ps.setString(5, dto.getPassword());
			ps.setString(6, dto.getContactNo());
			ps.setString(7, dto.getAddress());
			ps.setInt(8, dto.getBalance());
			ps.execute();

		} catch (SQLException e) {
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
			String sql = "update account set AccountNo = ?, FirstName=?, LastName=?, EmailId=?, Password=?, ContactNo=?, Address=?, Balance = ? where Id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAccountNo());
			ps.setString(2, dto.getFirstName());
			ps.setString(3, dto.getLastName());
			ps.setString(4, dto.getEmailId());
			ps.setString(5, dto.getPassword());
			ps.setString(6, dto.getContactNo());
			ps.setString(7, dto.getAddress());
			ps.setInt(8, dto.getBalance());
			ps.setInt(9, dto.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList list() {
		ArrayList list = new ArrayList();
		AccountDTO dto = null;
		try {
			String sql = "select * from account";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setFirstName(rs.getString(3));
				dto.setLastName(rs.getString(4));
				dto.setEmailId(rs.getString(5));
				dto.setPassword(rs.getString(6));
				dto.setContactNo(rs.getString(7));
				dto.setAddress(rs.getString(8));
				dto.setBalance(rs.getInt(9));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList searchByName(String name) {
		ArrayList list = new ArrayList();
		AccountDTO dto = null;
		try {
			String sql = "select * from account where FirstName LIKE '%" + name + "%' ";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setFirstName(rs.getString(3));
				dto.setLastName(rs.getString(4));
				dto.setEmailId(rs.getString(5));
				dto.setPassword(rs.getString(6));
				dto.setContactNo(rs.getString(7));
				dto.setAddress(rs.getString(8));
				dto.setBalance(rs.getInt(9));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public AccountDTO authenticate(String emailid, String password) {
		AccountDTO dto = null;
		try {
			String sql = "select * from account where EmailId = ? and Password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, emailid);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setFirstName(rs.getString(3));
				dto.setLastName(rs.getString(4));
				dto.setEmailId(rs.getString(5));
				dto.setPassword(rs.getString(6));
				dto.setContactNo(rs.getString(7));
				dto.setAddress(rs.getString(8));
				dto.setBalance(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public AccountDTO getById(int id) {
		AccountDTO dto = null;
		try {
			String sql = "select * from account Where Id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setFirstName(rs.getString(3));
				dto.setLastName(rs.getString(4));
				dto.setEmailId(rs.getString(5));
				dto.setPassword(rs.getString(6));
				dto.setContactNo(rs.getString(7));
				dto.setAddress(rs.getString(8));
				dto.setBalance(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public ArrayList listByPage(int pageIndex, int pageSize) {
		ArrayList list = new ArrayList();
		AccountDTO dto = null;
		try {
			String sql = "select * from account limit " + pageIndex + "," + pageSize + "";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setFirstName(rs.getString(3));
				dto.setLastName(rs.getString(4));
				dto.setEmailId(rs.getString(5));
				dto.setPassword(rs.getString(6));
				dto.setContactNo(rs.getString(7));
				dto.setAddress(rs.getString(8));
				dto.setBalance(rs.getInt(9));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public AccountDTO getByEmailId(String emailid) {
		AccountDTO dto = null;
		try {
			String sql = "select * from account Where EmailId = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, emailid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setFirstName(rs.getString(3));
				dto.setLastName(rs.getString(4));
				dto.setEmailId(rs.getString(5));
				dto.setPassword(rs.getString(6));
				dto.setContactNo(rs.getString(7));
				dto.setAddress(rs.getString(8));
				dto.setBalance(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public AccountDTO getByAccountNo(String accountno) {
		AccountDTO dto = null;
		try {
			String sql = "select * from account Where AccountNo = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, accountno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setId(rs.getInt(1));
				dto.setAccountNo(rs.getString(2));
				dto.setFirstName(rs.getString(3));
				dto.setLastName(rs.getString(4));
				dto.setEmailId(rs.getString(5));
				dto.setPassword(rs.getString(6));
				dto.setContactNo(rs.getString(7));
				dto.setAddress(rs.getString(8));
				dto.setBalance(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
