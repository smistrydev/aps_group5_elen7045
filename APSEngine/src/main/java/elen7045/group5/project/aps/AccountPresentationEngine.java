package elen7045.group5.project.aps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.aps.jpa.model.Customer;
import elen7045.group5.project.aps.jpa.service.CustomerService;
import elen7045.group5.project.wsa.WebsiteScraperGateway;

/**
 * This is the main entry point into the Account Presentation Engine. It is
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
	private Logger					logger;
	private WebsiteScraperGateway	gateway;
	private BillingCompany			billingCompany;

	@Autowired
	private CustomerService			service;

	/**
	 * Method kicks off the whole process of retrieving, validating and
	 * persisting scraped data
	 */
	void startApplication() throws IOException
	{

		List<Customer> customers = service.findAll();

		logger.info("Customer size: " + customers.size());

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
	void init() throws IOException
	{
		logger = LoggerFactory.getLogger("APS");
		gateway = new WebsiteScraperGateway();
	}
}