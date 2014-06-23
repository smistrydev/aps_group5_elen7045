package elen7045.group5.project.notify;

public class ApplicationErrorsBean {
	
	private int errorCode;	
	private ErrorMessagesFromTheDB errorMessageFromDB;
	private String errorMSG;
	private CreateErrorsXML XMLerror;
	
	public ApplicationErrorsBean(EApplicationErrors appErrors)
	{
		errorCode = appErrors.getErrorCode();
		getErrorMessageFromDatabase();
		
	}

	public ApplicationErrorsBean(EDataErrors appErrors)
	{
		errorCode = appErrors.getErrorCode();
		getErrorMessageFromDatabase();
	}

	public ApplicationErrorsBean(EScrapperSchedularErrors appErrors)
	{
		errorCode = appErrors.getErrorCode();
		getErrorMessageFromDatabase();
	}

	public ApplicationErrorsBean(EUserInterfaceErrors appErrors)
	{
		errorCode = appErrors.getErrorCode();
		getErrorMessageFromDatabase();
	}

	public int getErrorCode()
	{
		return errorCode ;
	}
   
	private void getErrorMessageFromDatabase()
	{
		errorMessageFromDB = new ErrorMessagesFromTheDB(getErrorCode());
		errorMSG = errorMessageFromDB.getErrorMessage();
	}
	
	
	public String getXMLError()
	
	{
	 XMLerror = new CreateErrorsXML();
	 XMLerror.setErrorCode(getErrorCode());	
	 XMLerror.setErrorMessage(errorMSG);
	 return XMLerror.getXMlErrorMessage();
	 
	
	}
    
	
}
