package com.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.MarksheetDTO;
import com.dto.RegistrationDTO;

public class RegistrationService {
	Connection con = null;
	CallableStatement call = null;

	public RegistrationService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(RegistrationDTO dto) {
		try {
			call = con.prepareCall("CALL InsertRegistration(?, ?, ?, ?, ?)");
			call.setInt(1, dto.getId());
			call.setString(2, dto.getFirstName());
			call.setString(3, dto.getLastName());
			call.setString(4, dto.getPwd());
			call.setString(5, dto.getAddress());
			call.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(RegistrationDTO dto) {
		try {
			call = con.prepareCall("CALL UpdateRegistration(?, ?, ?, ?, ?)");
			call.setInt(1, dto.getId());
			call.setString(2, dto.getFirstName());
			call.setString(3, dto.getLastName());
			call.setString(4, dto.getPwd());
			call.setString(5, dto.getAddress());

			call.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(RegistrationDTO dto) {
		try {
			call = con.prepareCall("CALL DeleteRegistration(?)");
			call.setInt(1, dto.getId());
			call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public RegistrationDTO get(int id) {
		RegistrationDTO dto = null;
		try {

			call = con.prepareCall("CALL GetRegistration(?)");
			call.setInt(1, id);
			ResultSet rs = call.executeQuery();

			if (rs.next()) {
				dto = new RegistrationDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setPwd(rs.getString(4));
				dto.setAddress(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;

	}

	public ArrayList list() {
		ArrayList list = new ArrayList();
		try {
			call = con.prepareCall("CALL ListRegistration()");
			ResultSet rs = call.executeQuery();
			RegistrationDTO dto = null;
			while (rs.next()) {
				dto = new RegistrationDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setPwd(rs.getString(4));
				dto.setAddress(rs.getString(5));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList search(String keyWord) {
		ArrayList list = new ArrayList();

		try {
			String sql = "SELECT * FROM marksheet WHERE name LIKE  '" + keyWord + "%' ";
			System.out.println(sql);
			call = con.prepareCall(sql);
			ResultSet rs = call.executeQuery();
			while (rs.next()) {
				RegistrationDTO dto = null;
				dto = new RegistrationDTO();
				dto.setId(rs.getInt(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setPwd(rs.getString(4));
				dto.setAddress(rs.getString(5));
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
