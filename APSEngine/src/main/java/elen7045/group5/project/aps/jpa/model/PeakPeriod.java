package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the peak_period database table.
 * 
 */
@Entity
@Table(name = "peak_period")
@NamedQuery(name = "PeakPeriod.findAll", query = "SELECT p FROM PeakPeriod p")
public class PeakPeriod implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "peak_id")
	private int					peakId;

	private String				day;

	private String				hour;

	private String				minute;

	private String				month;

	@Column(name = "week_number")
	private String				weekNumber;

	// bi-directional many-to-one association to BillingCompany
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "billing_company_id")
	private BillingCompany		billingCompany;

	public PeakPeriod()
	{
	}

	public int getPeakId()
	{
		return this.peakId;
	}

	public void setPeakId(int maintenanceId)
	{
		this.peakId = maintenanceId;
	}

	public String getDay()
	{
		return this.day;
	}

	public void setDay(String day)
	{
		this.day = day;
	}

	public String getHour()
	{
		return this.hour;
	}

	public void setHour(String hour)
	{
		this.hour = hour;
	}

	public String getMinute()
	{
		return this.minute;
	}

	public void setMinute(String minute)
	{
		this.minute = minute;
	}

	public String getMonth()
	{
		return this.month;
	}

	public void setMonth(String month)
	{
		this.month = month;
	}

	public String getWeekNumber()
	{
		return this.weekNumber;
	}

	public void setWeekNumber(String weekNumber)
	{
		this.weekNumber = weekNumber;
	}

	public BillingCompany getBillingCompany()
	{
		return this.billingCompany;
	}

	public void setBillingCompany(BillingCompany billingCompany)
	{
		this.billingCompany = billingCompany;
	}

}