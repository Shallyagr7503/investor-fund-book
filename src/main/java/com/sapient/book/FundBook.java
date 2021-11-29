package com.sapient.book;

import java.util.HashMap;
import java.util.Map;

import com.sapient.domain.Fund;

// TODO: Auto-generated Javadoc
/**
 * The Class FundBook.
 * 
 * using singlton class because class
 *  will contain all the fund records and funds would be same for all 
 * 
 */
public class FundBook {

	/** The fund book. */
	public static FundBook fundBook = null;

	/** The funds. */
	private Map<String, Fund> funds = new HashMap<String, Fund>();

	/**
	 * Instantiates a new fund book.
	 */
	private FundBook() {

	}

	/**
	 * Gets the fund book.
	 *
	 * @return the fund book
	 */
	public static FundBook getFundBook() {
		if (fundBook == null) {
			fundBook = new FundBook();
		}

		return fundBook;
	}

	/**
	 * Gets the funds.
	 *
	 * @return the funds
	 */
	public Map<String, Fund> getFunds() {
		return funds;
	}

	/**
	 * Sets the funds.
	 *
	 * @param funds the funds
	 */
	public void setFunds(Map<String, Fund> funds) {
		this.funds = funds;
	}

	/**
	 * Sets the fund book.
	 *
	 * @param fundBook the new fund book
	 */
	public static void setFundBook(FundBook fundBook) {
		FundBook.fundBook = fundBook;
	}

}
