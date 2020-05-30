package com.dto;

public class TransectionDTO {
	private int id;
	private String accountNo;
	private String transectionType;
	private int transection;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getTransectionType() {
		return transectionType;
	}

	public void setTransectionType(String transectionType) {
		this.transectionType = transectionType;
	}

	public int getTransection() {
		return transection;
	}

	public void setTransection(int transection) {
		this.transection = transection;
	}

}
