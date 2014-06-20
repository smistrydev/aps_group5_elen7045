package elen7045.group5.project;

/**
 * Enum will contain all the errors for both APS and WSA
 */
public enum ApplicationErrors
{
	INVALID_CREDENTIALS(1001),
	NOT_SIGNED_UP_FOR_BILLING(1002);
	
	private int errorCode;
	
	/**
	 * Creates the ENUM with a specific error code
	 * @param errorCode - Unique error code
	 */
	private ApplicationErrors(int errCode)
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
