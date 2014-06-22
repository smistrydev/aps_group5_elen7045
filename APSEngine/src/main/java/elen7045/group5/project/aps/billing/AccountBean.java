package elen7045.group5.project.aps.billing;

import java.io.Serializable;

/**
 * This represents a Customer's account at a billing company and contains
 * the login details and account numbers associated with that account.
 */
public class AccountBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int accountId,
				customerId,
				billingCompanyId;
	private String accountNumber,
					customerLoginName,
					customerLoginPassword;
	/**
	 * @return Returns the accountId
	 */
	public int getAccountId()
	{
		return accountId;
	}
	/**
	 * @return Returns the customerId
	 */
	public int getCustomerId()
	{
		return customerId;
	}
	/**
	 * @return Returns the billingCompanyId
	 */
	public int getBillingCompanyId()
	{
		return billingCompanyId;
	}
	/**
	 * @return Returns the accountNumber
	 */
	public String getAccountNumber()
	{
		return accountNumber;
	}
	/**
	 * @return Returns the customerLoginName
	 */
	public String getCustomerLoginName()
	{
		return customerLoginName;
	}
	/**
	 * @return Returns the customerLoginPassword
	 */
	public String getCustomerLoginPassword()
	{
		return customerLoginPassword;
	}
	/**
	 * @param accountId - The accountId to set
	 */
	public void setAccountId(int accountId)
	{
		this.accountId = accountId;
	}
	/**
	 * @param customerId - The customerId to set
	 */
	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}
	/**
	 * @param billingCompanyId - The billingCompanyId to set
	 */
	public void setBillingCompanyId(int billingCompanyId)
	{
		this.billingCompanyId = billingCompanyId;
	}
	/**
	 * @param accountNumber - The accountNumber to set
	 */
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	/**
	 * @param customerLoginName - The customerLoginName to set
	 */
	public void setCustomerLoginName(String customerLoginName)
	{
		this.customerLoginName = customerLoginName;
	}
	/**
	 * @param customerLoginPassword - The customerLoginPassword to set
	 */
	public void setCustomerLoginPassword(String customerLoginPassword)
	{
		this.customerLoginPassword = customerLoginPassword;
	}
}
