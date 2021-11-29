package com.sapient.error;

public class InvestorNotFoundException extends RuntimeException {
	private String error;

	public InvestorNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvestorNotFoundException(String error) {
		super();
		this.error = error;
	}

}
