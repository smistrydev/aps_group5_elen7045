package elen7045.group5.project.aps;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import elen7045.group5.project.aps.billing.BillingCompanyBean;
import elen7045.group5.project.aps.jpa.config.ApplicationContext;
import elen7045.group5.project.aps.jpa.model.Customer;
import elen7045.group5.project.aps.jpa.service.CustomerService;
import elen7045.group5.project.wsa.WebsiteScraperGateway;

/**
 * This is the main entry point into the Account Presentation Engine. It is
 * responsible for managing all scraping operations for the various billing
 * companies. Each scraping operation is created as a separate thread to allow
 * concurrent scraping to occur and not to have errors at one company affect
 * another scrape.
 * @author Robert Botes
 */
public class AccountPresentationEngine
{
	private Logger					logger;
	private WebsiteScraperGateway	gateway;
	private BillingCompanyBean		billingCompany;
	private AbstractApplicationContext applicationContext;	
	@Autowired
	private CustomerService	service;
	
	/**
	 * Main entry point
	 * 
	 * @param args
	 *            - Command line arguments
	 */
	public static void main(String[] args)
	{
		try
		{
			AccountPresentationEngine ape = new AccountPresentationEngine();
			ape.init();
			ape.startApplication();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}

		System.exit(0);
	}

	/**
	 * Method kicks off the whole process of retrieving, validating and
	 * persisting scraped data
	 */
	void startApplication() throws IOException
	{
		Iterable<Customer> customers = service.findAll();
		logger.info("Customer size: " + customers);
		
		logger.info("Get a list of all customers for the billing comany");

		logger.info("go through each one and perform a scrape - perhaps this should also be threaded");
		// String result = gateway.performScrape(null);

		logger.info("parse the returned result into objects via JaxB");

		// validate the info

		// persist the data, persistence object should do the audit as well
	}

	/**
	 * Initialises some required objects
	 */
	private void init() throws IOException
	{
		logger = LoggerFactory.getLogger("APS");
		applicationContext = new AnnotationConfigApplicationContext(ApplicationContext.class);
		gateway = new WebsiteScraperGateway();
	}
}