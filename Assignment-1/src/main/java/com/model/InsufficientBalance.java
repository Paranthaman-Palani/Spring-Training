package com.model;

public class InsufficientBalance extends Exception {
	private static final long serialVersionUID = 1L;
	String msg;
	public InsufficientBalance(String msg) {
		// TODO Auto-generated constructor stub
		this.msg=msg;
	}
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }
}
