package com.test;

import java.sql.Timestamp;
import java.util.Date;

import com.dto.AccountDTO;
import com.dto.TransectionDTO;
import com.service.AccountService;
import com.service.TransectionService;

public class AccountTest {

	public static void main(String[] args) throws Exception {
		AccountTest test = new AccountTest();
		test.add("100PNB001", 200, "Withdraw");

	}

	public void add(String accountNo, int bal, String TransectionType) throws Exception {
		AccountDTO dto = new AccountDTO();
		AccountService service = new AccountService();

		AccountDTO accountdto = service.getAccount(accountNo);

		if (accountdto == null) {
			System.out.println("Account Not Exists : ");
			System.exit(1);
		}

		TransectionDTO transectiondto = new TransectionDTO();
		TransectionService transectionservice = new TransectionService();
		transectionservice.transectionOpen();
		transectiondto.setAccountId(accountdto.getAccountNo());

		transectiondto.setTransection(bal);
		transectiondto.setTransectionType(TransectionType);
		Timestamp time = new Timestamp(new Date().getTime());
		transectiondto.setCurrentTime(time);
		transectionservice.addTransection(transectiondto);

		int balance = accountdto.getBalance();
		System.out.println("Current Balance : " + balance);
		if (transectiondto.getTransectionType().equalsIgnoreCase("diposit")) {
			balance = balance + transectiondto.getTransection();
			System.out.println("Diposit amount : " + transectiondto.getTransection());
			System.out.println("Total balance : " + balance);
		} else if (transectiondto.getTransectionType().equalsIgnoreCase("withdraw")) {
			balance = balance - transectiondto.getTransection();
			System.out.println("Withdraw amuont : " + transectiondto.getTransection());
			System.out.println("Total balance : " + balance);
		}
		if (balance > 0) {
			dto.setAccountNo(transectiondto.getAccountId());
			dto.setBalance(balance);
			dto.setUserName(accountdto.getUserName());

			service.updateAccount(dto);
			transectionservice.transectionClose();
		} else {
			System.out.println("Incficient Balance");
			transectionservice.transectionRollback();
		}

	}

}
