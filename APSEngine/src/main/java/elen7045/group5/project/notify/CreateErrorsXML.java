package elen7045.group5.project.notify;

public class CreateErrorsXML
{
	private CreateXMLHeaderandFooter	header;
	private ErrorDateTimeStamp			timeStamp;
	private String						ErrorXMLheader			= "Error";
	private String						errorCodeXMLName		= "ErrorCode";
	private final String				ErrorMessageXMLheader	= "ErrorMessage";
	private String						XMLError;
	private String						errorMessage;
	private int							errorCode;

	public CreateErrorsXML()
	{

		header = new CreateXMLHeaderandFooter();
		timeStamp = new ErrorDateTimeStamp();

		setXMlErrorMessage();
	}

	private String getErrorXMLName()
	{
		return ErrorXMLheader;
	}

	private String errorCodeXMLName()
	{
		return errorCodeXMLName;
	}

	private String getErrorMessageXMLName()
	{
		return ErrorMessageXMLheader;
	}

	public void setErrorCode(int code)
	{
		errorCode = code;
	}

	public int getErrorCode()
	{
		return errorCode;
	}

	public void setErrorMessage(String errorMSg)
	{
		errorMessage = errorMSg;
	}

	private void convertErrorCodetoString()
	{
		Integer.toString(errorCode);
	}

	private String getErrorMessage()
	{
		return errorMessage;
	}

	private void setXMlErrorMessage()
	{
		XMLError = header.createXMLHeader(getErrorXMLName()) +
				header.createXMLHeader(errorCodeXMLName()) +
				header.createXMLdata(Integer.toString(errorCode)) +
				header.createXMLFooter(errorCodeXMLName()) +
				header.createXMLHeader(timeStamp.getXMLName()) +
				header.createXMLdata(timeStamp.getSystemDateTime()) +
				header.createXMLFooter(timeStamp.getXMLName()) +
				header.createXMLHeader(getErrorMessageXMLName()) +
				header.createXMLdata(getErrorMessage()) +
				header.createXMLFooter(getErrorMessageXMLName()) +
				header.createXMLFooter(getErrorXMLName());
	}

	public String getXMlErrorMessage()
	{
		return XMLError;
	}
}
