package com.utility;

public class BaseUtility {

	public static String toEmpty(String value) {
		if (value == null || value.length() == 0) {
			return "";
		}
		return value;
	}

	public static int toInteger(String value) {
		if (value != null && value.length() > 0) {
			return Integer.valueOf(value);
		}
		return 0;
	}

	public static int toInteger(Object value) {
		String objValue = value.toString();
		return toInteger(objValue);
	}

}
