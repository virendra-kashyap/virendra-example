package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.dto.RegistrationDTO;
import com.service.RegistrationService;

public class RegistrationTest {
	public static void main(String[] args) {
		RegistrationDTO dto = new RegistrationDTO();

		RegistrationService service = new RegistrationService();
		/*
		 * RegistrationDTO dto1 = service.get(10006);
		 * System.out.println(dto1.getId() + "\t" + dto1.getFirstName() + "\t" +
		 * dto1.getLastName() + "\t" + dto1.getPwd() + "\t" +
		 * dto1.getAddress());
		 */

		ArrayList list = service.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			RegistrationDTO obj = (RegistrationDTO) it.next();
			System.out.println(obj.getId() + " \t\t\t " + obj.getFirstName() + "\t\t\t" + obj.getLastName() + "\t\t\t" + obj.getPwd()
					+ "\t\t\t" + obj.getAddress());
		}
	}

}
