package com.test;

import com.dto.TransectionDTO;
import com.service.TransectionService;

public class TransectionTest {
	public static void main(String[] args) {
		TransectionDTO dto = new TransectionDTO();
		TransectionService service = new TransectionService();
		dto.setId(100);
		dto.setAccountId("101");
		dto.setTransection(1000);
		dto.setTransectionType("Deposit");
		service.add(dto);
	}

}
