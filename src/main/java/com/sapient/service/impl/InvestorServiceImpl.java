package com.sapient.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.DoubleStream;

import org.springframework.stereotype.Service;

import com.sapient.book.FundBook;
import com.sapient.book.InvestorBook;
import com.sapient.domain.Fund;
import com.sapient.domain.Holding;
import com.sapient.domain.Investor;
import com.sapient.error.FundNotFoundException;
import com.sapient.error.InvestorNotFoundException;
import com.sapient.service.InvestorService;

/**
 * The Class InvestorServiceImpl.
 */
@Service
public class InvestorServiceImpl implements InvestorService {

	/**
	 * The investor book.
	 *
	 * @param investorName the investor name
	 * @param fundName     the fund name
	 * @throws Exception the exception
	 */

	@Override
	public void createInvestorData(String investorName, String fundName) throws Exception {

		FundBook fundBook = FundBook.getFundBook();
		fundBook.getFunds().entrySet().stream().
		filter(x -> x.getKey().equalsIgnoreCase(fundName)).findFirst()
		.ifPresentOrElse((val) -> 
		{
			Set<Investor> investors = InvestorBook.getInvestorBook()
					.getInvestors();
			
			Fund fund = val.getValue();
			getInvestorFromBook(investors, investorName)
			.ifPresentOrElse(i -> i.getFunds().add(fund),
					() -> investors.add(new Investor(investorName, Arrays.asList(fund))));

		}, FundNotFoundException::new);

	}

	/**
	 * Gets the investor from book.
	 *
	 * @param investors    the investors
	 * @param investorName the investor name
	 * @return the investor from book
	 */
	private Optional<Investor> getInvestorFromBook(Set<Investor> investors, String investorName) {
		return investors.stream().filter(x -> x.getInvestorName().equalsIgnoreCase(investorName)).findAny();
	}

	/**
	 * Adds the funds.
	 *
	 * @param fundName    the fund name
	 * @param holdingName the holding name
	 * @param price       the price
	 */
	@Override
	public void addFunds(String fundName, String holdingName, Double price) {
		Holding holding = new Holding(holdingName, price);
		FundBook fundBook = FundBook.getFundBook();
		Map<String, Fund> funds = fundBook.getFunds();
		
		if(funds.containsKey(fundName)) {
			Fund fund = funds.get(fundName);
			fund.getHoldings().add(holding);
		}else {
			List<Holding> holdingList = new ArrayList<Holding>();
			holdingList.add(holding);
			Fund fund = new Fund(fundName, holdingList);
			funds.put(fundName, fund);
		}
		
	}

	/**
	 * Gets the market value for fund.
	 * 
	 * @param fundName the fund name
	 * @return the market value for fund
	 */
	@Override
	public Double getMarketValueForFund(String fundName) {
		Map.Entry<String, Fund> fundsMap = FundBook.getFundBook().getFunds().entrySet().stream()
				.filter(x -> x.getKey().equalsIgnoreCase(fundName)).findFirst().orElseThrow(FundNotFoundException::new);
		Fund fund = fundsMap.getValue();
		return getMarketValue(fund);

	}

	/**
	 * Gets the market value.
	 *
	 * @param fund the fund
	 * @return the market value
	 */
	private double getMarketValue(Fund fund) {
		return fund.getHoldings().stream().mapToDouble(x -> x.getPrice() * 100).sum();
	}

	/**
	 * Gets the market value exclude holding.
	 *
	 * @param fund    the fund
	 * @param holding the holding
	 * @return the market value exclude holding
	 */
	private double getMarketValueExcludeHolding(Fund fund, String holding) {
		return fund.getHoldings().stream().filter(x -> !x.getHoldingName().equals(holding))
				.mapToDouble(x -> x.getPrice() * 100).sum();
	}

	/**
	 * Gets the market value for investor.
	 *
	 * @param investorName the investor name
	 * @return the market value for investor
	 */
	@Override
	public Double getMarketValueForInvestor(String investorName) {

		Optional<Investor> optInvestor = Optional
				.ofNullable(getInvestorFromBook(InvestorBook.getInvestorBook().getInvestors(), investorName))
				.orElseThrow(InvestorNotFoundException::new);
		return optInvestor.get().getFunds().stream().flatMapToDouble(f -> DoubleStream.of(getMarketValue(f))).sum();

	}

	/**
	 * Gets the market val for fund excluding holding.
	 *
	 * @param fundName    the fund name
	 * @param holdingName the holding name
	 * @return the market val for fund excluding holding
	 */
	@Override
	public Double getMarketValForFundExcludingHolding(String fundName, String holdingName) {

		Map.Entry<String, Fund> mapVal = FundBook.getFundBook().getFunds().entrySet().stream()
				.filter(x -> x.getKey().equalsIgnoreCase(fundName)).findFirst().orElseThrow(FundNotFoundException::new);
		return getMarketValueExcludeHolding(mapVal.getValue(), holdingName);

	}
}
