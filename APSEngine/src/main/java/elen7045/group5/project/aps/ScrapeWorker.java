/**
 * 
 */
package elen7045.group5.project.aps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.wsa.WebsiteScraperGateway;

/**
 * Worker is responsible for checking if a schedule time has been reached and if so
 * then it will kick off a scrape session for all accounts linked to the billing company
 * @author Robert Botes
 */
public class ScrapeWorker implements Runnable
{
	private BillingCompany billingCompany;
	private WebsiteScraperGateway	gateway;
	private Logger logger = LoggerFactory.getLogger("APS");
	
	/**
	 * Worker created for a specific company
	 * @param bc
	 */
	public ScrapeWorker(BillingCompany bc)
	{
		this.billingCompany = bc;
	}
	
	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		gateway = new WebsiteScraperGateway();
		while(true)
		{
			logger.info("ScrapeWorker is running....");
						
			logger.info("go through each one and perform a scrape - perhaps this should also be threaded");
			// String result = gateway.performScrape(null);

			logger.info("parse the returned result into objects via JaxB");

			// validate the info

			// persist the data, persistence object should do the audit as well

			
			try
			{
				Thread.sleep(10000);
			}
			catch(InterruptedException ie)
			{
			}
		}
	}
}
