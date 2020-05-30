package com.test;

import com.dto.TransectionDTO;
import com.service.TransectionService;

public class TransectionTest {
	public static void main(String[] args) {
		TransectionDTO dto = new TransectionDTO();
		dto.setAccountNo("10SBI001");
		dto.setTransectionType("deposit");
		dto.setTransection(500);
		TransectionService service = new TransectionService();
	}

}
