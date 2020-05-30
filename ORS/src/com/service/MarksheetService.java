package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.MarksheetDTO;
import com.dto.UserDTO;

public class MarksheetService {
	Connection con = null;
	PreparedStatement ps = null;

	public MarksheetService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ors", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(MarksheetDTO dto) {
		try {
			ps = con.prepareStatement(
					"insert into marksheet(RollNumber, Name, Hindi, English, Physics, Chemistry, Maths) values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, dto.getRollNumber());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getHindi());
			ps.setInt(4, dto.getEnglish());
			ps.setInt(5, dto.getPhysics());
			ps.setInt(6, dto.getChemistry());
			ps.setInt(7, dto.getMaths());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			String sql = "delete from marksheet where Id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(MarksheetDTO dto) {
		try {
			String sql = "update marksheet set RollNumber = ?, Name=?, Hindi=?, English=?, Physics=?, Chemistry=?, Maths=? where Id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getRollNumber());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getHindi());
			ps.setInt(4, dto.getEnglish());
			ps.setInt(5, dto.getPhysics());
			ps.setInt(6, dto.getChemistry());
			ps.setInt(7, dto.getMaths());
			ps.setInt(8, dto.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList list() {
		ArrayList list = new ArrayList();
		MarksheetDTO dto = null;
		try {
			String sql = "select * from marksheet";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new MarksheetDTO();
				dto.setId(rs.getInt(1));
				dto.setRollNumber(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setHindi(rs.getInt(4));
				dto.setEnglish(rs.getInt(5));
				dto.setPhysics(rs.getInt(6));
				dto.setChemistry(rs.getInt(7));
				dto.setMaths(rs.getInt(8));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public ArrayList searchByName(String name) {
		ArrayList list = new ArrayList();
		try {
			String sql = "SELECT * FROM marksheet WHERE Name LIKE  '%" + name + "%' ";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MarksheetDTO dto = null;
				dto = new MarksheetDTO();
				dto.setId(rs.getInt(1));
				dto.setRollNumber(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setHindi(rs.getInt(4));
				dto.setEnglish(rs.getInt(5));
				dto.setPhysics(rs.getInt(6));
				dto.setChemistry(rs.getInt(7));
				dto.setMaths(rs.getInt(8));
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public MarksheetDTO getById(int id) {
		MarksheetDTO dto = null;
		try {
			String sql = "select * from marksheet where Id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new MarksheetDTO();
				dto.setId(rs.getInt(1));
				dto.setRollNumber(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setHindi(rs.getInt(4));
				dto.setEnglish(rs.getInt(5));
				dto.setPhysics(rs.getInt(6));
				dto.setChemistry(rs.getInt(7));
				dto.setMaths(rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public ArrayList listByPage(int pageIndex, int pageSize) {
		ArrayList list = new ArrayList();
		try {
			String sql = "select * from marksheet limit " + pageIndex + "," + pageSize + "";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			MarksheetDTO dto = null;
			while (rs.next()) {
				dto = new MarksheetDTO();
				dto.setId(rs.getInt(1));
				dto.setRollNumber(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setHindi(rs.getInt(4));
				dto.setEnglish(rs.getInt(5));
				dto.setPhysics(rs.getInt(6));
				dto.setChemistry(rs.getInt(7));
				dto.setMaths(rs.getInt(8));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public MarksheetDTO getByRollNumber(String rollNumber) {
		MarksheetDTO dto = null;
		try {
			String sql = "select * from marksheet where RollNumber=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, rollNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new MarksheetDTO();
				dto.setId(rs.getInt(1));
				dto.setRollNumber(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setHindi(rs.getInt(4));
				dto.setEnglish(rs.getInt(5));
				dto.setPhysics(rs.getInt(6));
				dto.setChemistry(rs.getInt(7));
				dto.setMaths(rs.getInt(8));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
