package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("customer")

public class CustomerService implements CustomerServiceInterface{

	@Autowired
	private CustomerDAO dao;
	
	
	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		dao.save(customer);
	}


	@Override
	public Customer findById(int uid) {
		// TODO Auto-generated method stub
		Optional<Customer> obj = dao.findById(Integer.valueOf(uid));
		Customer customer = obj.get();
		return customer;
		
	}
		

}
