package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.dto.UserDTO;

public class UserService {
	Connection con = null;
	PreparedStatement ps = null;

	public UserService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ors", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(UserDTO dto) {
		try {
			ps = con.prepareStatement(
					"insert into user(FirstName, LastName, EmailId, Password, Address, MobileNumber) values(?, ?, ?, ?, ?, ?)");
			ps.setString(1, dto.getFirstName());
			ps.setString(2, dto.getLastName());
			ps.setString(3, dto.getEmailId());
			ps.setString(4, dto.getPassword());
			ps.setString(5, dto.getAddress());
			ps.setString(6, dto.getMobileNumber());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(int id) {
		try {
			String sql = "delete from user where ID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(UserDTO dto) {
		try {
			String sql = "update user SET FirstName=?, LastName=?, EmailId=?, Password=?, Address=?, MobileNumber=? where Id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getFirstName());
			ps.setString(2, dto.getLastName());
			ps.setString(3, dto.getEmailId());
			ps.setString(4, dto.getPassword());
			ps.setString(5, dto.getAddress());
			ps.setString(6, dto.getMobileNumber());
			ps.setInt(7, dto.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList list() {
		ArrayList list = new ArrayList();
		UserDTO dto = null;
		try {
			String sql = "select * from user";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setAddress(rs.getString(6));
				dto.setMobileNumber(rs.getString(7));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList searchByName(String name) {
		ArrayList list = new ArrayList();
		UserDTO dto = null;
		try {
			String sql = "SELECT * FROM user WHERE FirstName LIKE  '%" + name + "%' ";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setAddress(rs.getString(6));
				dto.setMobileNumber(rs.getString(7));
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public UserDTO getById(int id) {
		UserDTO dto = null;
		try {

			String sql = "select * from user where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setAddress(rs.getString(6));
				dto.setMobileNumber(rs.getString(7));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public UserDTO authenticate(String emailId, String password) {
		UserDTO dto = null;
		try {
			String sql = "select * from user where EmailId = ? and Password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emailId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setAddress(rs.getString(6));
				dto.setMobileNumber(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;

	}

	public ArrayList listByPage(int pageIndex, int pageSize) {
		ArrayList list = new ArrayList();
		try {
			String sql = "select * from user limit " + pageIndex + "," + pageSize + "";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			UserDTO dto = null;
			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setAddress(rs.getString(6));
				dto.setMobileNumber(rs.getString(7));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	public UserDTO getByEmailId(String emailId) {
		UserDTO dto = null;
		try {
			String sql = "select * from user where EmailId=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setEmailId(rs.getString(4));
				dto.setPassword(rs.getString(5));
				dto.setAddress(rs.getString(6));
				dto.setMobileNumber(rs.getString(7));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}