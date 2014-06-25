package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the credit_card_provider database table.
 * 
 */
@Entity
@Table(name = "credit_card_provider")
@NamedQuery(name = "CreditCardProvider.findAll", query = "SELECT c FROM CreditCardProvider c")
public class CreditCardProvider implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "credit_card_provider_id")
	private int					creditCardProviderId;

	@Column(name = "card_type")
	private String				cardType;

	@Column(name = "credit_available")
	private BigDecimal			creditAvailable;

	@Column(name = "credit_limit")
	private BigDecimal			creditLimit;

	@Column(name = "interest_rate")
	private BigDecimal			interestRate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "minimum_amount_due")
	private Date				minimumAmountDue;

	// bi-directional many-to-one association to Statement
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "statement_id")
	private Statement			statement;

	public CreditCardProvider()
	{
	}

	public int getCreditCardProviderId()
	{
		return this.creditCardProviderId;
	}

	public void setCreditCardProviderId(int creditCardProviderId)
	{
		this.creditCardProviderId = creditCardProviderId;
	}

	public String getCardType()
	{
		return this.cardType;
	}

	public void setCardType(String cardType)
	{
		this.cardType = cardType;
	}

	public BigDecimal getCreditAvailable()
	{
		return this.creditAvailable;
	}

	public void setCreditAvailable(BigDecimal creditAvailable)
	{
		this.creditAvailable = creditAvailable;
	}

	public BigDecimal getCreditLimit()
	{
		return this.creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit)
	{
		this.creditLimit = creditLimit;
	}

	public BigDecimal getInterestRate()
	{
		return this.interestRate;
	}

	public void setInterestRate(BigDecimal interestRate)
	{
		this.interestRate = interestRate;
	}

	public Date getMinimumAmountDue()
	{
		return this.minimumAmountDue;
	}

	public void setMinimumAmountDue(Date minimumAmountDue)
	{
		this.minimumAmountDue = minimumAmountDue;
	}

	public Statement getStatement()
	{
		return this.statement;
	}

	public void setStatement(Statement statement)
	{
		this.statement = statement;
	}

}