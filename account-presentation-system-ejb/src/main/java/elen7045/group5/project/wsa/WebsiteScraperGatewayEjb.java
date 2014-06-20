package elen7045.group5.project.wsa;

import javax.ejb.Stateless;

import elen7045.group5.project.aps.billing.BillingAccountBean;

/**
 * This is the implementation of the Website Scraper interface
 */
@Stateless(name="WebsiteScraperGateway")
public class WebsiteScraperGatewayEjb implements WebsiteScraperGateway
{
	/**
	 * @see elen7045.group5.project.wsa.WebsiteScraperGateway#performScrape(elen7045.group5.project.aps.billing.BillingAccountBean)
	 */
	public String performScrape(BillingAccountBean billingAcc)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
