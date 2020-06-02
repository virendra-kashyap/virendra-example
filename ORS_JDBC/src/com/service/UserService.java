package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.BaseDTO;
import com.dto.MarksheetDTO;
import com.dto.UserDTO;

public class UserService extends BaseService {
	PreparedStatement ps = null;
	Connection con = null;

	public UserService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void add(Object dto) {
		UserDTO userDTO = (UserDTO) dto;
		System.out.println(userDTO.getFirstName());

	}

	/*
	 * public void addUser(UserDTO dto) { try { ps = con.prepareStatement(
	 * "INSERT INTO userInfo VALUES(?, ?, ?, ?, ?, ?)"); ps.setInt(1,
	 * dto.getId()); ps.setString(2, dto.getFirstName()); ps.setString(3,
	 * dto.getLastName()); ps.setString(4, dto.getAddress()); ps.setString(5,
	 * dto.getContactNo()); ps.setString(6, dto.getPassword()); ps.execute(); }
	 * catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	public void updateUser(UserDTO dto) {
		try {
			String sql = "UPDATE userInfo SET firstName = ?, lastName = ?, address = ?, contactNo = ?, password = ? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getFirstName());
			ps.setString(2, dto.getLastName());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getContactNo());
			ps.setString(5, dto.getPassword());
			ps.setInt(6, dto.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(UserDTO dto) {
		try {
			String sql = "DELETE FROM UserInfo WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserDTO getUser(int id) {
		UserDTO dto = null;
		try {
			String sql = "SELECT * FROM userInfo WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setContactNo(rs.getString(5));
				dto.setPassword(rs.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;

	}

	public ArrayList listUser() {
		ArrayList list = new ArrayList();
		try {
			String sql = "SELECT * FROM userInfo";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			UserDTO dto = null;
			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setContactNo(rs.getString(5));
				dto.setPassword(rs.getString(6));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public ArrayList searchUser(String keyWord) {
		ArrayList list = new ArrayList();

		try {
			String sql = "SELECT * FROM userInfo WHERE firstName LIKE  '" + keyWord + "%' ";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserDTO dto = null;
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setContactNo(rs.getString(5));
				dto.setPassword(rs.getString(6));
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public boolean authenticate(int id, String password) {
		try {
			String sql = "SELECT id, password FROM userInfo WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			String orgId = "", orPass = "";
			while (rs.next()) {
				orgId = rs.getString("id");
				orPass = rs.getString("password");
			}
			if (orPass.equals(password)) {
				return true;
			} else {
				System.err.println("User is not valid : ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList listByPage(int pageIndex, int pageSize) {
		ArrayList list = new ArrayList();
		try {
			String sql = "SELECT * FROM userInfo LIMIT " + pageIndex + " ," + pageSize + "";
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			UserDTO dto = null;
			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setContactNo(rs.getString(5));
				dto.setPassword(rs.getString(6));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

}
