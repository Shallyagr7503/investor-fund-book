package com.sapient.domain;

public class Holding {

	private String holdingName;
	private Double price;

	public Holding() {
		// TODO Auto-generated constructor stub
	}

	
	public Holding(String holdingName, Double price) {
		super();
		this.holdingName = holdingName;
		this.price = price;
	}


	public String getHoldingName() {
		return holdingName;
	}

	public void setHoldingName(String holdingName) {
		this.holdingName = holdingName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
