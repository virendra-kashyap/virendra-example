package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.dto.UserDTO;
import com.service.UserService;

public class UserTest {
	public static void main(String[] args) {
		UserDTO dto = new UserDTO();
		dto.setPassword("virendra44");

		dto.setEmailId("virendra44@gmail.com");

		UserService service = new UserService();
		service.update(dto);

		UserDTO dto1 = service.getByEmailId("virendra@gmail.com");

		if (dto1 != null) {

			System.out.println(dto1.getFirstName() + "\t" + dto1.getLastName() + "\t" + dto1.getEmailId() + "\t"
					+ dto1.getPassword() + "\t" + dto1.getAddress() + "\t" + dto1.getMobileNumber());
		} else {
			System.out.println("EmailId Don't Exist");
		}
		/*
		 * UserDTO dto2 = service.authenticate("mohit224@gmail.com",
		 * "mohit224"); System.out.println(dto2.getFirstName() + "\t" +
		 * dto2.getLastName() + "\t" + dto2.getEmailId() + "\t" +
		 * dto2.getPassword() + "\t" + dto2.getAddress() + "\t" +
		 * dto2.getMobileNumber());
		 * 
		 * ArrayList list = service.listByPage(0, 4); Iterator it =
		 * list.iterator(); while (it.hasNext()) { UserDTO dto3 = (UserDTO)
		 * it.next(); System.out.println( dto3.getId() + "\t" +
		 * dto3.getFirstName() + "\t" + dto3.getLastName() + "\t" +
		 * dto3.getEmailId() + "\t" + dto3.getPassword() + "\t" +
		 * dto3.getAddress() + "\t" + dto3.getMobileNumber());
		 */
	}
}
