package com.sapient.service;

/**
 * The Interface InvestorService.
 */
public interface InvestorService {

	/**
	 * Creates the investor data.
	 *
	 * @param investorName the investor name
	 * @param fundName the fund name
	 * @throws Exception the exception
	 */
	public void createInvestorData(String investorName,
			String fundName) throws Exception;
	
	
	/**
	 * Gets the market value for fund.
	 *
	 * @param fundName the fund name
	 * @return the market value fund
	 */
	public Double getMarketValueForFund(String fundName);
	
	/**
	 * Gets the market value for investor.
	 *
	 * @param investorName the investor name
	 * @return the market value for investor
	 */
	public Double getMarketValueForInvestor(String investorName);
	
	
	/**
	 * Adds the funds.
	 *
	 * @param fundName the fund name
	 * @param holdingName the holding name
	 * @param price the price
	 */
	public void addFunds(String fundName,String holdingName,Double price);
	
	/**
	 * Gets the market val for fund excluding holding.
	 *
	 * @param fundName the fund name
	 * @param holdingName the holding name
	 * @return the market val for fund excluding holding
	 */
	public Double getMarketValForFundExcludingHolding(String fundName,String holdingName);
}
