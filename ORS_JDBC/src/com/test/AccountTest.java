package com.test;

import com.dto.AccountDTO;
import com.dto.TransectionDTO;
import com.service.AccountService;
import com.service.TransectionService;
import com.utility.TransectionType;

public class AccountTest {
	public static void main(String[] args) throws Exception {
		AccountDTO dto = new AccountDTO();
		AccountService service = new AccountService();

		AccountDTO accountDTO = service.getAccountDetails("100PNB001");
		TransectionService transectionService = new TransectionService();

		transectionService.transectionOpen();

		TransectionDTO transectionDTO = new TransectionDTO();
		transectionDTO.setAccountId(accountDTO.getAccountNo());
		transectionDTO.setTransection(1500);
		transectionDTO.setTransectionType(TransectionType.diposit);
		transectionService.add(transectionDTO);

		int balance = accountDTO.getBalance();
		System.out.println("Current Balance : " + balance);

		if (transectionDTO.getTransectionType().equalsIgnoreCase("Diposit")) {
			balance = balance + transectionDTO.getTransection();
			System.out.println("Diposit amount : " + transectionDTO.getTransection());
			System.out.println("Total balance : " + balance);
		} else if (transectionDTO.getTransectionType().equalsIgnoreCase("Withdraw")) {
			balance = balance - transectionDTO.getTransection();
			System.out.println("Withdraw amount : " + transectionDTO.getTransection());
			System.out.println("Total balance : " + balance);
		}

		if (balance > 0) {
			dto.setAccountNo(transectionDTO.getAccountId());
			dto.setBalance(balance);
			dto.setUserName(accountDTO.getUserName());
			service.update(dto);
			transectionService.transectionClose();
		} else {
			System.out.println("Incficient Balance");
			transectionService.transectionRollback();
		}

	}
}
