package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.dto.AccountDTO;
import com.service.AccountService;

public class AccountTest {
	public static void main(String[] args) {
		AccountService service = new AccountService();
		ArrayList list = service.listByPage(0, 3);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			AccountDTO dto = (AccountDTO) it.next();
			System.out.println(dto.getId() + "\t" + dto.getAccountNo() + "\t" + dto.getFirstName() + "\t"
					+ dto.getLastName() + "\t" + dto.getEmailId() + "\t" + dto.getPassword() + "\t" + dto.getContactNo()
					+ "\t" + dto.getAddress() + "\t" + dto.getBalance());
		
		}
	}

}
