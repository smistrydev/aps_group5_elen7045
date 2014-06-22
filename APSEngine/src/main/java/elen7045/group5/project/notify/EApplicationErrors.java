package elen7045.group5.project.notify;

/**
 * Enum will contain all the errors for both APS and WSA
 */
public enum EApplicationErrors
{
	INVALID_CREDENTIALS(2001),
	NOT_SIGNED_UP_FOR_BILLING(2002),
	CUSTOMER_NOT_SIGNED_UP_FOR_E_BILLING(2003),
	ACTION_REQUIRED_BY_BILLING_WEBSITE(2004),
	BILLING_SITE_DOWN(2005),
	ERROR_PAGE_ENCOUNTERED(2006),
	BROKEN_SCRIPT(2007),
	ENCOUNTERED_UNHANDLED_DATA_CONDITION(2008);
	
	private int errorCode;
	
	/**
	 * Creates the ENUM with a specific error code
	 * @param errorCode - Unique error code
	 */
	private EApplicationErrors(int errCode)
	{
		this.errorCode = errCode;
	}
	
	/**
	 * Returns the code representing the error
	 * @return Returns the code representing the error
	 */
	public int getErrorCode()
	{
		return errorCode;
	}
}
