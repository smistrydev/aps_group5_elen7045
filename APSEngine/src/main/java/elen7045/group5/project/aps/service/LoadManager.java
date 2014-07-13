/**
 * 
 */
package elen7045.group5.project.aps.service;

import elen7045.group5.project.aps.jpa.model.BillingCompany;

/**
 * Load manager is responsible for calculating the allowed traffic load on
 * a Billing Company's site. This is done through input received from various
 * sources such as configuration, guidelines received from the company being scraped
 * as well as statistics gathered from previous scrapes
 */
public class LoadManager
{
	/**
	 * Method will determine how many users are allowed to concurrently access the billing
	 * company. 
	 * @param billingComp - Company we intend to scrap
	 * @return Returns the total number of concurrent users calculated that can access the site
	 * simultaneously
	 */
	public int getMaximumConcurrentUsers(BillingCompany billingComp)
	{
		//TODO: calculate this info based on the peak period contained in the
		//passed entity as well as other input data
		return (int)(Math.random() * 10);
	}
}
