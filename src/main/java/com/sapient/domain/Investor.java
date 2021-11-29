package com.sapient.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Investor {
	
	private String investorName;
	private List<Fund> funds = new ArrayList<Fund>();
	
	public Investor() {

	}

	
	public Investor(String investorName, List<Fund> funds) {
		super();
		this.investorName = investorName;
		this.funds = funds;
	}


	public List<Fund> getFunds() {
		return funds;
	}

	public void setFunds(List<Fund> funds) {
		this.funds = funds;
	}

	public String getInvestorName() {
		return investorName;
	}

	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(investorName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investor other = (Investor) obj;
		return Objects.equals(investorName, other.investorName);
	}
	
	
}
