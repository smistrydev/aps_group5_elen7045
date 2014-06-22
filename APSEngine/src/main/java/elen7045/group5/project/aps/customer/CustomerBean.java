package elen7045.group5.project.aps.customer;

import java.io.Serializable;

/**
 * Contains all data related to a customer of the application
 */
public class CustomerBean implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	private int					customerId;
	private String				customerEmail,
								customerPassword,
								customerName,
								customerSurname;

	/**
	 * @return Returns the customerId
	 */
	public int getCustomerId()
	{
		return customerId;
	}

	/**
	 * @return Returns the customerEmail
	 */
	public String getCustomerEmail()
	{
		return customerEmail;
	}

	/**
	 * @return Returns the customerPassword
	 */
	public String getCustomerPassword()
	{
		return customerPassword;
	}

	/**
	 * @return Returns the customerName
	 */
	public String getCustomerName()
	{
		return customerName;
	}

	/**
	 * @return Returns the customerSurname
	 */
	public String getCustomerSurname()
	{
		return customerSurname;
	}

	/**
	 * @param customerId
	 *            - The customerId to set
	 */
	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	/**
	 * @param customerEmail
	 *            - The customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail)
	{
		this.customerEmail = customerEmail;
	}

	/**
	 * @param customerPassword
	 *            - The customerPassword to set
	 */
	public void setCustomerPassword(String customerPassword)
	{
		this.customerPassword = customerPassword;
	}

	/**
	 * @param customerName
	 *            - The customerName to set
	 */
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	/**
	 * @param customerSurname
	 *            - The customerSurname to set
	 */
	public void setCustomerSurname(String customerSurname)
	{
		this.customerSurname = customerSurname;
	}
}
