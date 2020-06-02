package com.utility;

public enum Decizion {

	YES("Y"), NO("N");

	String key;

	Decizion(String key) {
		this.key = key;
	}

	Decizion getValue(String x) {
		if ("Y".equals(x)) {
			return YES;
		} else if ("N".equals(x)) {
			return NO;
		} else
			throw new IllegalArgumentException();
	}

}
