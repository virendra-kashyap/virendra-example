package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.MarksheetDTO;

public class MarksheetService {
	PreparedStatement ps = null;

	public void add(MarksheetDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			ps = con.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
			ps.setString(1, dto.getRollNo());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getPhysics());
			ps.setInt(4, dto.getChemistry());
			ps.setInt(5, dto.getMaths());
			ps.setInt(6, dto.getTotal());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update(MarksheetDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			String sql = "update marksheet set name = ?, physics = ?, chemistry = ?, maths = ?,  total = ? where rollNo=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getPhysics());
			ps.setInt(3, dto.getChemistry());
			ps.setInt(4, dto.getMaths());
			ps.setInt(5, dto.getTotal());
			ps.setString(6, dto.getRollNo());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete(MarksheetDTO dto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			String sql = "delete from marksheet where rollNo = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getRollNo());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public MarksheetDTO getMarksheet(String rollNo) {
		MarksheetDTO dto = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			String sql = "SELECT * FROM marksheet WHERE rollNo = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, rollNo);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto = new MarksheetDTO();
				dto.setRollNo(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPhysics(rs.getInt(3));
				dto.setChemistry(rs.getInt(4));
				dto.setMaths(rs.getInt(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;

	}

	public ArrayList marksheetList() {
		ArrayList list = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			String sql = "SELECT * FROM marksheet";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			MarksheetDTO dto = null;
			while (rs.next()) {
				dto = new MarksheetDTO();
				dto.setRollNo(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPhysics(rs.getInt(3));
				dto.setChemistry(rs.getInt(4));
				dto.setMaths(rs.getInt(5));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList searchMarksheet(String keyWord) {
		ArrayList list = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			String sql = "SELECT * FROM marksheet WHERE name LIKE  '" + keyWord + "%' ";
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MarksheetDTO dto = null;
				dto = new MarksheetDTO();
				dto.setRollNo(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setPhysics(rs.getInt(3));
				dto.setChemistry(rs.getInt(4));
				dto.setMaths(rs.getInt(5));
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
