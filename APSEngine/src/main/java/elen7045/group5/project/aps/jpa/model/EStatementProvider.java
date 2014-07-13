/**
 * 
 */
package elen7045.group5.project.aps.jpa.model;

/**
 * Provides for the various types of statements that can be processed
 */
public enum EStatementProvider
{
	MUNICIPAL(1),
	TELCO(2),
	CREDIT_CARD(3);
	
	private int statementTypeId;
	
	
	EStatementProvider(int typeId)
	{
		this.statementTypeId = typeId;
	}
	
	/**
	 * Returns the unique identifier for the statement type i.e. value that appears
	 * on the database for this type.
	 * @return
	 */
	public int getStatementTypeId()
	{
		return statementTypeId;
	}

}
