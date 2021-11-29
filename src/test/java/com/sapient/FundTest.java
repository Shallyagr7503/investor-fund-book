package com.sapient;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.service.InvestorService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FundTest {

	@Autowired
	private InvestorService investorService;

	@Before
	public void init() throws Exception {
		investorService.addFunds("F1", "H1", 10.0);
		investorService.addFunds("F1", "H2", 20.0);
		investorService.addFunds("F1", "H4", 10.0);

		investorService.addFunds("F2", "H1", 10.0);
		investorService.addFunds("F2", "H3", 15.0);

		investorService.addFunds("F3", "H1", 10.0);
		investorService.addFunds("F3", "H4", 10.0);

		/*
		 * investorService.createInvestorData("I1", "F1");
		 * investorService.createInvestorData("I1", "F2");
		 * investorService.createInvestorData("I1", "F3");
		 */

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testMarketValueForFund() {
		double marketVal = investorService.getMarketValueForFund("F1");
		assertTrue(marketVal == 4000.0);

		double marketVal2 = investorService.getMarketValForFundExcludingHolding("F1", "H1");
		Assert.assertEquals(3000.0, marketVal2);
	}
	/*
	 * @Test public void testMarketValueForInvestor() { double marketVal =
	 * investorService.getMarketValueForInvestor("I1"); assertEquals(2000.0,
	 * marketVal); }
	 */
}
