package com.sapient.domain;

import java.util.ArrayList;
import java.util.List;

public class Fund {

	private String fundName;
	List<Holding> holdings = new ArrayList<Holding>();

	public Fund() {
		// TODO Auto-generated constructor stub
	}

	
	public Fund(String fundName, List<Holding> holdings) {
		super();
		this.fundName = fundName;
		this.holdings = holdings;
	}


	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public List<Holding> getHoldings() {
		return holdings;
	}

	public void setHoldings(List<Holding> holdings) {
		this.holdings = holdings;
	}

}
