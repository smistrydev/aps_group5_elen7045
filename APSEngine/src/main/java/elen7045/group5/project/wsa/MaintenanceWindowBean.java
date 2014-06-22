package elen7045.group5.project.wsa;

import java.io.Serializable;

/**
 * Bean represents the maintenance periods that each billing company may have.
 * This schedule needs to be enforced by the APS engine when it scans for
 * possible scraping
 */
public class MaintenanceWindowBean implements Serializable
{
	private static final long	serialVersionUID	= 12312132L;
	private int					maintenanceId;
	private int					billingCompanyId;
	private String				minutes,
								hours,
								days,
								weeks,
								months;

	/**
	 * @return Returns the maintenanceId
	 */
	public int getMaintenanceId()
	{
		return maintenanceId;
	}

	/**
	 * @return Returns the billingCompanyId
	 */
	public int getBillingCompanyId()
	{
		return billingCompanyId;
	}

	/**
	 * @return Returns the minutes
	 */
	public String getMinutes()
	{
		return minutes;
	}

	/**
	 * @return Returns the hours
	 */
	public String getHours()
	{
		return hours;
	}

	/**
	 * @return Returns the days
	 */
	public String getDays()
	{
		return days;
	}

	/**
	 * @return Returns the weeks
	 */
	public String getWeeks()
	{
		return weeks;
	}

	/**
	 * @return Returns the months
	 */
	public String getMonths()
	{
		return months;
	}

	/**
	 * @param maintenanceId
	 *            - The maintenanceId to set
	 */
	public void setMaintenanceId(int maintenanceId)
	{
		this.maintenanceId = maintenanceId;
	}

	/**
	 * @param billingCompanyId
	 *            - The billingCompanyId to set
	 */
	public void setBillingCompanyId(int billingCompanyId)
	{
		this.billingCompanyId = billingCompanyId;
	}

	/**
	 * @param minutes
	 *            - The minutes to set
	 */
	public void setMinutes(String minutes)
	{
		this.minutes = minutes;
	}

	/**
	 * @param hours
	 *            - The hours to set
	 */
	public void setHours(String hours)
	{
		this.hours = hours;
	}

	/**
	 * @param days
	 *            - The days to set
	 */
	public void setDays(String days)
	{
		this.days = days;
	}

	/**
	 * @param weeks
	 *            - The weeks to set
	 */
	public void setWeeks(String weeks)
	{
		this.weeks = weeks;
	}

	/**
	 * @param months
	 *            - The months to set
	 */
	public void setMonths(String months)
	{
		this.months = months;
	}

}
