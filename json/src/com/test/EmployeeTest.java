package com.test;

import org.json.JSONObject;

import com.service.EmployeeService;

public class EmployeeTest {
	public static void main(String[] args) throws Exception {
		/*
		 * JSONObject obj = new JSONObject(); obj.put("name", "dainy");
		 * obj.put("salary", 5000); obj.put("age", 29);
		 */ EmployeeService service = new EmployeeService();
		// service.update("5edf6eb32454c200177a26a4", obj);
		// System.out.println(obj);
		String obj = service.get();
		System.out.println(obj);

		// NObject obj = new JSONObject();
		// service.delete("5eda1be1f9695400173d8ff3");

	}

}
