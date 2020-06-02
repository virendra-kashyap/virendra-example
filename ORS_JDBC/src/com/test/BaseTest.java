package com.test;

import java.util.ArrayList;

import com.dto.UserDTO;
import com.service.BaseService;
import com.service.UserService;

public class BaseTest {

public static void main(String[] args) {
	
	UserDTO dto = new UserDTO();
	dto.setFirstName("Virendra");
	dto.setLastName("Kashyap");
	dto.setDto(dto);
	UserService service = new UserService();
	service.add(dto);
	
}


}
