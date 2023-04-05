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
	public void doCredit(int acid,int cramt) {
		AccountsDTO dto=dao.findByID(acid);
		int amt=dto.getAmount();
		int newamt=amt+cramt;
		dto.setAmount(newamt);
		dao.updateUser(dto);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {InsufficientBalance.class}) // do rollback
	public void doDebit(int acid,int dramt)throws InsufficientBalance {
		AccountsDTO dto=dao.findByID(acid);
		int amt = dto.getAmount();
		if(amt < dramt) {
			throw new InsufficientBalance("Not enough money to transfer....");
		}
		int newamt = amt - dramt;
		dto.setAmount(newamt);
		dao.updateUser(dto);
	}
	public AccountsDAO getDao() {
		return dao;
	}
	public void setDao(AccountsDAO dao) {
		this.dao = dao;
	}
}