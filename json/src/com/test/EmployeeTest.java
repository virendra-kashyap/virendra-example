package com.test;

import org.json.simple.JSONObject;

import com.service.EmployeeService;

public class EmployeeTest {
	public static void main(String[] args) throws Exception {
		EmployeeService service = new EmployeeService();
		service.get();

		// NObject obj = new JSONObject();
		// service.delete("5eda1be1f9695400173d8ff3");

	}

}
