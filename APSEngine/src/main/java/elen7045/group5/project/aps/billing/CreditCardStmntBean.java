package elen7045.group5.project.aps.billing;

/**
 * Statement information specific to the Credit Card providers
 */
public class CreditCardStmntBean extends StatementBean
{
	private static final long	serialVersionUID	= 1L;
	private String				cardType;					// maybe enum?
	private float				interestRate,
								creditLimit,
								creditAvailable,
								minimumAmtDue;

	/**
	 * @return Returns the cardType
	 */
	public String getCardType()
	{
		return cardType;
	}

	/**
	 * @param cardType
	 *            - The cardType to set
	 */
	public void setCardType(String cardType)
	{
		this.cardType = cardType;
	}

	/**
	 * @return Returns the interestRate
	 */
	public float getInterestRate()
	{
		return interestRate;
	}

	/**
	 * @return Returns the creditLimit
	 */
	public float getCreditLimit()
	{
		return creditLimit;
	}

	/**
	 * @return Returns the creditAvailable
	 */
	public float getCreditAvailable()
	{
		return creditAvailable;
	}

	/**
	 * @return Returns the minimumAmtDue
	 */
	public float getMinimumAmtDue()
	{
		return minimumAmtDue;
	}

	/**
	 * @param interestRate
	 *            - The interestRate to set
	 */
	public void setInterestRate(float interestRate)
	{
		this.interestRate = interestRate;
	}

	/**
	 * @param creditLimit
	 *            - The creditLimit to set
	 */
	public void setCreditLimit(float creditLimit)
	{
		this.creditLimit = creditLimit;
	}

	/**
	 * @param creditAvailable
	 *            - The creditAvailable to set
	 */
	public void setCreditAvailable(float creditAvailable)
	{
		this.creditAvailable = creditAvailable;
	}

	/**
	 * @param minimumAmtDue
	 *            - The minimumAmtDue to set
	 */
	public void setMinimumAmtDue(float minimumAmtDue)
	{
		this.minimumAmtDue = minimumAmtDue;
	}

}
