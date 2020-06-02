package com.dto;

public class TransectionDTO {
	private int id;
	private String accountId;
	private int transection;
	private String transectionType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getTransection() {
		return transection;
	}

	public void setTransection(int transection) {
		this.transection = transection;
	}

	public String getTransectionType() {
		return transectionType;
	}

	public void setTransectionType(String transectionType) {
		this.transectionType = transectionType;
	}

}
