package elen7045.group5.project.aps.billing;

/**
 * Each statement is specific to a particular industry or type of company
 */
public enum EStatementProvider
{
	MUNICIPAL(1),
	TELCO(2),
	CREDIT_CARD(3);
	
	private int providerId;
	
	EStatementProvider(int id)
	{
		this.providerId = id;
	}
	
	/**
	 * Returns the unique id associated with this enum
	 * @return
	 */
	public int getStatementProviderId()
	{
		return providerId;
	}	
}
