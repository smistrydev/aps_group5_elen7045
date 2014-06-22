package elen7045.group5.project.aps.billing;

import java.io.Serializable;
import java.util.Date;

/**
 * Contains all the data fields common to all the various statement types.
 */
public class StatementBean implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	private String				accountNumber,
								accountHolderName;
	private Date				statementDate,
								dueDate;
	private int					statementNumber,
								statementMonth;
	private Float				totalDue,
								openingBalance,
								closingBalance,
								paymentRecieved,
								newCharges,
								deductions,
								discount,
								vat_amount;

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName()
	{
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName)
	{
		this.accountHolderName = accountHolderName;
	}

	public Date getStatementDate()
	{
		return statementDate;
	}

	public void setStatementDate(Date statementDate)
	{
		this.statementDate = statementDate;
	}

	public Date getDueDate()
	{
		return dueDate;
	}

	public void setDueDate(Date dueDate)
	{
		this.dueDate = dueDate;
	}

	public int getStatementNumber()
	{
		return statementNumber;
	}

	public void setStatementNumber(int statementNumber)
	{
		this.statementNumber = statementNumber;
	}

	public int getStatementMonth()
	{
		return statementMonth;
	}

	public void setStatementMonth(int statementMonth)
	{
		this.statementMonth = statementMonth;
	}

	public Float getTotalDue()
	{
		return totalDue;
	}

	public void setTotalDue(Float totalDue)
	{
		this.totalDue = totalDue;
	}

	public Float getOpeningBalance()
	{
		return openingBalance;
	}

	public void setOpeningBalance(Float openingBalance)
	{
		this.openingBalance = openingBalance;
	}

	public Float getClosingBalance()
	{
		return closingBalance;
	}

	public void setClosingBalance(Float closingBalance)
	{
		this.closingBalance = closingBalance;
	}

	public Float getPaymentRecieved()
	{
		return paymentRecieved;
	}

	public void setPaymentRecieved(Float paymentRecieved)
	{
		this.paymentRecieved = paymentRecieved;
	}

	public Float getNewCharges()
	{
		return newCharges;
	}

	public void setNewCharges(Float newCharges)
	{
		this.newCharges = newCharges;
	}

	public Float getDeductions()
	{
		return deductions;
	}

	public void setDeductions(Float deductions)
	{
		this.deductions = deductions;
	}

	public Float getDiscount()
	{
		return discount;
	}

	public void setDiscount(Float discount)
	{
		this.discount = discount;
	}

	public Float getVat_amount()
	{
		return vat_amount;
	}

	public void setVat_amount(Float vat_amount)
	{
		this.vat_amount = vat_amount;
	}

}