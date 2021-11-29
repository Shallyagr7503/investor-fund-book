package com.sapient.book;

import java.util.HashSet;
import java.util.Set;

import com.sapient.domain.Investor;

// TODO: Auto-generated Javadoc
/**
 * The Class InvestorBook.
 * this class contain investor records , if multiple user wants to read 
 * investor data from application same data should be readable for all
 */
public class InvestorBook {

	/** The investor book. */
	private static InvestorBook investroBook = null;
	
	/** The investors. */
	private Set<Investor> investors = new HashSet<>();
	
	/**
	 * Instantiates a new investor book.
	 */
	private InvestorBook() {

	}
	
	/**
	 * Gets the investor book.
	 *
	 * @return the investor book
	 */
	public static InvestorBook getInvestorBook() {
		if(investroBook ==  null) {
			investroBook = new InvestorBook();
		}
		return investroBook;
	}

	/**
	 * Gets the investors.
	 *
	 * @return the investors
	 */
	public Set<Investor> getInvestors() {
		return investors;
	}

	/**
	 * Sets the investors.
	 *
	 * @param investors the new investors
	 */
	public void setInvestors(Set<Investor> investors) {
		this.investors = investors;
	}
	
	
}
