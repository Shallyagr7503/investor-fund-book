package com.sapient;

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
public class InvestorTest {

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

		investorService.createInvestorData("I1", "F1");
		investorService.createInvestorData("I1", "F2");
		investorService.createInvestorData("I1", "F3");

	}

	@Test
	public void testMarketValueForInvestor() {
		double marketVal = investorService.getMarketValueForInvestor("I1");
		Assert.assertEquals(8500.0, marketVal);
	}

}
