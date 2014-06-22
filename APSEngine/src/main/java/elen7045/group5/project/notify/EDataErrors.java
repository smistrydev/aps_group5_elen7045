package elen7045.group5.project.notify;

public enum EDataErrors
{
	INCORRECT_TOTAL_DUE_CALCULATION(1001),
	INCORRECT_VAT_CALCUALTION(1002),
	INCORRECT_DATA_SCRAPPED(1003),
	INCORRECT_STATEMENT_DATE(1004),
	DATA_FAILS_INTEGRITY_CHECKING(1005),
	INCORRECT_ACCOUNT_NUMBER(1006);

	private int	errorCode;

	/**
	 * Creates the ENUM with a specific error code
	 * 
	 * @param errorCode
	 *            - Unique error code
	 */
	private EDataErrors(int errCode)
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
