package elen7045.group5.project.aps;

import java.util.Timer;

import elen7045.group5.project.aps.billing.BillingCompanyBean;
import elen7045.group5.project.wsa.WebsiteScraperGateway;

/**
 * Engine is implemented as a Timer as it will execute at regular intervals and
 * check if scheduling is required to be performed.
 * 
 * Perhaps we can use this as a thread per billing company? So, have multiple
 * instances running so we don't lag or do sequential polling
 */
public class AccountPresentationEngine extends Timer
{
	// need to inject or look it up
	private WebsiteScraperGateway	gateway;
	private BillingCompanyBean		billingCompany;

	/**
	 * Constructor creates the engine for a specific company
	 * 
	 * @param bcb
	 *            - Billing company info
	 */
	public AccountPresentationEngine(BillingCompanyBean bcb)
	{
		this.billingCompany = bcb;
	}

	/**
	 * Method kicks off the whole process of retrieving, validating and
	 * persisting scraped data
	 */
	public void process()
	{
		// get a list of all customers for the billing comany

		// go through each one and perform a scrape - perhaps this should also
		// be threaded?
		String result = gateway.performScrape(null);

		// parse the returned result into objects via JaxB

		// validate the info

		// persist the data, persistence object should do the audit as well
	}

}
