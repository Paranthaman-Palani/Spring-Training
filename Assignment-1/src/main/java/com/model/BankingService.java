package com.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("bss")
@Transactional
public class BankingService {
	
	@Autowired
	private AccountsDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void doCredit(int accountId,int creditAmount) {
		AccountsDTO dto=dao.findByID(accountId);
		int amount=dto.getAmount();
		int newAmount=amount+creditAmount;
		dto.setAmount(newAmount);
		dao.updateUser(dto);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {InsufficientBalance.class})
	public void doDebit(int accountId,int debitAmount)throws InsufficientBalance {
		AccountsDTO dto=dao.findByID(accountId);
		int amount = dto.getAmount();
		if(amount< debitAmount) {
			throw new InsufficientBalance("Not enough money to transfer....");
		}
		
		int newAmount = amount - debitAmount;
		dto.setAmount(newAmount);
		dao.updateUser(dto);
		
		
	}
	public AccountsDAO getDao() {
		return dao;
	}
	public void setDao(AccountsDAO dao) {
		this.dao = dao;
	}
}