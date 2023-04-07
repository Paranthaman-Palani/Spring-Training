package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bank")
public class BankService {

	@Autowired
	private CustomerDAO dao;
	
	public void doCredit(int uid,int cramt) {
		Optional<Customer> obj = dao.findById(Integer.valueOf(uid));
		Customer customer = obj.get();
		int amt=customer.getAmount();
		int newamt=amt+cramt;
		customer.setAmount(newamt);
		dao.save(customer);
	}

	public void doDebit(int uid,int dramt) throws Insufficient {
		Optional<Customer> obj = dao.findById(Integer.valueOf(uid));
		Customer customer = obj.get();
		int amt = customer.getAmount();
		if(amt < dramt) {
			throw new Insufficient("Not enough money to transfer....");
		}
		int newamt = amt - dramt;
		customer.setAmount(newamt);
		dao.save(customer);
	}

}
