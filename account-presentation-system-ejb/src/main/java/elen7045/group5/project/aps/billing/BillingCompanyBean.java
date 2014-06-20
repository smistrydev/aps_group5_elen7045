package elen7045.group5.project.aps.billing;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Represents a Billing Company in the application
 */
@Entity
@Table(name="BILLING_COMPANY")
public class BillingCompanyBean  implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int companyId;
	private String companyName,
					companySiteURL;
	
	/**
	 * Unique identifier for the company
	 * @return Returns the companyId
	 */
	@Id
	@Column(name="COMPANY_ID")
	@SequenceGenerator(name="APS_COMPANY_SEQ", sequenceName="APS_COMPANY_SEQ", allocationSize=1)
	@GeneratedValue(generator="APS_COMPANY_SEQ", strategy=GenerationType.SEQUENCE)
	public int getCompanyId()
	{
		return companyId;
	}
	
	/**
	 * Name of the company
	 * @return Returns the companyName
	 */
	@Column(name="COMPANY_NAME")
	public String getCompanyName()
	{
		return companyName;
	}
	
	/**
	 * The website URL where we need to go to in order to obtain the data
	 * @return Returns the companySiteURL
	 */
	@Column(name="WEBSITE_URL")
	public String getCompanySiteURL()
	{
		return companySiteURL;
	}
	
	/**
	 * Unique identifier for the company id
	 * @param companyId - The companyId to set
	 */
	public void setCompanyId(int companyId)
	{
		this.companyId = companyId;
	}
	
	/**
	 * Name of the company
	 * @param companyName - The companyName to set
	 */
	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	/**
	 * The website URL where we need to go to in order to obtain the data
	 * @param companySiteURL - The companySiteURL to set
	 */
	public void setCompanySiteURL(String companySiteURL)
	{
		this.companySiteURL = companySiteURL;
	}
}
