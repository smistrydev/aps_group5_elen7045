package elen7045.group5.project.wsa;

import javax.ejb.Remote;

import elen7045.group5.project.aps.billing.BillingAccountBean;

/**
 * This is used as an abstraction to a third party website scraper. This allows us to
 * treat the external application as a pluggable module in the application that can be
 * swapped out with another if need be without affecting the rest of the code. The
 * interface defines the operations that can be performed against it.  
 */
@Remote
public interface WebsiteScraperGateway
{
	/**
	 * This method will perform a scrape by logging onto the company contained in the
	 * passed bean using the customer's details and retrieve the statement information
	 * @param billingAcc - Bean containing all the required data to perform a scrape
	 * @return Returns the XML string containing the scraped data or any errors
	 * encountered
	 */
	public String performScrape(BillingAccountBean billingAcc);
}
