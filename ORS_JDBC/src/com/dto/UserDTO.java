package com.dto;

public class UserDTO extends BaseDTO {

	private String firstName;
	private String lastName;
	private String address;
	private String contactNo;
	private String password;

	public UserDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public UserDTO setDto(Object dto) {
		UserDTO userDTO = (UserDTO) dto;
		firstName = userDTO.getFirstName();
		lastName = userDTO.getLastName();
		return userDTO;
	}

}
