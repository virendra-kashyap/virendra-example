package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.EmployeeDTO;
import com.dto.MarksheetDTO;

public class EmployeeService {
	Connection con = null;
	Statement st = null;

	public EmployeeService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(EmployeeDTO dto) {
		try {
			st = con.createStatement();
			st.addBatch(
					"INSERT INTO employee(empId, empName, salary, empContactNo) values(10006, 'Shivang Dixit', 25000, '9977706000')");
			st.addBatch(
					"INSERT INTO employee(empId, empName, salary, empContactNo) values(10007, 'Shubham Dixit', 30000, '9800285050')");
			st.addBatch(
					"INSERT INTO employee(empId, empName, salary, empContactNo) values(10008, 'Shivendra Dixit', 60000, '9009007581')");
			st.addBatch(
					"INSERT INTO employee(empId, empName, salary, empContactNo) values(10005, 'Payal Kashyap', 50000, '9977730687')");

			int i[] = st.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(EmployeeDTO dto) {
		try {
			st = con.createStatement();
			st.executeUpdate("UPDATE employee SET salary = 48001 WHERE empId = 10002");
			st.executeUpdate("UPDATE employee SET salary = 40001 WHERE empId = 10001");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void delete(EmployeeDTO dto) {
		try {
			st = con.createStatement();
			String sql = "DELETE FROM employee WHERE empId = 10005";
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public EmployeeDTO get() {
		EmployeeDTO dto = null;
		try {

			String sql = "SELECT * FROM employee WHERE empId = 10002";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmpId(rs.getInt(1));
				dto.setEmpName(rs.getString(2));
				dto.setSalary(rs.getInt(3));
				dto.setEmpContactNo(rs.getString(4));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	public ArrayList list() {
		ArrayList list = new ArrayList();
		try {
			String sql = "SELECT * FROM employee";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			EmployeeDTO dto = null;
			while (rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmpId(rs.getInt(1));
				dto.setEmpName(rs.getString(2));
				dto.setSalary(rs.getInt(3));
				dto.setEmpContactNo(rs.getString(4));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList search() {
		ArrayList list = new ArrayList();

		try {
			String sql = "SELECT * FROM employee WHERE empName LIKE  'V%'";
			System.out.println(sql);
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				EmployeeDTO dto = null;
				dto = new EmployeeDTO();
				dto.setEmpId(rs.getInt(1));
				dto.setEmpName(rs.getString(2));
				dto.setSalary(rs.getInt(3));
				dto.setEmpContactNo(rs.getString(4));
				list.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
