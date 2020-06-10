package org.json;

import org.json.JSONObject;

public class JsonExample {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();	
		obj.put("name", "dainy");
		obj.put("age", new Integer(27));
		obj.put("salary", new Double(5000));
		System.out.println(obj);
	}

}
