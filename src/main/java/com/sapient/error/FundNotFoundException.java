package com.sapient.error;

public class FundNotFoundException extends RuntimeException{
	private String error;

	public FundNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FundNotFoundException(String error) {
		super();
		this.error = error;
	}

}
