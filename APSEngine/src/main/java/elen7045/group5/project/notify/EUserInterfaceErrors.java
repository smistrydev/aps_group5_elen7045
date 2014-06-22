package elen7045.group5.project.notify;

// User interface error codes
public enum EUserInterfaceErrors
{
	INVALID_USER_NAME(001),
	INVALID_USER_PASSWORD(002);

	private int	errorCode;

	/**
	 * Creates the ENUM with a specific error code
	 * 
	 * @param errorCode
	 *            - Unique error code
	 */
	private EUserInterfaceErrors(int errCode)
	{
		this.errorCode = errCode;
	}

	/**
	 * Returns the code representing the error
	 * 
	 * @return Returns the code representing the error
	 */
	public int getErrorCode()
	{
		return errorCode;
	}

}
