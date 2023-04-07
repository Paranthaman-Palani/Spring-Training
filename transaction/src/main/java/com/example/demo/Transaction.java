package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("transaction")
public class Transaction {
	@Autowired
	private BankService bank;

	
	public  void moneyTransfer(int crid,int deid,int amt)throws Insufficient {
		bank.doCredit(crid, amt);
		bank.doDebit(deid, amt);

	}
	

}
