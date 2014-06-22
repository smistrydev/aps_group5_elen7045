package elen7045.group5.project.aps.billing;

import java.io.Serializable;

/**
 * Contains all the data fields common to all the various statement types.
 */
public class StatementBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String accountNumber,
					accountHolder,
					statementDate,
					statementNumber;	
	//TODO: complete all fields
	
	
	/**
	 * @return Returns the accountNumber
	 */
	public String getAccountNumber()
	{
		return accountNumber;
	}
	/**
	 * @return Returns the accountHolder
	 */
	public String getAccountHolder()
	{
		return accountHolder;
	}
	/**
	 * @return Returns the statementDate
	 */
	public String getStatementDate()
	{
		return statementDate;
	}
	/**
	 * @return Returns the statementNumber
	 */
	public String getStatementNumber()
	{
		return statementNumber;
	}
	/**
	 * @param accountNumber - The accountNumber to set
	 */
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	/**
	 * @param accountHolder - The accountHolder to set
	 */
	public void setAccountHolder(String accountHolder)
	{
		this.accountHolder = accountHolder;
	}
	/**
	 * @param statementDate - The statementDate to set
	 */
	public void setStatementDate(String statementDate)
	{
		this.statementDate = statementDate;
	}
	/**
	 * @param statementNumber - The statementNumber to set
	 */
	public void setStatementNumber(String statementNumber)
	{
		this.statementNumber = statementNumber;
	}
}
