package elen7045.group5.project.notify;

public class APSErrorMessages {
	private int errorCode;
	
public APSErrorMessages(EApplicationErrors appErrors)
{
	errorCode = appErrors.getErrorCode();
}

public APSErrorMessages(EDataErrors appErrors)
{
	errorCode = appErrors.getErrorCode();
}

public APSErrorMessages(EScrapperSchedularErrors appErrors)
{
	errorCode = appErrors.getErrorCode();
}

public APSErrorMessages(EUserInterfaceErrors appErrors)
{
	errorCode = appErrors.getErrorCode();
}


}
