package elen7045.group5.project.aps;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.aps.jpa.service.BillingCompanyService;

/**
 * This is the main controller for the Account Presentation Engine. It is
 * responsible for managing all scraping operations for the various billing
 * companies. Each scraping operation is created as a separate thread to allow
 * concurrent scraping to occur and not to have errors at one company affect
 * another scrape.
 * 
 * @author Robert Botes
 */
@Component
public class AccountPresentationEngine
{
	private Logger					logger	= LoggerFactory.getLogger("APS");

	@Autowired
	private BillingCompanyService	billingCompanySrvc;

	/**
	 * Method retrieves the billing companies and instantiates a
	 * {@link ScrapeWorker} for each of the billing companies retrieved
	 */
	void startApplication() throws IOException
	{
		Thread thread = null;
		ScrapeWorker worker = null;

		logger.info("Starting up. Retrieving all the billing companies...");
		List<BillingCompany> companies = billingCompanySrvc.findAll();
		for (BillingCompany bc : companies)
		{
			logger.info("Creating worker for company " + bc.getBillingCompanyName());
			worker = new ScrapeWorker(bc);
			thread = new Thread(worker);
			thread.start();
		}
	}
}