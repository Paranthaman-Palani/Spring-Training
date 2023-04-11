package com.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("tss")
@Transactional
public class TransactionService {
	
	@Autowired
	private BankingService bss;
	
	public BankingService getBss() {
		return bss;
	}
	public void setBss(BankingService bss) {
		this.bss = bss;
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor= { InsufficientBalance.class})
	public void moneyTransfer(int creditId,int debitId,int amount)throws InsufficientBalance {
		bss.doCredit(creditId, amount);
		bss.doDebit(debitId, amount);	
	}
}

