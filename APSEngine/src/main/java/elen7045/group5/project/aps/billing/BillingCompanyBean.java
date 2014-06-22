package elen7045.group5.project.aps.billing;

import java.io.Serializable;

/**
 * Class represents a billing company that the scraper logs into to obtain
 * customer data
 */
public class BillingCompanyBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int billingCompanyId,
				daysPerCycle,
				retryIntervalMinutes,
				retryCount,
				leadTimeDays;
	private String name,
					url;
	
	/**
	 * Unique identifier for the company
	 * @return Returns the billingCompanyId
	 */
	public int getBillingCompanyId()
	{
		return billingCompanyId;
	}
	
	/**
	 * This is the number of days between when a statement is generated/made available
	 * by the company
	 * @return Returns the daysPerCycle
	 */
	public int getDaysPerCycle()
	{
		return daysPerCycle;
	}
	
	/**
	 * This is the number of minutes that the scraper should wait before the next retry
	 * @return Returns the retryInterval
	 */
	public int getRetryIntervalMinutes()
	{
		return retryIntervalMinutes;
	}
	
	/**
	 * The number of days the scraper should try and check for an available statement
	 * @return Returns the leadTime
	 */
	public int getLeadTimeDays()
	{
		return leadTimeDays;
	}
	
	/**
	 * The name of the company
	 * @return Returns the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * The website address of the company that the scraper will connect to when
	 * doing a scrape
	 * @return Returns the url
	 */
	public String getUrl()
	{
		return url;
	}
	
	/**
	 * Unique identifier for the company
	 * @param billingCompanyId - The billingCompanyId to set
	 */
	public void setBillingCompanyId(int billingCompanyId)
	{
		this.billingCompanyId = billingCompanyId;
	}
	
	/**
	 * This is the number of days between when a statement is generated/made available
	 * by the company
	 * @param daysPerCycle - The daysPerCycle to set
	 */
	public void setDaysPerCycle(int daysPerCycle)
	{
		this.daysPerCycle = daysPerCycle;
	}
	
	/**
	 * This is the number of minutes that the scraper should wait before the next retry
	 * @param retryInterval - The retryInterval to set
	 */
	public void setRetryIntervalMinutes(int retryInterval)
	{
		this.retryIntervalMinutes = retryInterval;
	}
	
	/**
	 * The number of days the scraper should try and check for an available statement
	 * @param leadTime - The leadTime to set
	 */
	public void setLeadTimeDays(int leadTime)
	{
		this.leadTimeDays = leadTime;
	}
	
	/**
	 * The name of the company
	 * @param name - The name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * The website address of the company that the scraper will connect to when
	 * doing a scrape
	 * @param url - The url to set
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * @return Returns the retryCount
	 */
	public int getRetryCount()
	{
		return retryCount;
	}

	/**
	 * @param retryCount - The retryCount to set
	 */
	public void setRetryCount(int retryCount)
	{
		this.retryCount = retryCount;
	}
}
