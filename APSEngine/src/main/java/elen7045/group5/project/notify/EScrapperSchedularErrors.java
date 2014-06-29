package elen7045.group5.project.notify;

public enum EScrapperSchedularErrors
{
	SCHEDULER_SCRAPPER_FAILED(3001),
	SCHEDULER_REACHED_MAXIMUM_RETRIES(3002);

	private int	errorCode;

	/**
	 * Creates the ENUM with a specific error code
	 * 
	 * @param errorCode
	 *            - Unique error code
	 */
	private EScrapperSchedularErrors(int errCode)
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
