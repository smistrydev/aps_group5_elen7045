package elen7045.group5.project.aps;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import elen7045.group5.project.aps.billing.BillingCompanyBean;
import elen7045.group5.project.wsa.WebsiteScraperGateway;

/**
 * This is the main entry point into the Account Presentation Engine. It is
 * responsible for managing all scraping operations for the various billing
 * companies. Each scraping operation is created as a separate thread to allow
 * concurrent scraping to occur and not to have errors at one company affect
 * another scrape.
 */
public class AccountPresentationEngine
{
	private String logDir;
	private Logger logger;
	
	private WebsiteScraperGateway	gateway;
	private BillingCompanyBean		billingCompany;
	
	/**
	 * Main entry point
	 * @param args - Command line arguments
	 */
	public static void main(String[] args)
	{
		try
		{
			AccountPresentationEngine ape = new AccountPresentationEngine();
			ape.init();
			ape.startApplication();
		}
		catch(Exception e)
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
		
		logger.info("Get a list of all customers for the billing comany");

		logger.info("go through each one and perform a scrape - perhaps this should also be threaded");
		//String result = gateway.performScrape(null);

		logger.info("parse the returned result into objects via JaxB");

		// validate the info

		// persist the data, persistence object should do the audit as well
	}
	
	
	/**
	 * Initialises some required objects
	 */
	private void init() throws IOException
	{
		//createLogDirectory();
		logger = LoggerFactory.getLogger("APS");
	}
	
	/**
	 * This creates a log directory for the agent, if it does not already exist
	 * @param conf - Agent configuration info
	 * @throws IOException - If an error occurs while creating the log directory
	 */
	private void createLogDirectory() throws IOException
	{
		this.logDir = new StringBuilder((new File(".").getCanonicalPath()))
								.append(System.getProperty("file.separator"))
								.append("log")
								.append(System.getProperty("file.separator"))
								.toString();
		
		File dir = new File(logDir);
		if(dir.exists() == false)
		{
			dir.mkdirs();
		}
	}
}