package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.dto.AccountDTO;
import com.service.AccountService;

public class AccountTest {
	public static void main(String[] args) {
		AccountDTO dto = new AccountDTO();
		dto.setAccountNo("10PNB03");
		dto.setUserName("Rohit Sharma");
		dto.setEmailId("rohit45@gmail.com");
		dto.setPassword("rohit45");
		dto.setBalance(2000);
		dto.setId(3);
		AccountService service = new AccountService();
		/*
		 * ArrayList list = service.list(); Iterator it = list.iterator(); while
		 * (it.hasNext()) { AccountDTO obj = (AccountDTO) it.next();
		 * System.out.println(obj.getId() + "\t" + obj.getAccountNo() + "\t" +
		 * obj.getUserName() + "\t" + obj.getEmailId() + "\t" +
		 * obj.getPassword() + "\t" + obj.getBalance()); }
		 */
		/*
		 * AccountDTO dto1 = service.authenticate("rohit45@gmail.com",
		 * "rohit45"); System.out.println(dto1.getId() + "\t" +
		 * dto1.getAccountNo() + "\t" + dto1.getUserName() + "\t" +
		 * dto1.getEmailId() + "\t" + dto1.getPassword() + "\t" +
		 * dto1.getBalance());
		 */

		/*
		 * AccountDTO dto1 = service.getById(3); System.out.println(dto1.getId()
		 * + "\t" + dto1.getAccountNo() + "\t" + dto1.getUserName() + "\t" +
		 * dto1.getEmailId() + "\t" + dto1.getPassword() + "\t" +
		 * dto1.getBalance());
		 */
		/*
		 * ArrayList list = service.listByPage(0, 2); Iterator it =
		 * list.iterator(); while (it.hasNext()) { AccountDTO obj = (AccountDTO)
		 * it.next(); System.out.println(obj.getId() + "\t" + obj.getAccountNo()
		 * + "\t" + obj.getUserName() + "\t" + obj.getEmailId() + "\t" +
		 * obj.getPassword() + "\t" + obj.getBalance()); }
		 */
		/*
		 * ArrayList list = service.searchByName("Shahin"); Iterator it =
		 * list.iterator(); while (it.hasNext()) { AccountDTO obj = (AccountDTO)
		 * it.next(); System.out.println(obj.getId() + "\t" + obj.getAccountNo()
		 * + "\t" + obj.getUserName() + "\t" + obj.getEmailId() + "\t" +
		 * obj.getPassword() + "\t" + obj.getBalance()); }
		 */	}

}
