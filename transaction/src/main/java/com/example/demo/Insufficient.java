package com.example.demo;


public class Insufficient extends Exception {
	private static final long serialVersionUID = 1L;
	String msg;
	public Insufficient(String msg) {
		// TODO Auto-generated constructor stub
		this.msg=msg;
	}
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }
}
