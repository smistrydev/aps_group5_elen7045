package elen7045.group5.project.notify;

public class ErrorMessagesFromTheDB {
	 private String errorMessageFromDB;
	 private int errorCode;
	 
	    public ErrorMessagesFromTheDB(int errorCode)
	    {
	    	this.errorCode = errorCode;
	    }
	    
	    public String getErrorMessage()
	    {
	    	return errorMessageFromDB;
	    }
	    
	    private  void fetchErrorMessageFromDB()
	    {
	    //	errorMessageFromDB =
	    }
	    

}
